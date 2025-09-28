package com.tetris;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestGanarJuego {

    @Test
    public void ganar_juego_con_cuadrados() {
        Board board = new Board();
        int rows = board.grid.length;
        int cols = board.grid[0].length;

        // Vamos a llenar las últimas 5 filas con cuadrados de 2x2
        for (int r = rows - 1; r >= rows - 5; r -= 2) {  // salto de 2 filas porque cada square ocupa 2
            for (int c = 0; c < cols; c += 2) {          // salto de 2 columnas porque cada square ocupa 2
                PieceSquare square = new PieceSquare();
                square.setX(c);
                square.setY(r - 1); // el square ocupa dos filas: r-1 y r
                board.placePiece(square, square.getX(), square.getY());
            }
        }

        // Ahora debería cumplirse la condición de ganar (5 filas borradas en total)
        boolean gano = board.checkFinalDelJuego();
        assertTrue("Debería cumplirse que se gana el juego borrando 5 filas", gano);

        // Verificamos que las últimas 5 filas estén vacías
        for (int r = rows - 1; r >= rows - 5; r--) {
            for (int c = 0; c < cols; c++) {
                assertEquals(0, board.grid[r][c]);
            }
        }
    }
}
