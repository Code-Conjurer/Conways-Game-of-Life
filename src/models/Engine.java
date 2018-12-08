package models;

import javafx.scene.canvas.GraphicsContext;
import ui.CanvasPainter;

public class Engine {

    static Environment environment;
    private static final int INTERVAL = 2000;
    private int gridSize;
    private boolean paused;
    private double t;
    //private GraphicsContext gc;


    public Engine(int gridSize) {
        paused = true;
        this.gridSize = gridSize;
        environment = new Environment(gridSize, gridSize);
    }
    public void run(){
        t = System.currentTimeMillis();
        double temp;
        while (!paused){
            temp = System.currentTimeMillis();
            if(temp - t > INTERVAL) {
                environment.updateGrid();
                t = temp;
            }
        }
    }

    //TODO: Remove after threads implemented
    public void update(){
        environment.updateGrid();
    }

    public void togglePaused(){
        paused = !paused;
    }

    public boolean isPaused(){
        return paused;
    }

    public void addCanvasPainter(CanvasPainter painter) {
        environment.addCanvasPainter(painter);
    }

    public void toggleCell(int gridX, int gridY){
        environment.toggleCell(gridX, gridY);
    }

    public void addCell(int gridX, int gridY){
        environment.addCell(gridX, gridY);
    }

}
