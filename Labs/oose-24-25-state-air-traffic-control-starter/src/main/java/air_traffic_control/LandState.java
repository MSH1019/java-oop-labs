package air_traffic_control;

public class LandState extends AirCraftState {



    private static LandState instance;

    private LandState(AirCraft airCraft) {
        this.airCraft = airCraft;
        this.stage = AirCraftStage.LAND;

    }

    @Override
    public void setState() {
        System.out.println("Finished");

    }
    
    public static LandState getInstance(AirCraft airCraft) {
        if(instance == null) {
            instance = new LandState(airCraft);
        }
        instance.airCraft = airCraft;
        return instance;
        
    }
    
}
