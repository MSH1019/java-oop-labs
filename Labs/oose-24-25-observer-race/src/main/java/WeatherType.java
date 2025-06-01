public enum WeatherType {
    DRY, MISTY, WET;

    public WeatherType next(){
        return values()[(ordinal()+1)%3];
    }
}
