package PreValidation;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

public class MotorBikeValidate{
  final String file_name = "src/main/java//MotorBike.java";
  File file = new File(file_name);
  JavaFile javaFile = new JavaFile(file);

  @Test
  void updateContainsAll(){
    String[] patterns = {"void","WeatherType"};
    assertTrue(javaFile.getMethodByName("update").containsAll(patterns));
  }

  @Test
  void driveCarContainsAll(){
    String[] patterns = {"int"};
    assertTrue(javaFile.getMethodByName("driveCar").containsAll(patterns));
  }

  @Test
  void changeDrivingBehaviourContainsAll(){
    String[] patterns = {"void","Behaviour"};
    assertTrue(javaFile.getMethodByName("changeDrivingBehaviour").containsAll(patterns));
  }

  @Test
  void getMetersTravelledContainsAll(){
    String[] patterns = {"int"};
    assertTrue(javaFile.getMethodByName("getMetersTravelled").containsAll(patterns));
  }

  @Test
  void getNameContainsAll(){
    String[] patterns = {"String"};
    assertTrue(javaFile.getMethodByName("getRiderName").containsAll(patterns));
  }

  @Test
  void getManufacturerContainsAll(){
    String[] patterns = {"Manufacturer"};
    assertTrue(javaFile.getMethodByName("getManufacturer").containsAll(patterns));
  }

  @Test
  void getDrivingBehaviourContainsAll(){
    String[] patterns = {"Behaviour"};
    assertTrue(javaFile.getMethodByName("getDrivingBehaviour").containsAll(patterns));
  }

  @Test
  void getWheelContainsAll(){
    String[] patterns = {"Behaviour"};
    assertTrue(javaFile.getMethodByName("getWheel").containsAll(patterns));
  }

  @Test
  void changeWheelContainsAll(){
    String[] patterns = {"void","Behaviour"};
    assertTrue(javaFile.getMethodByName("changeWheel").containsAll(patterns));
  }

}