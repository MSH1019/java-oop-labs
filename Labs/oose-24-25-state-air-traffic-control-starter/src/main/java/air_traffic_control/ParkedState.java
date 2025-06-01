package air_traffic_control;

public class ParkedState extends AirCraftState {

    public ParkedState(AirCraft airCraft) {
        this.airCraft = airCraft;
        this.stage = AirCraftStage.PARKED;
    }

    @Override
    public void setState() {
        airCraft.setState(airCraft.getFirstState());
    }

}
