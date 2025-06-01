package PreValidation;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

public class SubjectExist{
  final String file_name = "src/main/java//Subject.java";
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
  void notifyObserversExist(){
    assertTrue(javaFile.hasMethodByName("notifyObserver"));
  }

}