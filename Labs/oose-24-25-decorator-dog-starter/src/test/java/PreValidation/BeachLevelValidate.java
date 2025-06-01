package PreValidation;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

public class BeachLevelValidate{
  final String file_name = "src/main/java//BeachLevel.java";
  File file = new File(file_name);
  JavaFile javaFile = new JavaFile(file);

  @Test
  void generateLevelContainsAll(){
    String[] patterns = {"String"};
    assertTrue(javaFile.getMethodByName("generateLevel").containsAll(patterns));
  }

  @Test
  void calculateChallengeContainsAll(){
    String[] patterns = {"int"};
    assertTrue(javaFile.getMethodByName("calculateChallenge").containsAll(patterns));
  }

}