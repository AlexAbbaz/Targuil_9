package Observers;

public class MSPressObserver implements Observer{
    public MonitoringScreen monitoringScreen;

    public MSPressObserver(MonitoringScreen monitoringScreen) {
        this.monitoringScreen = monitoringScreen;
        System.out.println("MSPressObserver was created");
    }

    @Override
    public void update(int data) {
        monitoringScreen.displayPressure(data);
    }

    @Override
    public String getName() {
        return "MSPressObserver";
    }
}
