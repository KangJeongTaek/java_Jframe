import javax.swing.JFrame;

public class Main {
    public static void main(String[] args){
        JFrame windows = new JFrame("Simple JFrame");
        windows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        windows.setResizable(false);
        
        Start_Panel pn = new Start_Panel();
        windows.add(pn);
        windows.pack();
        windows.setLocationRelativeTo(null);
        windows.setVisible(true);
        if(pn.signUpClick){
            windows.setFocusable(false);
        }
    }
}
