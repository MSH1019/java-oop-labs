package traffic_light;

public class RedState implements ColourState{

    private TrafficLight trafficLight;

    public RedState(TrafficLight trafficLight){
        this.trafficLight = trafficLight;
    }

    public void setState(){
        this.trafficLight.setColourState(new BlueState(this.trafficLight));
    }

    public String getColour(){
        return LightColour.RED.getColour();
    }
}
