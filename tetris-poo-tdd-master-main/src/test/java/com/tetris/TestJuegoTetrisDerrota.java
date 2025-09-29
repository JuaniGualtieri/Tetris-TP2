package com.tetris;

import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class TestJuegoTetrisDerrota {

    @Test
    public void juego_completo_derrota_sin_espacio() {
        Board board = new Board();
        Clock clock = new Clock();

        int rows = board.grid.length;
        int cols = board.grid[0].length;

        //  Llenamos el tablero hasta arriba con cuadrados 
        for (int r = rows - 1; r >= 0; r -= 2) {
            for (int c = 0; c < cols; c += 2) {
                PieceSquare square = new PieceSquare();
                square.setX(c);
                square.setY(0);
                board.dropPiece(square);
            }
        }

        //  Intentamos agregar otra pieza cuando ya no hay lugar 
        PieceSquare extra = new PieceSquare();
        extra.setX(0);
        extra.setY(0);

        boolean puedeEntrar = board.LimitesVeri(extra);

        // Verificamos que no hay espacio (derrota) 
        assertFalse("No entran mas piezas en el tablero, has perdido", puedeEntrar);

        // Validamos que no se borraron líneas (no es victoria)
        boolean gano = board.checkFinalDelJuego();
        assertFalse("El juego no debería terminar en victoria, sino en derrota", gano);
    }
}