package PreValidation;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

public class MotorBikeExist{
  final String file_name = "src/main/java//MotorBike.java";
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

  @Test
  void driveCarExist(){
    assertTrue(javaFile.hasMethodByName("driveCar"));
  }

  @Test
  void changeDrivingBehaviourExist(){
    assertTrue(javaFile.hasMethodByName("changeDrivingBehaviour"));
  }

  @Test
  void getMetersTravelledExist(){
    assertTrue(javaFile.hasMethodByName("getMetersTravelled"));
  }

  @Test
  void getNameExist(){
    assertTrue(javaFile.hasMethodByName("getRiderName"));
  }

  @Test
  void getManufacturerExist(){
    assertTrue(javaFile.hasMethodByName("getManufacturer"));
  }

  @Test
  void getDrivingBehaviourExist(){
    assertTrue(javaFile.hasMethodByName("getDrivingBehaviour"));
  }

  @Test
  void getWheelExist(){
    assertTrue(javaFile.hasMethodByName("getWheel"));
  }

  @Test
  void changeWheelExist(){
    assertTrue(javaFile.hasMethodByName("changeWheel"));
  }

}