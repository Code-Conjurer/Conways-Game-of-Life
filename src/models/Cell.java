package models;

public class Cell {

    public static Environment e;
    //private static final Rules rules = new Rules();
    private boolean isAlive;


    public Cell(boolean isAlive){
        this.isAlive = isAlive;
    }

    public void update(int x, int y){
        int state;
        state = numberAdjacent(x, y);
        if(!isAlive && state == 3){
            isAlive = true;
            return;
        }
        if(state < 2 || state > 3)
            isAlive = false;
    }

    private int numberAdjacent(int x, int y){
        int adjacent = 0;
        for(int i = -1; i  < 2; i++){
            for(int j = -1; j  < 2; j++) {
                if(i == 0 && j == 0)
                    continue;
                if(e.isOccupied(x + i, y + j)){
                    adjacent++;
                }
            }
        }
        return adjacent;
    }

    public boolean isAlive(){
        return isAlive;
    }

}
