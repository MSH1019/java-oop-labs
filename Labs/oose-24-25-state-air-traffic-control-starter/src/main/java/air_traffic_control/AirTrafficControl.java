package air_traffic_control;

import java.util.List;
import java.util.ArrayList;

public class AirTrafficControl {

    private List<AirCraft> airCraftAtAirport = new ArrayList<AirCraft>();
    private AirCraftFactory airCraftFactory = new AirCraftFactory();

    public void add(AirCraft airCraft){
        airCraftAtAirport.add(airCraft);
        airCraft.setState(new ParkedState(airCraft));
    }


    public void add(AirCraftType type, String name, int distanceToTravel) {
        AirCraft airCraft = airCraftFactory.createAirCraft(type, name, distanceToTravel);
        add(airCraft); // use the already existing add method.
    } 


    public static void main(String[] args){
        AirTrafficControl airTrafficControl = new AirTrafficControl();

        airTrafficControl.add(AirCraftType.JUMBO_JET, "Henry", 50);

        AirCraft helicopter = new Helicopter("Helicopter", 200);
        helicopter.setState(helicopter.getFirstState());
        
        airTrafficControl.add(AirCraftType.AIR_LINER, "Boeing", 300);

    }
    
}
