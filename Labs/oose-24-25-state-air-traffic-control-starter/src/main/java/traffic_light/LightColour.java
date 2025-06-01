package traffic_light;

public enum LightColour {
    RED("Red"),
    AMBER("Amber"),
    GREEN("Green"),
    BLUE("Blue");

    private LightColour(String colour){
        this.colour = colour;
    }

    private final String colour;

    public String getColour(){
        return colour;
    }

}
