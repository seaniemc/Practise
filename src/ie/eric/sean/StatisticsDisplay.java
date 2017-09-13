package ie.eric.sean;

import java.util.*;

/**
 * Created by smcgrath on 13/09/2017.
 */
public class StatisticsDisplay implements Observer, DisplayElement{

    Observable observable;
    private float maxTemp = 0.0f;
    private float minTemp = 200;
    private float tempSum= 0.0f;
    int numOfUpdates;

    public StatisticsDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);

    }

    public void update(Observable obs, Object arg) {
        if(obs instanceof WeatherData){
            WeatherData weatherData = (WeatherData)obs;
            float temp = weatherData.getTemperature();
            tempSum += temp;
            numOfUpdates ++;

            if(temp > maxTemp){
                maxTemp = temp;
            }
            if(temp < minTemp){
                minTemp = temp;
            }

            display();
        }
    }
    public void display() {

        System.out.println("Avg/Max/Min temperature = " + (tempSum / numOfUpdates)
                + "/" + maxTemp + "/" + minTemp);
    }


}
