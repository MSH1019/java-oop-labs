import java.util.HashMap;
import java.util.Map;

public class Behaviour {
	protected final int distanceDefault = 10;
	protected Map<WeatherType,Integer> distanceForWeather = new HashMap<>();

	public int distanceTraveledInWeather(WeatherType weatherType) {
		return distanceForWeather.getOrDefault(weatherType, distanceDefault);
	}
}
