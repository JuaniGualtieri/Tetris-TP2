package com.tetris.interfaces;

// Interfaz que deben implementar los objetos que quieran "suscribirse" al reloj.
// Cada vez que el reloj haga un tic, se ejecutará el método tic() en el suscriptor.
public interface IClockSuscribe {
    void tic();
}
