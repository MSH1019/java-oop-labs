package PreValidation;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

public class BeachLevelExist{
  final String file_name = "src/main/java//BeachLevel.java";
  File file = new File(file_name);
  JavaFile javaFile = new JavaFile(file);

  @Test
  void fileExists() {
    assertTrue(file.isFile());
  }

  @Test
  void generateLevelExist(){
    assertTrue(javaFile.hasMethodByName("generateLevel"));
  }

  @Test
  void calculateChallengeExist(){
    assertTrue(javaFile.hasMethodByName("calculateChallenge"));
  }

}