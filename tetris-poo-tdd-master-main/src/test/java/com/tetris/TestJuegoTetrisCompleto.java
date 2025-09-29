package com.tetris;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class TestJuegoTetrisCompleto {

    @Test
    public void juego_completo_ganar_con_dropPiece() {
        Board board = new Board();
        Clock clock = new Clock();

        //  Comienzo del juego 
        assertNotNull(board);
        assertNotNull(clock);

        int rows = board.grid.length;
        int cols = board.grid[0].length;

        //  usamos cuadrados (2x2) y los dejamos caer con dropPiece 
        // necesitamos cubrir 5 filas 
        for (int r = rows - 1; r >= rows - 5; r -= 2) {
            for (int c = 0; c < cols; c += 2) {
                PieceSquare square = new PieceSquare();
                square.setX(c);
                square.setY(0); // siempre arranca arriba
                board.dropPiece(square); // la pieza cae hasta abajo
            }
        }

        // Simulamos ticks de reloj
        ClockDemo demo = new ClockDemo();
        clock.suscribe(demo);

        for (int i = 0; i < 5; i++) {
            clock.tic();
        }

        assertEquals(5, demo.getTic()); // el reloj avanza

        // Validamos que el juego detecte la victoria 
        boolean gano = board.checkFinalDelJuego();
        assertTrue("Has completado 5 líneas, has ganado! :)", gano);

        // Validamos que las ultimas 5 filas queden vacias al eliminarse 
        for (int r = rows - 1; r >= rows - 5; r--) {
            for (int c = 0; c < cols; c++) {
                assertEquals(0, board.grid[r][c]);
            }
        }
    }
}