package Nimbus1;

import Observables.Sensor;

public class Nimbus1PressureSensor extends Sensor {
    public Nimbus1PressureSensor() {
        super("pressure", 1050);
    }

    @Override
    public int read() {
        return RandomSupplier.getRnd().nextInt(100) + 950;
    }
}
