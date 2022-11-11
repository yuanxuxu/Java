package designpatterns.behavioral.observer.Weather;

/**
 * The observer pattern is a software design pattern in which an object, named
 * the subject, maintains a list of its dependents, called observers, and
 * notifies them automatically of any state changes, usually by calling one of
 * their methods.
 * 
 * The Observer Pattern defines a one-to-many dependency between
 * objects so that
 * when one object changes state, all of its dependents are notified and updated
 * automatically.
 */
public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay conditionsDisplay = new CurrentConditionsDisplay(weatherData);

        weatherData.setMeasurements(80, 65, 30.2f);
        weatherData.setMeasurements(82, 70, 31.2f);
        weatherData.setMeasurements(78, 90, 29.2f);

        weatherData.removeObserver(conditionsDisplay);

    }
}
