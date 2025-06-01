package air_traffic_control;

public class ClimbOutState extends AirCraftState {

    public ClimbOutState(AirCraft plane) {
        this.airCraft = plane;
        this.stage = AirCraftStage.CLIMB_OUT;
    }

    @Override
    public void setState() {
        airCraft.setState(new CruiseState(airCraft));
    }

}