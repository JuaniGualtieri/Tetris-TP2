package com.tetris;

import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class TestJuegoTetrisDerrota {

    @Test
    public void juego_completo_derrota_sin_espacio() {
        Board board = new Board();
        int rows = board.grid.length;
        int cols = board.grid[0].length;

        //  Llenamos el tablero completo con cuadrados 
        for (int r = rows - 1; r >= 0; r -= 2) {
            for (int c = 0; c < cols; c += 2) {
                PieceSquare square = new PieceSquare();
                square.setX(c);
                square.setY(0);
                board.dropPiece(square); // cada cuadrado cae hasta el fondo
            }
        }

        //  Intentamos colocar una pieza más 
        PieceSquare extra = new PieceSquare();
        extra.setX(0);
        extra.setY(0);

        boolean puedeEntrar = board.LimitesVeri(extra);

        // Validamos derrota 
        assertFalse("No debería poder entrar una nueva pieza, el juego está en derrota", puedeEntrar);
    }
}
