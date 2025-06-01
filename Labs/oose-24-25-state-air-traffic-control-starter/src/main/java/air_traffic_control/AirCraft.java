package air_traffic_control;

import java.util.List;
import java.util.ArrayList;

public abstract class AirCraft {
    private AirCraftState airCraftState;
    private String name;
    private List<AirCraftState> states = new ArrayList<AirCraftState>();
    protected int counter = 0;
    protected final static int MAX_STATES = 10;
    protected int distanceToTravel = 0;

    public AirCraft(String name, int distanceToTravel) {
        this.name = name;
        this.distanceToTravel = distanceToTravel;
    }

    public int getDistanceToTravel() {
        return distanceToTravel;
    }

    public int getCounter() {
        return counter;
    }

    public AirCraftState getAirCraftState() {
        return airCraftState;
    }

    public List<AirCraftState> getStates() {
        return states;
    }

    public void setState(AirCraftState airCraftState) {
        this.airCraftState = airCraftState;
        states.add(airCraftState);
        System.out.println(name + " " + airCraftState.getStage());
        try {
            Thread.sleep(300);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        if (counter < MAX_STATES) {
            this.airCraftState.setState();
        }
        counter++;
    }

    abstract public AirCraftState getFirstState();
}

