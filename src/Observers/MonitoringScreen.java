package Observers;

import Observables.WeatherMonitoringSystem;

public class MonitoringScreen {
    public MonitoringScreen(WeatherMonitoringSystem weatherMonitoringSystem) {
        System.out.println("MonitoringScreen was created");
        weatherMonitoringSystem.addTemperatureObserver(new MSTempObserver(this));
        weatherMonitoringSystem.addPressureObserver(new MSPressObserver(this));
    }

    public void displayTemperature(int data) {
        System.out.println("MonitoringScreen: temperature = " + data + " Celsius");
    }

    public void displayPressure(int data) {
        System.out.println("MonitoringScreen: pressure = " + data + " millibars");
    }
}
