package com.tetris;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class TestBorrarLinea {

@Test
public void borrar_linea_cuando_completa(){

    Board board = new Board();

    int lastRow = board.grid.length - 1;    
    int cols = board.grid[0].length;

    for (int c = 0; c < cols - 1; c++){ // dejo la fila casi completa (menos la ultima columna)
        board.grid[lastRow][c] = 1;  
    }

    assertFalse(board.isLineComplete(board.grid[lastRow])); //corroboro que no deberia estar completa

    board.grid[lastRow][cols - 1] = 1; //hago caer la ultima pieza y completo la linea 

    int borradas = board.clearLinea();
    assertEquals(1, borradas); //ahora la linea deberia estar completa, por ende la borro

    for (int c = 0; c < cols; c++){
        assertEquals(0, board.grid[lastRow][c]);
    }

    } 

    
}
