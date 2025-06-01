package PreValidation;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

public class WeatherExist{
  final String file_name = "src/main/java//Weather.java";
  File file = new File(file_name);
  JavaFile javaFile = new JavaFile(file);

  @Test
  void fileExists() {
    assertTrue(file.isFile());
  }

  @Test
  void registerObserverExist(){
    assertTrue(javaFile.hasMethodByName("registerObserver"));
  }

  @Test
  void removeObserverExist(){
    assertTrue(javaFile.hasMethodByName("removeObserver"));
  }

  @Test
  void getWeatherTypeExist(){
    assertTrue(javaFile.hasMethodByName("getWeatherType"));
  }

  @Test
  void notifyObserversExist(){
    assertTrue(javaFile.hasMethodByName("notifyObserver"));
  }

  @Test
  void changeWeatherExist(){
    assertTrue(javaFile.hasMethodByName("changeWeather"));
  }

}