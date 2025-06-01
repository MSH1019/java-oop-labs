package utility;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntToWordTest {
    
    @Test
    void testConvertToWord1(){
        assertEquals("one", IntToWord.convertIntToWord(1));
    }

    @Test
    void testConvertToWord2(){
        assertEquals("two", IntToWord.convertIntToWord(2));
    }

    @Test
    void testConvertToWord3(){
        assertEquals("three", IntToWord.convertIntToWord(3));
    }

    @Test
    void testConvertToWord9(){
        assertEquals("nine", IntToWord.convertIntToWord(9));
    }

    @Test
    void testConvertToWord20(){
        assertEquals("twenty", IntToWord.convertIntToWord(20));
    }

    @Test
    void testConvertToWord30(){
        assertEquals("thirty", IntToWord.convertIntToWord(30));
    }

    @Test
    void testConvertToWord32(){
        assertEquals("thirty two", IntToWord.convertIntToWord(32));
    }
}

