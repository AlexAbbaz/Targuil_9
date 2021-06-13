package Observers;

public class MSTempObserver implements Observer{
    public MonitoringScreen monitoringScreen;

    public MSTempObserver(MonitoringScreen monitoringScreen) {
        this.monitoringScreen = monitoringScreen;
        System.out.println("MSTempObserver was created");
    }

    @Override
    public void update(int data) {
        monitoringScreen.displayTemperature(data);
    }

    @Override
    public String getName() {
        return "MSTempObserver";
    }
}
