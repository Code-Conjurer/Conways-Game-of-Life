package ui;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import models.Engine;

public class Initialize extends Application {

    private final int SCREEN_HEIGHT = 700;
    private final int SCREEN_WIDTH = 700;
    private static final int GRID_SIZE = 20;
    private static Engine engine;

    private StackPane root;
    private EnvironmentCanvas canvas;
    private Scene scene;

    public static void main(String... args){

        engine = new Engine(GRID_SIZE);
        launch(args);
        //engine = new Engine(GRID_SIZE);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Conway's Game Of Life");

        initializeScene();
        //engine.addGraphicsContext(canvas.getGraphicsContext2D());
        engine.addCanvasPainter(canvas.getCanvasPainter());

        events(scene, canvas, primaryStage);

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private void initializeScene(){
        root = new StackPane();
        root.setMaxWidth(SCREEN_WIDTH);
        root.setMaxHeight(SCREEN_HEIGHT);

        canvas = new EnvironmentCanvas(SCREEN_WIDTH, SCREEN_HEIGHT, GRID_SIZE);

        root.getChildren().add(canvas);

        scene = new Scene(root, root.getMaxWidth(), root.getMaxHeight());
    }

    private void events(Scene scene, EnvironmentCanvas canvas, Stage stage){

        //Updates Selector
        /*scene.setOnMouseMoved(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event){
                canvas.paintSelector(event.getSceneX(), event.getSceneY());
                //canvas.paintSelector(
                        //calculateGridPos(event.getSceneX()),
                       // calculateGridPos(event.getSceneY()));

            }
        });*/

        //Pauses and Un-pauses
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event){
                if(event.getCode() == KeyCode.SPACE){
                    engine.update();
                    /*engine.togglePaused();
                    if(engine.isPaused())
                        stage.setTitle("PAUSED");
                    else
                        stage.setTitle("Conway's Game Of Life");*/
                }
            }
        });

        scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event){
                engine.toggleCell((int)(event.getSceneX() / GRID_SIZE), (int)(event.getSceneY() / GRID_SIZE));
                //canvas.paintSelected(
                  //      calculateGridPos(event.getSceneX()),
                    //    calculateGridPos(event.getSceneY()));
            }
        });

    }

    /*private int calculateGridPos(double mousePos){
        return (int)(mousePos / GRID_SIZE) * GRID_SIZE;
    }*/
}
