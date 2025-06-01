package air_traffic_control;

public abstract class AirCraftState {

    protected AirCraftStage stage;
    protected AirCraft airCraft;

    public void setAirCraft(AirCraft airCraft) {
        this.airCraft = airCraft;
    }

    public abstract void setState();

    public AirCraftStage getStage() {
        return stage;
    }
}
