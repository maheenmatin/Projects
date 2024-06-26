package Main;

import city.cs.engine.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

/**
 * abstract class that all enemy types extend
 */

public abstract class Enemy extends Walker implements ActionListener, StepListener, CollisionListener {

    private final int SPEED = 10;
    private Random rand = new Random();
    private Boolean bool; //bool = true
    private Timer timer;
    private static boolean destroyEnemies;

    /**
     * creates a new enemy
     * randomly specifies left or right direction
     * destroys enemy after 10 seconds
     * @param world specifies a game world for the enemy to reside in
     */
    public Enemy(World world) {
        super(world);
        world.addStepListener(this);
        addCollisionListener(this);
        //setLineColor(Color.white);
        //setAlwaysOutline(true);

        timer = new Timer(10000, this);
        timer.setInitialDelay(10000);
        timer.start();

        bool = rand.nextBoolean();
        if (bool) {
            giveShapeRight();
            giveImageRight();
            startWalking(SPEED);
        }
        else {
            giveShapeLeft();
            giveImageLeft();
            startWalking(-SPEED);
        }
    }

    public abstract void giveShapeRight();
    public abstract void giveImageRight();

    public abstract void giveShapeLeft();
    public abstract void giveImageLeft();

    @Override
    public void actionPerformed(ActionEvent e) {
        this.destroy();
    }

    @Override
    public void preStep(StepEvent stepEvent) {
        if (destroyEnemies) {
            destroy();
        }
    }

    @Override
    public void postStep(StepEvent stepEvent) {
    }

    /**
     * destroys the enemy and updates the score
     * if the hero attacks the enemy
     */
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Hero && HeroController.getAttack()) {
            destroy();
            EventHandler.updateScore();
        }
    }

    /**
     * destroy all enemies at the end of the game
     */
    public static void destroyAllEnemies() {
        destroyEnemies = true;
    }

    /**
     * reinitialize variable that controls whether all enemies are destroyed or not
     */
    public static void initialize() {
        destroyEnemies = false;
    }
}