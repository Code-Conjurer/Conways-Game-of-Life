package models;

import java.util.Arrays;

public class Environment {
    static int xSize;
    static int ySize;
    static Cell[][] grid;
    static Cell[][] grid_updated;
    static boolean flag;

    public Environment(int xSize, int ySize){
        this.xSize = xSize;
        this.ySize = ySize;
        grid = new Cell[xSize][ySize];
        grid_updated = new Cell[xSize][ySize];
        Cell.e = this;
        initialize();

    }

    public void updateGrid(){
        boolean status;
        Cell temp;
        for(int i = 0; i < xSize; i++){
            for(int j = 0; j < ySize; j++){
                temp = grid[i][j];

                if(temp.isAlive())
                    System.out.print('*');
                else
                    System.out.print('-');
                status = temp.update(i,j);
                grid_updated[i][j].setAlive(status);
            }
            System.out.println();
        }
        System.out.println();

        deepCopyGrid(grid_updated, grid);
    }

    private void initialize(){
        for(int i = 0; i < xSize; i++){
            for(int j = 0; j < ySize; j++){
                grid[i][j] = new Cell(false);
            }
        }

        deepCopyGrid(grid, grid_updated);

        grid[3][3] = new Cell(true);
        grid[4][3] = new Cell(true);
        grid[5][3] = new Cell(true);

    }

    //remove try-catch to improve performance
    public boolean isOccupied(int x, int y){
        try{
            return grid[x][y].isAlive();

        }catch(IndexOutOfBoundsException e) {
            return false;
        }
    }

    private void deepCopyGrid(Cell[][] original, Cell[][] copy ){
        for(int i =  0; i < original.length; i++){
            for(int j = 0; j < original[i].length; j++){
                copy[i][j] = original[i][j].deepClone();
            }
        }
    }
}
