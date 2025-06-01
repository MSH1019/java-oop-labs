package traffic_light;

public class GreenState implements ColourState{

    private TrafficLight trafficLight;
    public GreenState(TrafficLight trafficLight){
        this.trafficLight = trafficLight;
    }

    public void setState(){
        this.trafficLight.setColourState(new AmberState(this.trafficLight));
    }

    public String getColour(){
        return LightColour.GREEN.getColour();
    }
}
