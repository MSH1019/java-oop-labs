public class CautiousDriving extends Behaviour{
    
    public CautiousDriving(){
        distanceForWeather.put(WeatherType.DRY, 12);
        distanceForWeather.put(WeatherType.MISTY, 10);
        distanceForWeather.put(WeatherType.WET, 10);

    }

    @Override
    public String toString(){
        return "Cautious Driving";
    }
}
