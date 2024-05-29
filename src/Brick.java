package breakout;

import java.awt.Color;

import edu.macalester.graphics.Rectangle;

/*
 * Extends rectangle so everything is easier
 */

 public class Brick extends Rectangle{

 /**
  * Constructs a brick centered on the center X/Y with the specified width and height
  */

    public Brick(double x, double y, double width, double height, Color color){
        super(x,y,width, height);
        this.setPosition(x,y);
        this.setFillColor(color);

    }

 }