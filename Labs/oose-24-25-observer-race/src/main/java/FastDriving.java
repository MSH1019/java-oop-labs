public class FastDriving extends Behaviour {
    
    public FastDriving(){
        distanceForWeather.put(WeatherType.DRY, 20);
        distanceForWeather.put(WeatherType.MISTY, 5);
        distanceForWeather.put(WeatherType.WET, 8);

    }

    @Override
    public String toString(){
        return "Fast Driving";
    }
}
