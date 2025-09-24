package com.tetris;
import java.util.ArrayList;

import com.tetris.interfaces.IClockSuscribe;

public class Clock {
    
    private final ArrayList<IClockSuscribe> suscribes;

    public Clock() {
        suscribes = new ArrayList<>();
    }

    //public Clock() {
    //    suscribes = new ArrayList<IClockSuscribe>();
    //}

    private ArrayList<IClockSuscribe> getSuscribes(){
        return suscribes;
    }

    public void suscribe(IClockSuscribe s){
        getSuscribes().add(s);

    }

    public void tic(){
        for (IClockSuscribe c : suscribes) {
            c.tic();
        }

    }

}