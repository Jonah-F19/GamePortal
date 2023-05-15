import java.io.File;

import javax.swing.*;
/** 
 * Irene Feng
 * Multi-class Files - MiniLab
 */
public class Main implements Game {

    public static void main(String[] args) throws InterruptedException {
    }
    public void play(){
        JFrame frame = new JFrame("Play");
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        MyPongPanel panel = new MyPongPanel();
        frame.add(panel);
        
        frame.setSize(500,500);
		frame.setVisible(true);

        panel.play();
    }
    public String getGameName() {
        return "PongPaddle";
     }
     public String getScore() {
         return null;
     }
    public void writeHighScore(File file) {
      return;
    }
}