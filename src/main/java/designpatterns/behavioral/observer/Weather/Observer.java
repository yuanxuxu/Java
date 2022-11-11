package designpatterns.behavioral.observer.Weather;

public interface Observer {
    public void update(float temperature, float humidity, float pressure);
}
