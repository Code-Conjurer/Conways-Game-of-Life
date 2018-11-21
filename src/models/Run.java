package models;

import javax.swing.*;


public class Run {

    static Environment environment;
    private static final int INTERVAL = 20;

    public Run(){

        environment = new Environment(200, 200);
        double t = System.currentTimeMillis();
        double temp;
        while (true){
            temp = System.currentTimeMillis();
            if(temp - t > INTERVAL) {
                environment.updateGrid();
                t = temp;
            }
        }
    }

}
