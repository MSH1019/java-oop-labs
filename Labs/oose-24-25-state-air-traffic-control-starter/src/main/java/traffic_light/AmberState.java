package traffic_light;

public class AmberState implements ColourState{

    private TrafficLight trafficLight;

    public AmberState(TrafficLight trafficLight){
        this.trafficLight = trafficLight;
    }

    public void setState(){
        this.trafficLight.setColourState(new RedState(this.trafficLight));
    }

    public String getColour(){
        return LightColour.AMBER.getColour();
    }
}
