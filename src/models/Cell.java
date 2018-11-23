package models;

public class Cell {

    public static Environment e;
    //private static final Rules rules = new Rules();
    private boolean isAlive;
    private boolean calledFlag;


    public Cell(boolean isAlive){
        this.isAlive = isAlive;
        calledFlag = true;
    }

    public void update(int x, int y, boolean flagState){
        int state;
        if(calledFlag == flagState){
            calledFlag = !calledFlag;
            state = numberAdjacent(x, y);
            if(!isAlive && state == 3){
                isAlive = true;
                return;
            }
            if(state < 2 || state > 3)
                isAlive = false;
        }
        /*int state;
        state = numberAdjacent(x, y);
        if(!isAlive && state == 3){
            isAlive = true;
            return;
        }
        if(state < 2 || state > 3)
            isAlive = false;*/
    }

    private int numberAdjacent(int x, int y){
        int adjacent = 0;
        int xPos;
        int yPos;
        for(int i = -1; i  < 2; i++){
            for(int j = -1; j  < 2; j++) {
                if(i == 0 && j == 0)
                    continue;

                xPos = x + i;
                yPos = y + j;
                e.updateCell(xPos, yPos);
                if(e.isOccupied(xPos, yPos)){
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
