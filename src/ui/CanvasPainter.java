package ui;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class CanvasPainter {
    private GraphicsContext gc;
    private double width;
    private double height;
    private int gridSize;



    public CanvasPainter(GraphicsContext gc, double width, double height, int gridSize){
        this.gc = gc;
        this.width = width;
        this.height = height;
        this.gridSize = gridSize;

    }

    //
    public void paintSelector(double mouseX, double mouseY){
        gc.clearRect(0, 0, width, height);
        gc.strokeRect(calculateGridPos(mouseX) , calculateGridPos(mouseY) , gridSize, gridSize);

    }

    /*public void paintSelected(int gridX, int gridY){
        gc.setFill(Color.BLACK);
        gc.fillRect(gridX * gridSize , gridY * gridSize , gridSize, gridSize);
    }*/

    public void paintSelected(int gridX, int gridY, Color color){
        gc.setFill(color);
        System.out.println(color);
        gc.fillRect(gridX * gridSize , gridY * gridSize , gridSize, gridSize);
    }

    public void clearSelected(int gridX, int gridY){
        gc.clearRect(gridX * gridSize , gridY * gridSize , gridSize, gridSize);
    }

    //Discretize mouse position onto the grid
    private int calculateGridPos(double mousePos){
        return (int)(mousePos / gridSize) * gridSize;
    }
}
