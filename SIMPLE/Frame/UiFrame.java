package Frame;

import javax.swing.JFrame;
import EXE.TimeThread;
public class UiFrame extends JFrame{
    UiFrame(){

    
    TimeThread timeThread = new TimeThread();
    Thread thread = new Thread(timeThread);
    thread.start();
}
}
