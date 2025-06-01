package air_traffic_control;

public class Plane extends AirCraft {

    public Plane(String name, int distanceToTravel){
        super(name, distanceToTravel);
    }

    public AirCraftState getFirstState(){
        return new GoToRunwayState(this);
    }
    
}
