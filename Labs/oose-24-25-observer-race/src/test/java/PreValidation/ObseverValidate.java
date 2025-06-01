package PreValidation;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

public class ObseverValidate{
  final String file_name = "src/main/java//Observer.java";
  File file = new File(file_name);
  JavaFile javaFile = new JavaFile(file);

  @Test
  void updateContainsAll(){
    String[] patterns = {"void","WeatherType"};
    assertTrue(javaFile.getMethodByName("update").containsAll(patterns));
  }

}