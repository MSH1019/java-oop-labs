import java.util.ArrayList;
import java.util.List;

public class IncidentDetection implements Subject{

    private static IncidentDetection instance = null;
    private List<Observer> observers;

    private IncidentDetection() {
        observers = new ArrayList<>();
    }


    public static IncidentDetection getInstance() {
        if (instance == null) {
            instance = new IncidentDetection();
        }
        return instance;
    }


    @Override
    public void registerObserver(Observer o) {
        if (o != null && !observers.contains(o)) {
            observers.add(o);
        }
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update(WeatherType.MISTY);
        }

    }

    public void reportCrash() {
        System.out.println("Crash detected");
        notifyObserver();
    }
    
}
