package PreValidation;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

public class RaceExist{
  final String file_name = "src/main/java//Race.java";
  File file = new File(file_name);
  JavaFile javaFile = new JavaFile(file);

  @Test
  void fileExists() {
    assertTrue(file.isFile());
  }

  @Test
  void progressWeatherExist(){
    assertTrue(javaFile.hasMethodByName("progressWeather"));
  }

  @Test
  void changeCarBehaviourExist(){
    assertTrue(javaFile.hasMethodByName("changeCarBehaviour"));
  }

  @Test
  void RaceExist(){
    assertTrue(javaFile.hasMethodByName("Race"));
  }

  @Test
  void isFinishedExist(){
    assertTrue(javaFile.hasMethodByName("isFinished"));
  }

  @Test
  void makeFourCarsExist(){
    assertTrue(javaFile.hasMethodByName("makeFourCars"));
  }

}