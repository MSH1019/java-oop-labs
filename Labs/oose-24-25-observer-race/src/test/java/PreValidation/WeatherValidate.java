package PreValidation;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

public class WeatherValidate{
  final String file_name = "src/main/java//Weather.java";
  File file = new File(file_name);
  JavaFile javaFile = new JavaFile(file);

  @Test
  void registerObserverContainsAll(){
    String[] patterns = {"void","Observer"};
    assertTrue(javaFile.getMethodByName("registerObserver").containsAll(patterns));
  }

  @Test
  void removeObserverContainsAll(){
    String[] patterns = {"void","Observer"};
    assertTrue(javaFile.getMethodByName("removeObserver").containsAll(patterns));
  }

  @Test
  void getWeatherTypeContainsAll(){
    String[] patterns = {"WeatherType"};
    assertTrue(javaFile.getMethodByName("getWeatherType").containsAll(patterns));
  }

  @Test
  void notifyObserversContainsAll(){
    String[] patterns = {"void"};
    assertTrue(javaFile.getMethodByName("notifyObserver").containsAll(patterns));
  }

  @Test
  void changeWeatherContainsAll(){
    String[] patterns = {"void"};
    assertTrue(javaFile.getMethodByName("changeWeather").containsAll(patterns));
  }

}