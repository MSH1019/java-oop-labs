package PreValidation;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

public class SubjectValidate{
  final String file_name = "src/main/java//Subject.java";
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
  void notifyObserversContainsAll(){
    String[] patterns = {"void"};
    assertTrue(javaFile.getMethodByName("notifyObserver").containsAll(patterns));
  }

}