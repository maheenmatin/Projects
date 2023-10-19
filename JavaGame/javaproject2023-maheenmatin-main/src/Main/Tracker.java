package Main;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;

/**
 * used to center the view on the player-controlled character
 */
public class Tracker implements StepListener {
    private GameView view;
    private Hero hero;

    public Tracker(GameView view, Hero hero) {
        this.hero = hero;
        this.view = view;
    }

    public void preStep(StepEvent e) {

    }
    public void postStep(StepEvent e) {
        view.setCentre(new Vec2(hero.getPosition()));
    }
}