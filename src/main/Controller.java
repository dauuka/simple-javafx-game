package main;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import java.util.Random;

public class Controller {

    @FXML
    Canvas canvas = new Canvas();
    static GraphicsContext gc;

    private static Random rand = new Random();
    private static int r1 = rand.nextInt(500);
    private static int r2 = rand.nextInt(500);
    private static int countScore = 0;

    public void mouse(MouseEvent event) {
        System.out.println(event.getX() + " " + event.getY());
        gc = canvas.getGraphicsContext2D();
        drawShapes(gc);
    }

    static void drawShapes(GraphicsContext gc) {
        gc.clearRect(0, 0, 600,600);
        gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLACK);

        if (Math.abs(r1 - Main.x1 - 30) < 15 && Math.abs(r2 - Main.y1 - 30) < 15) {
            gc.clearRect(r1, r2, 20, 20);
            r1 = rand.nextInt(500);
            r2 = rand.nextInt(500);
            countScore++;
        } else {
            gc.fillRect(r1, r2, 20, 20);
        }
        gc.strokeText("Score is " + countScore, 30, 560);

        Image image = new Image("main/eater_picture.png");
        gc.drawImage(image, Main.x1, Main.y1,100, 100);
    }
}
