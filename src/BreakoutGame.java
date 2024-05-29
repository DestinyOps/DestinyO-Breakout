package breakout;

import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.GraphicsText;


public class BreakoutGame {
    private static final int CANVAS_WIDTH = 600;
    private static final int CANVAS_HEIGHT = 800;
    public static final int NUM_LAYERS = 10;
    public static final Color BRICK_COLOR = new Color(201, 150, 216, 55);


    private CanvasWindow canvas;
    private Ball ball;
    private  BrickManager brickManager;
    private Paddle paddle;
    private int livesss = 3;
    private GraphicsText lives, lose, win;


/*
 * Place to actually run the game
 */
      public static void main(String[] args){
        BreakoutGame game = new BreakoutGame();
        game.run();
    }

    public BreakoutGame() {
        canvas = new CanvasWindow("Breakout!", CANVAS_WIDTH, CANVAS_HEIGHT);
        ball = new Ball(CANVAS_HEIGHT/2, CANVAS_HEIGHT/2, 5, 7, CANVAS_WIDTH, CANVAS_HEIGHT);
        ball.addToCanvas(canvas);

        lives = new GraphicsText("Lives: " + livesss);
        lives.setFillColor(Color.BLACK);
        lives.setFontSize(24);
        lives.setPosition(25,25);
        canvas.add(lives);

        lose = new GraphicsText("Aww, you lost!");
        lose.setFillColor(Color.BLACK);
        lose.setFontSize(48);
        lose.setPosition(100,400);

        win = new GraphicsText("You Won!");
        win.setFillColor(Color.BLACK);
        win.setFontSize(48);
        win.setPosition(25,25);
        

        paddle = new Paddle(30,20,CANVAS_WIDTH,CANVAS_HEIGHT);
        paddle.addToCanvas(canvas);

        canvas.onMouseMove(event -> 
        paddle.setX(event.getPosition().getX()));

        brickManager = new BrickManager(canvas);
        brickManager.generateBricks();

        canvas.animate(event -> {
        run();
        ball.updatePosition();
        boolean stillGoing = ball.checkCollision(canvas);

        if(!stillGoing){
        lostLife();
        lives.setText("Lives: " + livesss);
        }

        });


    }

    public void lostLife(){
        livesss --;


        if(livesss == 0){
            canvas.removeAll();
            canvas.add(lose);
        }

        if(livesss != 0 && brickManager.getNumberOfBricks() == 0){
            canvas.removeAll();
            canvas.add(win);
        }
    }

    

    public void run(){


        GraphicsObject bottomBoundary = canvas.getElementAt(ball.getballCenterX() + ball.getRadius(), ball.getballCenterY() + ball.getRadius());
        GraphicsObject topBoundary = canvas.getElementAt(ball.getballCenterX() - ball.getRadius(), ball.getballCenterY() - ball.getRadius());
        GraphicsObject leftBoundary = canvas.getElementAt(ball.getballCenterX() - ball.getRadius(), ball.getballCenterY() + ball.getRadius());
        GraphicsObject rightBoundary = canvas.getElementAt(ball.getballCenterX() + ball.getRadius(), ball.getballCenterY() - ball.getRadius());

        if(topBoundary != null && topBoundary.getClass().getName() != "edu.macalester.graphics.Ellispe"){
            ball.reverseY();
            removeBrick(topBoundary); 
        }
        else if(bottomBoundary != null && bottomBoundary.getClass().getName() == "edu.macalester.graphics.Rectangle"){
            ball.reverseY();
            removeBrick(bottomBoundary);
        }
        else if(leftBoundary != null && leftBoundary.getClass().getName() != "edu.macalester.graphics.Ellispe"){
            ball.reverseX();
            removeBrick(leftBoundary);
        }
        else if(rightBoundary != null && rightBoundary.getClass().getName() != "edu.macalester.graphics.Ellispe"){
            ball.reverseX();
            removeBrick(rightBoundary);
        }
    }

    public void removeBrick(GraphicsObject boundary){

    if(boundary.getClass().getName() == "breakout.Brick"){
       Brick hitBrick = brickManager.getBrick(boundary);
       brickManager.popBrick(hitBrick);
        }
    }

    }










