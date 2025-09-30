package com.tetris;
import com.tetris.interfaces.IClockSuscribe;

// Ejemplo de implementación de IClockSuscribe
// Contador que incrementa en cada tic del reloj
public class ClockDemo implements IClockSuscribe {
    
    private int ticCounter = 0;
    
    public int getTic(){
        return ticCounter;
    }

    @Override
    public void tic(){
        ticCounter++;
    }
}
