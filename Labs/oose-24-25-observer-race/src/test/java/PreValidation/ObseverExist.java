package PreValidation;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

public class ObseverExist{
  final String file_name = "src/main/java//Observer.java";
  File file = new File(file_name);
  JavaFile javaFile = new JavaFile(file);

  @Test
  void fileExists() {
    assertTrue(file.isFile());
  }

  @Test
  void updateExist(){
    assertTrue(javaFile.hasMethodByName("update"));
  }

}