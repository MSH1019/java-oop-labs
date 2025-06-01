import java.util.List;

public class MotorBike implements Observer {

	private int metersTravelled = 0;
	private Manufacturer manufacturer;
	private Rider rider;
	private Behaviour drivingBehaviour;
	private Behaviour wheel;
	private WeatherType weatherType;

	public MotorBike(Manufacturer manufacturer, Rider rider, Behaviour drivingBehaviour, Weather raceWeather) {
		this.manufacturer = manufacturer;
		this.rider = rider;
		this.drivingBehaviour = drivingBehaviour;
		this.weatherType = raceWeather.getWeatherType();
		IncidentDetection.getInstance().registerObserver(this);

	}

	public void update(WeatherType weatherType) {
		this.weatherType = weatherType;
		if (weatherType == WeatherType.MISTY) {
			System.out.println(rider.getName() + " is switching to Cautious Driving.");
			this.changeDrivingBehaviour(new CautiousDriving());
		}
	}

	public int driveBike() {
		int distance = drivingBehaviour.distanceTraveledInWeather(weatherType);

		if(wheel != null) {
			distance += wheel.distanceTraveledInWeather(weatherType);
		}
		distance = Math.max(0, distance);
		metersTravelled += distance;
		return distance;
	}

	public void changeDrivingBehaviour(Behaviour newDrivingBehaviour) {
		this.drivingBehaviour = newDrivingBehaviour;
	}

	public void changeWheel(Behaviour wheel) {
		this.wheel = wheel;
	}

	public int getMetersTravelled() {
		return metersTravelled;
	}

	public String getRiderName() {
		return rider.getName();
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public Behaviour getDrivingBehaviour() {
		return drivingBehaviour;
	}

	public Behaviour getWheel() {
		return wheel;
	}

	public WeatherType getWeatherType() {
		return weatherType;
	}

	public void crash() {
		System.out.println(rider.getName() + "crashed");
		IncidentDetection.getInstance().reportCrash();
	}
	

	public String toString() {
		return rider.getName() + " built by " + manufacturer + " has travelled " + metersTravelled + " meters";
	}

	
}
