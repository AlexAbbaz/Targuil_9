package Observers;

public class LogPressObserver implements Observer{
    public Log log;

    public LogPressObserver(Log log) {
        this.log = log;
        System.out.println("LogPressObserver was created");
    }

    @Override
    public void update(int data) {
        log.displayPressure(data);
    }

    @Override
    public String getName() {
        return "LogPressObserver";
    }
}
