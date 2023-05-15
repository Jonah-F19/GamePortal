import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

//import game.*;

public class MyPongPanel extends JPanel implements KeyListener{
    /*
     * Oh no! It seems like we have misplaced our Paddle class file
     * Could you recreate it, so we can play a friendly game of pong?
     * If you want to see how the code behaves,
     * you can comment out any code regarding the Paddle class.
     */


    Paddle one;
    Paddle two;
    Ball b;
    boolean gameOver = false;

    MyPongPanel() {
        one = new Paddle(40, 250);
        two = new Paddle(450, 250);
        b = new Ball(45);
        addKeyListener(this);
        setFocusable(true);
    }
    @Override
    protected void paintComponent(Graphics g) {
        // ignore this part
        super.paintComponent(g);

        // draw paddles
        one.draw(g);
        two.draw(g);

        // draw ball
        b.draw(g);
    }
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
       // throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }
    

    public void play() {
        while (gameOver == false){
        boolean inRightX = b.x + b.diameter >= two.x && b.x <= two.x + two.width;
        boolean inRightY = b.y <= two.y + two.length && b.y + b.diameter >= two.y;
        boolean inLeftX = b.x <= one.x + one.width;
        boolean inLeftY = b.y <= one.y + one.length && b.y + b.diameter >= one.y;
        boolean rightEdge = b.x + b.diameter >= getWidth(); 
        b.x += b.dx;
        b.y += b.dy;
            // move the ball a little bit

            if (inRightX && inRightY || inLeftY && inLeftX) {
                b.dx = -1 * b.dx;
            }

            // hit top or bottom
            if (b.y + b.diameter >= getHeight() || b.y < 0) {
                b.dy = -1 * b.dy;
            }

            // check for collision with paddles
            // TODO: CODE HERE

            repaint();

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if (rightEdge || b.x < 0){
                gameOver = true;
            }
        }
    }
    @Override
    public void keyPressed(KeyEvent e){
        if (e.getKeyChar() == 'w' && one.y > 0)
        one.y -= Paddle.STEP_FUNCTION;
        if (e.getKeyChar() == 's' && one.y + one.length < getHeight())
        one.y += Paddle.STEP_FUNCTION;
        if (e.getKeyChar() == 'i' && two.y > 0)
        two.y -= Paddle.STEP_FUNCTION;
        if (e.getKeyChar() == 'k' && two.y + two.length < getHeight())
        two.y += Paddle.STEP_FUNCTION;
    }
}