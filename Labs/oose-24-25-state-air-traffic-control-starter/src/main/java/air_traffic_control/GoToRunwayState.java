package air_traffic_control;

public class GoToRunwayState extends AirCraftState {

    public GoToRunwayState(AirCraft plane) {
        this.airCraft = plane;
        this.stage = AirCraftStage.GO_TO_RUNWAY;
    }

    @Override
    public void setState() {
        airCraft.setState(new GroundRollState(airCraft));
    }
}
