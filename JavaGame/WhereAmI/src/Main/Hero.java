package Main;

import city.cs.engine.*;

/**
 * handles most aspects of the player-controlled character
 */
public class Hero extends Walker {
    /**
     * all the different images used for different states of the character
     */
    private static final BodyImage idleLeft =
            new BodyImage("data/Characters/hero/idle-left.gif", 10f);
    private static final BodyImage runLeft =
            new BodyImage("data/Characters/hero/run-left.gif", 10f);
    private static final BodyImage idleRight =
            new BodyImage("data/Characters/hero/idle-right.gif", 10f);
    private static final BodyImage runRight =
            new BodyImage("data/Characters/hero/run-right.gif", 10f);
    private static final BodyImage attackRight =
            new BodyImage("data/Characters/hero/attack-right.png", 10f);
    private static final BodyImage attackLeft =
            new BodyImage("data/Characters/hero/attack-left.png", 10f);

    /**
     * all the different shapes used for different states of the character
     * all shapes map to a corresponding image
     */
    private static final Shape idleLeftShape = new PolygonShape
            (-1.8f,2.56f, -2.68f,1.54f, -3.08f,-2.39f,
                    -1.8f,-4.93f, 2.24f,-5.0f, 6.27f,-4.86f, 0.75f,2.22f);
    private static final Shape runLeftShape = new PolygonShape
            (-2.34f,1.71f, -3.22f,-1.0f, -2.58f,-5.0f,
                    2.64f,-5.0f, 6.95f,-4.25f, 2.71f,-0.22f, -1.22f,1.85f);
    private static final Shape idleRightShape = new PolygonShape
            (-6.47f,-4.69f, -0.92f,2.22f, 1.59f,2.66f,
                    2.75f,1.51f, 3.02f,-2.53f, 1.9f,-4.97f, -2.2f,-5.0f);
    private static final Shape runRightShape = new PolygonShape
            (-6.98f,-4.32f, -2.61f,-5.0f, 2.64f,-5.0f,
                    3.02f,-1.03f, 2.24f,1.71f, 1.08f,1.92f, -3.8f,-0.66f, -6.95f,-3.98f);
    private static final Shape attackLeftShape = new PolygonShape
            (-7.93f,-0.73f, -1.83f,-5.03f, 3.9f,-5.0f,
                    4.1f,-4.12f, 0.71f,0.76f, -1.76f,1.31f);
    private static final Shape attackRightShape = new PolygonShape
            (-4.03f,-5.0f, 1.9f,-5.0f, 7.97f,-0.69f,
                    1.97f,1.31f, -0.95f,0.76f, -4.14f,-3.88f);

    private SolidFixture fixture;


    /**
     * create a new hero
     * @param world specifies a game world for the hero to reside in
     */
    public Hero(World world) {
        super(world);
        fixture = new SolidFixture(this, idleRightShape);
        addImage(idleRight);
        //setLineColor(Color.white);
        //setAlwaysOutline(true);
    }

    /**
     * whenever the character changes state, the image and shape is changed
     */
    public void startWalkLeft() {
        fixture.destroy();
        fixture = new SolidFixture(this, runLeftShape);
        removeAllImages();
        addImage(runLeft);
    }

    public void startWalkRight() {
        fixture.destroy();
        fixture = new SolidFixture(this, runRightShape);
        removeAllImages();
        addImage(runRight);
    }

    public void stopWalkLeft() {
        fixture.destroy();
        fixture = new SolidFixture(this, idleLeftShape);
        removeAllImages();
        addImage(idleLeft);
    }

    public void stopWalkRight() {
        fixture.destroy();
        fixture = new SolidFixture(this, idleRightShape);
        removeAllImages();
        addImage(idleRight);
    }

    public void attackRight() {
        fixture.destroy();
        fixture = new SolidFixture(this, attackRightShape);
        removeAllImages();
        addImage(attackRight);
    }

    public void attackLeft() {
        fixture.destroy();
        fixture = new SolidFixture(this, attackLeftShape);
        removeAllImages();
        addImage(attackLeft);
    }
}