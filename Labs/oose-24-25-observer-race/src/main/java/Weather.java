import java.util.ArrayList;
import java.util.List;

public class Weather implements Subject {
	private List<Observer> observers;
	private WeatherType weatherType;

	public Weather(WeatherType weatherType) {
		observers = new ArrayList<>();
		this.weatherType = weatherType;
	}


	
	// For observers to pull the weather when notified or at creation
	public WeatherType getWeatherType() {
		return weatherType;
	}

	// Notify that there are changes to pull



	public void changeWeather() {
		weatherType = weatherType.next();
		notifyObserver();
	}



	@Override
	public void registerObserver(Observer o) {
		if(o!= null && !observers.contains(o)){
			observers.add(o);
		}
	}



	@Override
	public void removeObserver(Observer o) {
		observers.remove(o);
	}



	@Override
	public void notifyObserver() {
		for (Observer observer : observers){
			observer.update(weatherType);
		}
	}
}
