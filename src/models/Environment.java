package models;

import javafx.scene.paint.Color;
import ui.CanvasPainter;

import java.util.Arrays;

public class Environment {
    static int xSize;
    static int ySize;
    static Cell[][] grid;
    static Cell[][] grid_updated;
    private CanvasPainter painter;

    public Environment(int xSize, int ySize){
        this.xSize = xSize;
        this.ySize = ySize;
        grid = new Cell[xSize][ySize];
        grid_updated = new Cell[xSize][ySize];
        Cell.e = this;
        initialize();

    }

    public void updateGrid(){
        boolean isAlive;
        Cell temp;
        for(int i = 0; i < xSize; i++){
            for(int j = 0; j < ySize; j++){
                temp = grid[i][j];

                if(temp.isAlive())
                    painter.paintSelected(i, j, temp.getColor());
                    //System.out.print('*');
                else
                    painter.clearSelected(i, j);
                    //System.out.print('-');
                isAlive = temp.update(i,j);
                grid_updated[i][j].setAlive(isAlive);
                grid_updated[i][j].setColor(temp.getColor());
            }
            //System.out.println();
        }
        //System.out.println();

        deepCopyGrid(grid_updated, grid);
    }

    public void toggleCell(int x, int y){
        Cell cell = grid[x][y];
        cell.setAlive( !cell.isAlive() );
        if(cell.isAlive()){
            painter.paintSelected(x, y, cell.getColor());
        }else{
            painter.clearSelected(x, y);
        }
    }

    public void addCell(int x, int y){
        Cell cell = grid[x][y];
        cell.setAlive(true);
        painter.paintSelected(x, y, cell.getColor());
    }

    private void initialize(){
        double randRed;
        double randGreen;
        double randBlue;
        for(int i = 0; i < xSize; i++){
            for(int j = 0; j < ySize; j++){
                randRed = (Math.random());//Javafx Color range is from 0.0 - 1.0
                randGreen = (Math.random());
                randBlue = (Math.random());
                grid[i][j] = new Cell(false, new Color(randRed, randGreen, randBlue, 1));
                //grid[i][j] = new Cell(false, Color.BLACK);
            }
        }

        deepCopyGrid(grid, grid_updated);

        //grid[3][3] = new Cell(true);
        //grid[4][3] = new Cell(true);
        //grid[5][3] = new Cell(true);

    }

    public void addCanvasPainter(CanvasPainter painter){
        this.painter = painter;
    }

    //remove try-catch to improve performance
    public boolean isOccupied(int x, int y){
        try{
            return grid[x][y].isAlive();

        }catch(IndexOutOfBoundsException e) {
            return false;
        }
    }

    public Color getColor(int x, int y){
        return grid[x][y].getColor();
    }

    private void deepCopyGrid(Cell[][] original, Cell[][] copy ){
        for(int i =  0; i < original.length; i++){
            for(int j = 0; j < original[i].length; j++){
                copy[i][j] = original[i][j].deepClone();
            }
        }
    }

    public int getXSize(){
        return xSize;
    }

    public int getYSize(){
        return ySize;
    }
}
