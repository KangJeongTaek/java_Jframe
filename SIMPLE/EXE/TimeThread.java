package EXE;
public class TimeThread implements Runnable {
    private Thread timeThread;
    private long time;
    private int minute;
    public TimeThread() {
        timeThread = new Thread(this);
        timeThread.start();
    }
    public int getMinute() {
        return minute;
    }

    @Override
    public void run() {
        long nanoPerSecond = 1000000000;
        long lastTime = System.nanoTime();
        while (true) { 
            long currentTime = System.nanoTime();
            if (currentTime - lastTime >= nanoPerSecond) {
                time++;
                if(time == 60){
                    minute ++;
                    time = 0;
                }
                lastTime = currentTime;
            }
        }
    }
}