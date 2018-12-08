package ui;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

public class EnvironmentCanvas extends Canvas {

    GraphicsContext gc = this.getGraphicsContext2D();
    private final int pixelsInGrid = 40;
    private int gridWidth;
    private int gridHeight;

    public EnvironmentCanvas(){
        super();
        System.out.println("This shouldn't run");

        events();
    }

    public EnvironmentCanvas(double width, double height){
        super (width, height);
        gridWidth = (int) width / pixelsInGrid;
        gridHeight = (int) height / pixelsInGrid;
        System.out.println(gridHeight);

        events();
    }

    private void events(){

        setOnMouseMoved(new EventHandler<MouseEvent>() {
            int gridPosX;
            int gridPosY;

            @Override
            public void handle(MouseEvent event) {
                gridPosX = (int)(event.getSceneX() / pixelsInGrid) * pixelsInGrid;
                gridPosY = (int)(event.getSceneY() / pixelsInGrid) * pixelsInGrid;
                //gc.clearRect(0, 0, getWidth(), getHeight());
                //System.out.println(event.getSceneX() + " " + event.getSceneY());
                //gc.strokeRect(gridPosX , gridPosY , pixelsInGrid , pixelsInGrid);
                paintSelector(gridPosX, gridPosY);
            }
        });



    }

    private void paintSelector(int x, int y){
        gc.clearRect(0, 0, getWidth(), getHeight());
        gc.strokeRect(x , y , pixelsInGrid , pixelsInGrid);

    }

}
