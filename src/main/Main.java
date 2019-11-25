package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static main.Controller.drawShapes;

public class Main extends Application {

    static double x1 = 30;
    static double y1 = 30;

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        primaryStage.setTitle("Game");
        Scene scene = new Scene(root, 650, 650);
        primaryStage.setScene(scene);
        primaryStage.show();

        scene.setOnKeyPressed(
                e -> {
                    String code = e.getCode().toString();
                    System.out.println(code);

                    if (code.equals("UP")) {
                        System.out.println("moving up");
                        y1 = y1 - 10;
                        drawShapes(Controller.gc);
                    }
                    if (code.equals("DOWN")) {
                        System.out.println("moving down");
                        y1 = y1 + 10;
                        drawShapes(Controller.gc);
                    }
                    if (code.equals("RIGHT")) {
                        System.out.println("moving right");
                        x1 = x1 + 10;
                        drawShapes(Controller.gc);
                    }
                    if (code.equals("LEFT")) {
                        System.out.println("moving left");
                        x1 = x1 - 10;
                        drawShapes(Controller.gc);
                    }
                });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
