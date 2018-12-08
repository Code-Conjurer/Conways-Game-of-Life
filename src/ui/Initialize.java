package ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import models.Run;

public class Initialize extends Application {

    final int SCREEN_HEIGHT = 700;
    final int SCREEN_WIDTH = 700;

    public static void main(String... args){

        launch(args);
        //new Run();
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Conway's Game Of Life");

        StackPane root = new StackPane();
        root.setMaxWidth(SCREEN_WIDTH);
        root.setMaxHeight(SCREEN_HEIGHT);

        EnvironmentCanvas canvas = new EnvironmentCanvas(SCREEN_WIDTH, SCREEN_HEIGHT);

        root.getChildren().add(canvas);


        primaryStage.setScene(new Scene(root, root.getMaxWidth(), root.getMaxHeight()));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
