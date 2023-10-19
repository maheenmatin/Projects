package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * handles all keyboard controls for the player-controlled character
 */

public class HeroController implements KeyListener {

    private static Hero hero;

    /**
     * left specifies the direction the character is facing
     * used before and after the character attacks, in order to select the correct method in the Hero class
     * i.e. used for selecting the correct image/animation
     */
    private static boolean left = false;
    /**
     * run specifies whether the character is moving or not
     * used after the character attacks, in order to select the correct method in the Hero class
     * i.e. used for selecting the correct image/animation
     */
    private static boolean run = false;
    /**
     * attack specifies whether the character is an attack state or not
     * used in the GameWorld and Enemy classes for collision detection
     */
    private static boolean attack = false;

    public static boolean getAttack() {
        return attack;
    }

    public HeroController(Hero s) {
        hero = s;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    /**
     * calls the appropriate method in the Hero class whenever a key is pressed
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            hero.jump(25);
        } else if (code == KeyEvent.VK_A) {
            left = true;
            run = true;

            hero.startWalkLeft();
            hero.startWalking(-25);
        } else if (code == KeyEvent.VK_D) {
            left = false;
            run = true;

            hero.startWalkRight();
            hero.startWalking(25);
        } else if (code == KeyEvent.VK_S) {
            attack = true;
            if (left) {
                hero.attackLeft();
            }
            else {
                hero.attackRight();
            }
        }
    }

    /**
     * calls the appropriate method in the Hero class whenever a key is released
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_A) {
            run = false;

            hero.stopWalkLeft();
            hero.startWalking(0);
        } else if (code == KeyEvent.VK_D) {
            run = false;

            hero.stopWalkRight();
            hero.startWalking(0);
        } else if (code == KeyEvent.VK_S) {
            attack = false;

            if (left && !run) {
                hero.stopWalkLeft();
            }
            else if (!left && !run){
                hero.stopWalkRight();
            }
            else if (left && run) {
                hero.startWalkLeft();
            }
            else if (!left && run) {
                hero.startWalkRight();
            }
        }
    }
}