package air_traffic_control;

public class Helicopter extends AirCraft{


    public Helicopter(String name, int distanceToTravel) {
        super(name, distanceToTravel);
    }

    @Override
    public AirCraftState getFirstState() {
        return new AirDistanceState(this); //Start with AirDistanceState
    }
}
