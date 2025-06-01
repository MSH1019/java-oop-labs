package air_traffic_control;

public class CruiseState extends AirCraftState{

    private static final int LANDING_DISTANCE = 50;
    private static final int CRUISING_SPEED = 50;


    public CruiseState(AirCraft airCraft) {
        this.airCraft = airCraft;
        this.stage = AirCraftStage.CRUISE;
    }


    @Override
    public void setState() {
        if(airCraft.getDistanceToTravel() <= LANDING_DISTANCE) {
            airCraft.setState(LandState.getInstance(airCraft)); //Use Singleton instance
        }else {
            airCraft.distanceToTravel -= CRUISING_SPEED; //Reduce distance by speed
            airCraft.setState(new CruiseState(airCraft));
        }
    }
    
}
