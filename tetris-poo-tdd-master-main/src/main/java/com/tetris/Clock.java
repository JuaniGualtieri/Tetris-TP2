package com.tetris;
import java.util.ArrayList;
import com.tetris.interfaces.IClockSuscribe;

public class Clock {
    
    private final ArrayList<IClockSuscribe> suscribes;

    public Clock() {
        suscribes = new ArrayList<>();
    }

    private ArrayList<IClockSuscribe> getSuscribes(){
        return suscribes;
    }

    // Permite que un objeto se suscriba al reloj
    public void suscribe(IClockSuscribe s){
        getSuscribes().add(s);
    }

    // Hace avanzar el reloj: notifica a todos los suscriptores
    public void tic(){
        for (IClockSuscribe c : suscribes) {
            c.tic();
        }
    }
}
