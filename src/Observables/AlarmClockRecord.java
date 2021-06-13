package Observables;

public class AlarmClockRecord {
    int interval;
    AlarmListener alarmListener;
    int time;

    public AlarmClockRecord(int interval, AlarmListener alarmListener) {
        this.interval = interval;
        this.alarmListener = alarmListener;
        this.time = 0;
    }
}
