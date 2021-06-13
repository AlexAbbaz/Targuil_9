package Observables;

import Nimbus1.Nimbus1PressureSensor;
import Observers.Observer;

import java.util.LinkedList;
import java.util.List;

public class Observable {
    List<Observer> list = new LinkedList<>();

    public void notifyObservers(int data) {
        for (Observer item : list) {
            item.update(data);
            if (this.getClass() == Nimbus1PressureSensor.class) {
                if (item.getClass() == PressureTrendSensor.class) {
                    ((PressureTrendSensor) item).check();
                }
            }
        }
    }
}
