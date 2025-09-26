package com.tetris;  

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class TestGanarJuego {

@Test
public void ganar_juego_cinco_lineas(){

    Board board = new Board();

    int rows = board.grid.length;
    int cols = board.grid[0].length;

    for (int r = rows - 1; r >= rows - 5; r--){
        for (int c = 0; c < cols; c++){
            board.grid[r][c] = 1; // cualquier valor != 0 es ocupado
            }
        }      
    
    boolean cumplido = false; 
    int intentos = 0;

    while(!cumplido && intentos < 10){
        cumplido = board.checkFinalDelJuego();
        intentos++; 
        
    }
    
    assertTrue("Deberia cumplirse que ganas el juego tras borrar 5 filas", cumplido);

    for (int r = rows - 1; r >= rows - 5; r--) {
        for (int c = 0; c < cols; c++){
            assertEquals("La fila " + r + "deberia quedar vacia", 0, board.grid[r][c]);
        }
    }
    
}
}
