package traffic_light;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class TrafficLight {

    public ColourState colourState;

    public TrafficLight(){
    }

    public ColourState getColourState(){
        return this.colourState;
    }

    public void setColourState(ColourState colourState){
        this.colourState = colourState;
        System.out.println(this.colourState.getColour());
    }

    public void changeLight(){
        this.colourState.setState();
    }
;
    public void changeLights(int numberOfTimes){
        for (int counter = 0;counter < numberOfTimes;counter++){
            this.changeLight();
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

        }
    }


    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight();
        RedState redState = new RedState(trafficLight);
        trafficLight.setColourState(redState);
        trafficLight.changeLights(10);
    }

}
