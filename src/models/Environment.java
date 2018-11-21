package models;

public class Environment {
    static int xSize;
    static int ySize;
    static Cell[][] grid;

    public Environment(int xSize, int ySize){
        this.xSize = xSize;
        this.ySize = ySize;
        grid = new Cell[xSize][ySize];
        Cell.e = this;
        initialize();

    }

    public void updateGrid(){
        for(int i = 0; i < xSize; i++){
            for(int j = 0; j < ySize; j++){
                grid[i][j].update(i,j);
                if(grid[i][j].isAlive())
                    System.out.print('1');
                else
                    System.out.print('0');
            }
            System.out.println();
        }
    }

    private void initialize(){
        for(Cell[] cArr : grid){
            for(Cell c : cArr){
                c = new Cell(false);
            }
        }
    }

    public boolean isOccupied(int x, int y){
        try{
            if(grid[x][y].isAlive())
                return true;
            else
                return false;
        }catch(IndexOutOfBoundsException e) {
            return false;
        }
    }
}
