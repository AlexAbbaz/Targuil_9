package Nimbus1;

import Observables.AlarmClock;
import Observables.Sensor;

public class Nimbus1TemepratureSensor extends Sensor {
    public Nimbus1TemepratureSensor() {
        super("temperature", 700);
    }

    @Override
    public int read() {
        return RandomSupplier.getRnd().nextInt(40);
    }
}
