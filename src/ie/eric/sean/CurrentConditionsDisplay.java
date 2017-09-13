package ie.eric.sean;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by smcgrath on 13/09/2017.
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {
    Observable observable;
    private float temperature;
    private float humidity;


    public CurrentConditionsDisplay(Observable observable){
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable obs, Object arg) {
        if(obs instanceof WeatherData){
            WeatherData weatherData = (WeatherData)obs;
            temperature = weatherData.getTemperature();
            humidity = weatherData.getHumidity();
            display();
        }

    }
    @Override
    public void display() {
        System.out.println("Current conditions: " + temperature + "F degree and " + humidity + "% humidity");
    }
}
