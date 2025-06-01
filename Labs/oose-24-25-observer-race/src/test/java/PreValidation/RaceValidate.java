package PreValidation;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

public class RaceValidate{
  final String file_name = "src/main/java//Race.java";
  File file = new File(file_name);
  JavaFile javaFile = new JavaFile(file);

  @Test
  void progressWeatherContainsAll(){
    String[] patterns = {"void"};
    assertTrue(javaFile.getMethodByName("progressWeather").containsAll(patterns));
  }

  @Test
  void changeCarBehaviourContainsAll(){
    String[] patterns = {"void","int","Behaviour"};
    assertTrue(javaFile.getMethodByName("changeCarBehaviour").containsAll(patterns));
  }

  @Test
  void RaceContainsAll(){
    String[] patterns = {"public","WeatherType","int"};
    assertTrue(javaFile.getMethodByName("Race").containsAll(patterns));
  }

  @Test
  void isFinishedContainsAll(){
    String[] patterns = {"boolean"};
    assertTrue(javaFile.getMethodByName("isFinished").containsAll(patterns));
  }

  @Test
  void makeFourCarsContainsAll(){
    String[] patterns = {"void"};
    assertTrue(javaFile.getMethodByName("makeFourCars").containsAll(patterns));
  }

}