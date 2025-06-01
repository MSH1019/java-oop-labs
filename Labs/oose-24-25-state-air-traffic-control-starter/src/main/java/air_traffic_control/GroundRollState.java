package air_traffic_control;

public class GroundRollState extends AirCraftState {

    public GroundRollState(AirCraft plane) {
        this.airCraft = plane;
        this.stage = AirCraftStage.GROUND_ROLL;
    }

    @Override
    public void setState() {
        airCraft.setState(new AirDistanceState(airCraft));
    }

}
