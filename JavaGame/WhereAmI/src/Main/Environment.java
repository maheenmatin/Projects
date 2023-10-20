package Main;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

public abstract class Environment extends StaticBody{

    /**
     * used as a debugger to create a white outline for all environment objects
     * @param w specifies the game world that the environment object will reside in
     * @param shape specifies the shape that the environment object will take
     */
    public Environment(World w, Shape shape) {
        super(w, shape);
        //setLineColor(Color.white);
        //setAlwaysOutline(true);
    }

    @Override
    public Vec2 getPosition() {
        return super.getPosition();
    }
}