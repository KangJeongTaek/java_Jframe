import javax.swing.JFrame;

public class SystemMain extends JFrame{
    public SystemMain(){
        setTitle("System");
        setResizable(false);
        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setSize(600,300);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
