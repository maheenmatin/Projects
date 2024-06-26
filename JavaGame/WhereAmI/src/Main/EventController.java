package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * this class handles the keyboard controls used to restart the game
 */

public class EventController implements KeyListener {


    public EventController() {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_R) {
            EventHandler.restart();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}