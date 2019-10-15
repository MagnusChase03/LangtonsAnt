import javax.swing.*;

public class Ant extends JFrame {

    private Ant() {
    
        createGUI();
        addPanel();
    
    }
    
    private void createGUI() {
    
        setTitle("Ant");
        setSize(800, 630);
        setResizable(false);
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
        setVisible(true);
    
    }
    
    private void addPanel() {
    
        Panel p = new Panel();
        Thread t = new Thread(p, "AntThread");
        add(p);
        t.start();
    
    }

    public static void main(String[] args) {
    
        new Ant();    
    
    }

}
