package Main;

public class EventHandler {
    private static Game game;
    private static GameWorld world;
    private static GameView view;
    private static Hero hero;
    private static HeroController controller;
    private static EventController controlRestart;
    /**
     * stores a high-score that remains even after the game is restarted
     */
    private static int highScore = 0;

    /**
     * initialize fields
     * @param g initializes this class's game field
     */
    public static void setFields(Game g) {
        game = g;
    }

    /**
     * initialize fields
     * @param w initializes this class's world field
     * @param v initializes this class's view field
     */
    public static void setFields(GameWorld w, GameView v) {
        world = w;
        view = v;
        hero = world.getHero();
    }

    /**
     * ends the current game
     * updates high score
     * activates keyboard controls for restarting the game
     */
    public static void callEnd() {
        game.timerStop();
        world.timerStop();
        Enemy.destroyAllEnemies();

        view.removeKeyListener(controller);
        hero.destroy();

        if (view.getScore() > highScore) {
            highScore = view.getScore();
        }
        view.setHighScore(highScore);

        view.setActiveGame(false);

        EventController controlRestart = new EventController();
        view.addKeyListener(controlRestart);
    }

    public static void updateTime() {
        if (view.getTime() > 0) {
            view.setTime(view.getTime() - 1);
        } else if (view.getTime() <= 0 ) {
            callEnd();
        }
    }

    public static void updateScore() {
        view.setScore(view.getScore() + 1);
    }

    /**
     * restart the game
     */
    public static void restart() {
        GameAudio.stopSound();

        Enemy.initialize();
        world.stop();

        Master.Master.callChapter();
    }
}