package breakout;

import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Rectangle;

public class Paddle{
    public static final double PADDLE_WIDTH = 5;
    public static final double PADDLE_HEIGHT = 5;

    private Rectangle paddle;
    private double centerPaddleX;
    private double centerPaddleY;

    public Paddle(double centerX, double centerY, double maxX, double maxY){
        this.paddle = new Rectangle(100,20,PADDLE_WIDTH * 20, PADDLE_HEIGHT * 3);
        this.paddle.setFillColor(Color.ORANGE);
    }

    public double getCenterX() {
        return centerPaddleX;
    }
    public double getCenterY() {
        return this.centerPaddleY;
    }


    public void paddleMove(CanvasWindow canvas, double xPosition) {
        paddle.setCenter(xPosition, 600);
        canvas.draw();
    }

    public void addToCanvas(CanvasWindow canvas) {
        paddle.setCenter(canvas.getWidth()*.5, canvas.getHeight()*.75);
        canvas.add(paddle);
    
    }

    public void removeFromCanvas(CanvasWindow canvas) {
        canvas.remove(paddle);
    }

    public void setX(double x) {
        paddle.setX(x);
    }



}
