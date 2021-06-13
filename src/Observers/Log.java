package Observers;

import Observables.Trend;
import Observables.WeatherMonitoringSystem;

public class Log {
    public Log(WeatherMonitoringSystem weatherMonitoringSystem) {
        System.out.println("Log was created");
        weatherMonitoringSystem.addPressureObserver(new LogPressObserver(this));
        weatherMonitoringSystem.addPressureTrendObserver(new LogPressTrendObserver(this));
    }

    public void displayPressure(int data) {
        System.out.println("Log: pressure = " + data + " millibars");
    }

    public void displayPressureTrend(int trend) {
        switch (trend) {
            case 0:
                System.out.println("Log: pressure trend = " + Trend.STABLE);
                break;
            case 1:
                System.out.println("Log: pressure trend = " + Trend.FALLING);
                break;
            case 2:
                System.out.println("Log: pressure trend = " + Trend.RISING);
                break;
            default:
                System.out.println("ERROR");
        }
    }
}
