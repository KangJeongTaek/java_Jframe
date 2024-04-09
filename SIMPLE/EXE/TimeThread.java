package EXE;
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
        while (true) { 
            long currentTime = System.nanoTime();
            if (currentTime - lastTime >= nanoPerSecond) {
                time++;
                System.out.println(time);
                lastTime = currentTime;
            }
        }
    }
}