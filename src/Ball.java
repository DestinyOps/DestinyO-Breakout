package breakout;

import java.awt.Color;


import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Ellipse;

public class Ball {
    public static final double BALL_RADIUS = 20;
    private static final int CANVAS_WIDTH = 600;
    private static final int CANVAS_HEIGHT = 800;

    private Ellipse ball; 
    private double ballCenterX;
    private double ballCenterY;
    private double xVelocityI;
    private double yVelocityI;
    private double ballMaxX;
    private double ballMaxY;

    public Ball(double centerX, double centerY, double xVelocity, double yVelocity, double maxX, double maxY){
        this.ball = new Ellipse(centerX, centerY, BALL_RADIUS *2, BALL_RADIUS *2);
        this.ball.setFillColor(Color.BLUE);
        this.ballCenterX = centerX;
        this.ballCenterY = centerY;

        this.xVelocityI = xVelocity;
        this.yVelocityI = yVelocity;

        this.ballMaxX = maxX;
        this.ballMaxY = maxY;

    }

    public double getballCenterX(){
        return ballCenterX;
    }

    public double getballCenterY(){
        return this.ballCenterY;
    }

    public Ellipse getBall(){
        return ball;
       }

    public void addToCanvas(CanvasWindow canvas) {
        ball.setCenter(canvas.getWidth()*.5, canvas.getHeight()*.65);
        canvas.add(ball);
        
    }
   
    public void updatePosition() {
        double newcenterX = ballCenterX + xVelocityI;
        double newcenterY = ballCenterY + yVelocityI;

        if (newcenterX > 0 && newcenterX < this.ballMaxX && newcenterY > 0 && newcenterY < this.ballMaxY) {
            this.ball.setCenter(newcenterX, newcenterY);
            this.ballCenterX = newcenterX;
            this.ballCenterY = newcenterY;
        }

    }


    public void looseLife (){
            ball.setPosition(CANVAS_WIDTH/2, CANVAS_HEIGHT/2);
            ballCenterX = CANVAS_WIDTH/2;
            ballCenterY = CANVAS_HEIGHT/2;
    }


    public boolean checkCollision(CanvasWindow canvas){
        if (getballCenterX() - BALL_RADIUS <= 0 || getballCenterX() + BALL_RADIUS >= canvas.getWidth()){
            reverseX();
            return true;
        }    
        if (getballCenterY() - BALL_RADIUS  <= 0){ 
            reverseY();
            return true;
        }    
        if (getballCenterY() + BALL_RADIUS >= canvas.getHeight()) {
            looseLife();
            return false;
            
        }

        return true;
    }  

    public void reverseY() {
        this.yVelocityI = -yVelocityI;
    }

    public void reverseX() {
        this.xVelocityI = -xVelocityI;
    }

    public void removeFromCanvas(CanvasWindow canvas) {
        canvas.remove(ball);
    }

    public double getxVelocityI() {
        return xVelocityI;
    }
    
    public double getyVelocityI() {
        return yVelocityI;
    }
    

    public double getRadius(){
        return ball.getWidth()/2;
    }


}