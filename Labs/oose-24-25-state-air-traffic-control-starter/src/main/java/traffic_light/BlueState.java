package traffic_light;

public class BlueState implements ColourState{

    private TrafficLight trafficLight;

    public BlueState(TrafficLight trafficLight){
        this.trafficLight = trafficLight;
    }

    @Override
    public void setState() {
        trafficLight.setColourState(new GreenState(trafficLight));
    }

    @Override
    public String getColour() {
        return LightColour.BLUE.getColour();
    }
    
}
