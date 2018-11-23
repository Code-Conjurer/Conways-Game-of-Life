package models;

public class Environment {
    static int xSize;
    static int ySize;
    static Cell[][] grid;
    static boolean flag;

    public Environment(int xSize, int ySize){
        this.xSize = xSize;
        this.ySize = ySize;
        flag = true;
        Cell.e = this;
        initialize();

    }

    public void updateGrid(){
        /*for(int i = 0; i < xSize; i++){
            for(int j = 0; j < ySize; j++){
                if(grid[i][j].isAlive())
                    System.out.print('1');
                else
                    System.out.print('0');
                updateCell(i,j);
            }
            System.out.println();
        }
        System.out.println();*/
        updateCell(0 , 0);
        flag = !flag;
    }

    private void initialize(){
        for(int i = 0; i < xSize; i++){
            for(int j = 0; j < ySize; j++){
                grid[i][j] = new Cell(false);
            }
        }
        grid[3][3] = new Cell(true);
        grid[4][3] = new Cell(true);
        grid[5][3] = new Cell(true);
    }

    //remove try-catch to improve performance
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

    //remove try-catch to improve performance
    public void updateCell(int x, int y){
        try{
            grid[x][y].update(x, y, flag);
        }catch(IndexOutOfBoundsException e) {
            return;
        }

    }
}
