package com.tetris;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestBorrarLinea {

    @Test
    public void borrar_linea_con_cuadrados() {
        Board board = new Board();
        int lastRow = board.grid.length - 1;
        int cols = board.grid[0].length;

        // Vamos a ir agregando cuadrados de 2x2 hasta llenar la última fila
        for (int c = 0; c < cols; c += 2) {
            PieceSquare square = new PieceSquare();
            square.setX(c);               // columna inicial
            square.setY(lastRow - 1);     // fila anterior a la última (el square ocupa 2 filas)
            board.placePiece(square, square.getX(), square.getY());
        }

        // Confirmamos que la última fila está completa
        assertTrue(board.isLineComplete(board.grid[lastRow]));

        // Ejecutamos el borrado
        int borradas = board.clearLinea();
        assertEquals(2, borradas);

        // La última fila debería quedar vacía
        for (int c = 0; c < cols; c++) {
            assertEquals(0, board.grid[lastRow][c]);
        }
    }
}

