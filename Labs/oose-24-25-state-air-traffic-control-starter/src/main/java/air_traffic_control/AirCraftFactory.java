package air_traffic_control;

public class AirCraftFactory {
    
    public AirCraft createAirCraft(AirCraftType type, String name, int distanceToTravel){
        switch(type){
            case JUMBO_JET:
                return new JumboJet(name, distanceToTravel);
            case HELICOPTER:
                return new Helicopter(name, distanceToTravel);
            case AIR_LINER:
                return new AirLiner(name, distanceToTravel);
            default:
                throw new IllegalArgumentException("Unknown Aircraft type: " + type);
        }
    }
}
