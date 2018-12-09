package models;


import javafx.scene.paint.Color;

public class Cell{

    public static Environment e;
    //private static final Rules rules = new Rules();
    private boolean isAlive;
    private Color color;

    public Cell(boolean isAlive, Color color){
        this.isAlive = isAlive;
        this.color = color;
    }

    public boolean update(int x, int y){
        int adjacent = 0;
        //state = numberAdjacent(x, y);
        int xPos;
        int yPos;
        Color[] adjacentColors = new Color[3];

        for(int i = -1; i  < 2; i++){
            for(int j = -1; j  < 2; j++) {
                if(i == 0 && j == 0)
                    continue;

                xPos = x + i; //either add 1 or subtract
                yPos = y + j;
                if(e.isOccupied(xPos, yPos)){
                    if(adjacent < 3)
                        adjacentColors[adjacent] = e.getColor(xPos, yPos);
                    adjacent++;
                }
            }
        }

        if(!isAlive && adjacent == 3){
            this.color = averageColor(adjacentColors);
            return true;
        }else if(adjacent < 2 || adjacent > 3) {
            return false;
        }else{
            return isAlive;
        }
    }

    /*private int numberAdjacent(int x, int y){
        int adjacent = 0;
        int xPos;
        int yPos;
        for(int i = -1; i  < 2; i++){
            for(int j = -1; j  < 2; j++) {
                if(i == 0 && j == 0)
                    continue;

                xPos = x + i; //either add 1 or subtract
                yPos = y + j;

                if(e.isOccupied(xPos, yPos)){
                    adjacent++;
                }
            }
        }

        return adjacent;
    }*/

    private Color averageColor(Color[] colors){
        //double red = color.getRed();
        //double green = color.getGreen();
        //double blue = color.getBlue();
        double red = 0;
        double green = 0;
        double blue = 0;

        for(Color c: colors){
            red += c.getRed();
            green += c.getBlue();
            blue += c.getBlue();
        }

        red /= colors.length;
        green /= colors.length;
        blue /= colors.length;

        //red = mutate();
        //green = mutate(green);
        //blue = mutate(blue);
        return new Color(red, green, blue, 1);
    }

    public Color getColor(){
        return color;
    }

    public boolean isAlive(){
        return isAlive;
    }

    public void setAlive(boolean isAlive){
        this.isAlive = isAlive;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Cell deepClone(){
        return new Cell(isAlive, color);
    }

}
