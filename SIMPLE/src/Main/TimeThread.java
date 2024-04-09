package Main;
public class TimeThread implements Runnable {
    private Thread timeThread;
    private long time;

    public TimeThread() {
        timeThread = new Thread(this);
        timeThread.start();
    }

    @Override
    public void run() {
        long nanoPerSecond = 1000000000;
        long lastTime = System.nanoTime();
        while (true) { // Infinite loop to keep the thread running
            long currentTime = System.nanoTime();
            if (currentTime - lastTime >= nanoPerSecond) { // Check if 1 second has passed
                time++;
                System.out.println("Time: " + time + " seconds");
                lastTime = currentTime;
            }
        }
    }
}