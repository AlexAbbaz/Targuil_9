package Observables;

import Nimbus1.Nimbus1Clock;
import Nimbus1.Nimbus1PressureSensor;
import Nimbus1.Nimbus1TemepratureSensor;
import Observers.*;

public class WeatherMonitoringSystem {
    protected static WeatherMonitoringSystem instance = null;
    public SensorAlarmListener sensorAlarmListenerTemp;
    public SensorAlarmListener sensorAlarmListenerPress;
    public PressureTrendSensor pressureTrendSensor;

    protected WeatherMonitoringSystem() {
        System.out.println("WeatherMonitoringSystem was created");
        AlarmClock alarmClock = Nimbus1Clock.theInstance();
        sensorAlarmListenerTemp = new SensorAlarmListener(new Nimbus1TemepratureSensor());
        sensorAlarmListenerPress = new SensorAlarmListener(new Nimbus1PressureSensor());
        pressureTrendSensor = new PressureTrendSensor();

        alarmClock.register(sensorAlarmListenerPress.sensor.interval, sensorAlarmListenerPress);
        System.out.println(sensorAlarmListenerPress.sensor.type + " registered to clock");
        alarmClock.register(sensorAlarmListenerTemp.sensor.interval, sensorAlarmListenerTemp);
        System.out.println(sensorAlarmListenerTemp.sensor.type + " registered to clock");
        sensorAlarmListenerPress.sensor.list.add(pressureTrendSensor);
        System.out.println(pressureTrendSensor.getName() + " observes " + sensorAlarmListenerPress.sensor.type);

    }

    public static WeatherMonitoringSystem theInstance() {
        if (null == instance)
            instance = new WeatherMonitoringSystem();
        return instance;
    }

    public void addTemperatureObserver(Observer obs) {
        sensorAlarmListenerTemp.sensor.list.add(obs);
        System.out.println(obs.getName() + " observes " + sensorAlarmListenerTemp.sensor.type);
    }

    public void addPressureObserver(Observer obs) {
        sensorAlarmListenerPress.sensor.list.add(obs);
        System.out.println(obs.getName() + " observes " + sensorAlarmListenerPress.sensor.type);
    }

    public void addPressureTrendObserver(Observer obs) {
        pressureTrendSensor.list.add(obs);
        System.out.println(obs.getName() + " observes " + pressureTrendSensor.getName());
    }
}
