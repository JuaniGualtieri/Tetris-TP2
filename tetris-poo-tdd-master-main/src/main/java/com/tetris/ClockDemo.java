package com.tetris;
import com.tetris.interfaces.IClockSuscribe;

public class ClockDemo
        implements IClockSuscribe
 {
    
    private int ticCounter = 0;
    
    public int getTic(){
        return ticCounter;
    }

    @Override
    public void tic(){
        ticCounter++;
    }
}