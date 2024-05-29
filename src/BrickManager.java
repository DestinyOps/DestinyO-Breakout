package breakout;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsObject;

public class BrickManager {

    private CanvasWindow canvas;
    private List<Brick> bricks;
   

    public BrickManager(CanvasWindow canvas){
        bricks = new ArrayList<>();
        this.canvas = canvas;
    }

    /*
 * Genereates the brick wall
 */
    public void generateBricks(){
        double x = 10;
        double y = 10;
        double height = 40;
        double width = 40;
        Random rand = new Random();
        
       
        for (int i = 0; i < 7; i++){
            y = y + 45;
            x = 10;
            Color color = new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
            for(int j = 0; j < 8; j++){
            Brick brick = new Brick(x,y,width, height, color);
            x = x + 50;
            brick.setPosition(x, y);
            canvas.add(brick);
            bricks.add(brick);
            }

        }
    }

/*
 * Removes the brick from the wall
 */

    public void popBrick(Brick brick) {
        canvas.remove(brick);
        bricks.remove(brick);
    }

/*
 * Gets the specific brick that was hit so that it can be removed
 */

    public Brick getBrick(GraphicsObject brick){
        return bricks.get(bricks.indexOf(brick));
    }

    public int getNumberOfBricks() {
        return bricks.size();
    }

    
}
