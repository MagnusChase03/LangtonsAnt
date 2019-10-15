import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel implements Runnable {

    private Color[][] grid;
    private int x;
    private int y;
    private int direction;

    Panel() {
    
        grid = new Color[37][50];
        
        for (int i = 0; i < grid.length; i++) {
        
            for (int j = 0; j < grid[i].length; j++) {
            
                grid[i][j] = Color.WHITE;
            
            }
        
        }
        
        x = 25;
        y = 18;
        direction = 90;
    
    }
    
    private void update() {
    
        if (grid[y][x].equals(Color.WHITE)) {
        
            direction += 90;
            grid[y][x] = Color.RED;
        
        } else if (grid[y][x].equals(Color.RED)) {
        
            direction -= 90;
            grid[y][x] = Color.WHITE;
        
        }
        
        if (direction > 360) {
        
            direction -= 360;
        
        } else if (direction <= 0) {
        
            direction += 360;
        
        }
        
        switch (direction) {
        
            case 90:
                x++;
                break;
                
            case 180:
                y++;
                break;
                
            case 270:
                x--;
                break;
                
            case 360:
                y--;
                break;
        
        }
    
    }
    
    public void run() {
    
        while (true) {
        
            try {
            
                Thread.sleep(500);
                update();
                repaint();
            
            } catch (InterruptedException ignored) {}

        
        }
    
    }
    
    public void paint(Graphics g) {
    
        for (int i = 0; i < grid.length; i++) {
        
            for (int j = 0; j < grid[i].length; j++) {
            
                g.setColor(Color.BLACK);
                g.fillRect(j * 16, i * 16, 16, 16);
            
                g.setColor(grid[i][j]);
                g.fillRect(j * 16 + 2, i * 16 + 2, 12, 12);
            
            }
        
        }
    
    }

}
