package Observables;

public abstract class Sensor extends Observable{
    public int lastReading;
    public int interval;
    public String type;

    public Sensor(String type, int interval) {
        this.type = type;
        this.interval = interval;
    }

    public abstract int read();
    public void check() {
        int value = read();
        if(value != lastReading)
            notifyObservers(value);
        lastReading = value;
    }
}
