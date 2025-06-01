package communication;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;

import org.junit.jupiter.api.Test;

import card.entity.Card;
import card.entity.Hand;
import card.entity.Player;
import utility.LoadCSV;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.withSettings;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

import java.util.List;
import java.util.Arrays;


public class MockConsoleInOutTest{

    Scanner mockScanner = mock(Scanner.class);
    ConsoleInOut consoleInOut = new ConsoleInOut();

    @BeforeEach
    void setUp(){
        consoleInOut.setScanner(mockScanner);
    }

    @Test
    void testGetInteger(){
        when(mockScanner.nextLine()).thenReturn("2");
        assertEquals(2, consoleInOut.getInteger());
    }

    @Test
    void testGetInputInteger(){
        when(mockScanner.nextLine()).thenReturn("2");
        assertEquals(2, consoleInOut.getInputInteger("Enter Number: "));
    }

    @Test
    void testGetInputIntegerSecondTime(){
        when(mockScanner.nextLine()).thenReturn("Del", "2");
        consoleInOut.setScanner(mockScanner);
        assertEquals(2, consoleInOut.getInputInteger("Enter Number: "));

    }

    @Test
    void testGetListIndex(){
        List<String> list = Arrays.asList("One", "Two");
        when(mockScanner.nextLine()).thenReturn("1");
        consoleInOut.setScanner(mockScanner);
        assertEquals(1, consoleInOut.getListIndex(list));
    }


    @Test
    void testGetListIndexSecondTime(){
        List<String> list = Arrays.asList("One", "Two");
        when(mockScanner.nextLine()).thenReturn("3", "1");
        consoleInOut.setScanner(mockScanner);
        assertEquals(1, consoleInOut.getListIndex(list));
    }

    @Test
    void testGetListIndexWithQuestion(){
        List<String> list = Arrays.asList("One", "Two");
        when(mockScanner.nextLine()).thenReturn("1");
        consoleInOut.setScanner(mockScanner);
        assertEquals(1, consoleInOut.getListIndex("please choose an option: ", list));
    }

    @Test
    void testGetPlayersCard() {
        Player mockPlayer = mock(Player.class);
        when(mockScanner.nextLine()).thenReturn("1");
        when(mockPlayer.playACard(1)).thenReturn(new Card("C4"));
        consoleInOut.setScanner(mockScanner);
        assertEquals("C4",  consoleInOut.getPlayersCard(mockPlayer).toString());
    }


    @Test
    void testGetYesOrNoYes() {
        when(mockScanner.nextLine()).thenReturn("Yes");
        consoleInOut.setScanner(mockScanner);
        assertEquals(YesOrNo.YES, consoleInOut.getYesOrNo("is it yes or no"));
    } 

    @Test
    void testGetYesOrNoY(){
        when(mockScanner.nextLine()).thenReturn("Y");
        consoleInOut.setScanner(mockScanner);
        assertEquals(YesOrNo.YES, consoleInOut.getYesOrNo("is it yes or no"));
    }

    @Test
    void testGetYesOrNoNo(){
        when(mockScanner.nextLine()).thenReturn("N");
        consoleInOut.setScanner(mockScanner);
        assertEquals(YesOrNo.NO, consoleInOut.getYesOrNo("is it yes or no"));
    }


    @Test
    void testGetRows() {
        LoadCSV loadCSV = new LoadCSV();
        Scanner mockScanner = mock(Scanner.class);
        when(mockScanner.hasNextLine()).thenReturn(true, true, false);
        when(mockScanner.nextLine()).thenReturn("Name,Age,Nationality", "Alice,25,Libyan");
        loadCSV.setCSVReader(mockScanner, "fakefile.csv");
        List<String> rows = loadCSV.getRows("fakefile.csv");

        assertEquals(2, rows.size());
        assertEquals("Name,Age,City", rows.get(0));
        assertEquals("Alice,25,New York", rows.get(1));
}

    @Test
    void testGetCSVRows() {
        LoadCSV loadCSV = new LoadCSV();
        Scanner mockScanner = mock(Scanner.class);

        when(mockScanner.hasNextLine()).thenReturn(true, true, false);
        when(mockScanner.nextLine()).thenReturn("Name,Age,Nationality", "Mohamed,21,Libyan");

        loadCSV.setCSVReader(mockScanner, "fakefile.csv");
        List<String[]> rows = loadCSV.getCSVRows("fakefile.csv");

        assertEquals(2, rows.size());
        assertArrayEquals(new String[]{"Name", "Age", "Nationality"}, rows.get(0));
        assertArrayEquals(new String []{"Mohamed", "21", "Libyan"}, rows.get(1));
    }




}

