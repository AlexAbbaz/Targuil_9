package Observers;

public class LogPressTrendObserver implements Observer{
    public Log log;

    public LogPressTrendObserver(Log log) {
        this.log = log;
        System.out.println("LogPressTrendObserver was created");
    }
    @Override
    public void update(int data) {
        log.displayPressureTrend(data);
    }

    @Override
    public String getName() {
        return "LogPressTrendObserver";
    }
}
