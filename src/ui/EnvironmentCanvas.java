package ui;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class EnvironmentCanvas extends Canvas {

    //private int gridSize;

    //private int gridWidth;
    //private int gridHeight;
    CanvasPainter painter;

    public EnvironmentCanvas(){
        super();
        System.out.println("This shouldn't run");

        //events();
    }

    public EnvironmentCanvas(double width, double height, int gridSize){
        super (width, height);
        //this.gridSize = gridSize;
        //int gridWidth = (int) width / gridSize;
        //int gridHeight = (int) height / gridSize;

        painter = new CanvasPainter(this.getGraphicsContext2D(), width, height, gridSize);

        //environment = new Environment(gridWidth, gridHeight);
        //System.out.println(gridHeight);

        //events();
    }

    public CanvasPainter getCanvasPainter(){
        return painter;
    }

    /*private void events(){

        setOnMouseMoved(new EventHandler<MouseEvent>() {
            int gridPosX;
            int gridPosY;

            @Override
            public void handle(MouseEvent event) {
                gridPosX = (int)(event.getSceneX() / gridSize) * gridSize;
                gridPosY = (int)(event.getSceneY() / gridSize) * gridSize;
                paintSelector(gridPosX, gridPosY);
            }
        });



    }*/

    public void paintSelector(double x, double y){
        //gc.clearRect(0, 0, getWidth(), getHeight());
        //gc.strokeRect(x , y , gridSize, gridSize);
        painter.paintSelector(x, y);
    }

    /*public void paintSelected(int x, int y){
        gc.clearRect(0, 0, getWidth(), getHeight());
        gc.fillRect(x , y , gridSize, gridSize);
    }*/

}
