package air_traffic_control;

public class AirDistanceState extends AirCraftState {

    public AirDistanceState(AirCraft plane) {
        this.airCraft = plane;
        this.stage = AirCraftStage.AIR_DISTANCE;
    }

    @Override
    public void setState() {
        airCraft.setState(new ClimbOutState(airCraft));
    }

}
