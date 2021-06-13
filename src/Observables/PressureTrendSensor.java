package Observables;

import Observers.Observer;

public class PressureTrendSensor extends Observable implements Observer {
    public int lastReading1;
    public int lastReading2;
    public int lastReading3;
    public Trend pressureTrend;
    public Trend lastState;

    public PressureTrendSensor() {
        lastReading1 = lastReading2 = lastReading3 = 0;
        pressureTrend = Trend.STABLE;
        lastState = null;
    }

    public Trend calc() {
        if (lastReading1 < lastReading2 && lastReading2 < lastReading3)
            return Trend.FALLING;
        if (lastReading1 > lastReading2 && lastReading2 > lastReading3)
            return Trend.RISING;
        return Trend.STABLE;
    }

    public void check() {
        Trend value = calc();
        if(value != lastState && lastReading1 != 0 && lastReading2 != 0 && lastReading3 != 0)
            notifyObservers(value.ordinal());
        lastState = value;
    }

    @Override
    public void update(int value) {
        lastReading3 = lastReading2;
        lastReading2 = lastReading1;
        lastReading1 = value;
    }

    @Override
    public String getName() {
        return "PressureTrendSensor";
    }
}
