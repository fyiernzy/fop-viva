package Tools;

public class Timer {
    public static final int DEFAULT_TIME = 250;

    public static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            System.out.println("Timer.sleep() interrupted");
        }
    }

    public static void sleep() {
        Timer.sleep(DEFAULT_TIME);
    }
}
