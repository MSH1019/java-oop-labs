public class ThinWheel extends Behaviour{
    

    public ThinWheel(){
        distanceForWeather.put(WeatherType.DRY, +2);
        distanceForWeather.put(WeatherType.MISTY, 0);
        distanceForWeather.put(WeatherType.WET, -2);

    }

    @Override
    public String toString() {
        return "ThinWheel []";
    }
}
