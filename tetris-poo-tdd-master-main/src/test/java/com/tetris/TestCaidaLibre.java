package com.tetris;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class TestCaidaLibre {

    @Test
    public void caida_libre_square() {
        Board board = new Board();
        PieceSquare square = new PieceSquare();

        // Colocamos el cuadrado en la parte superior
        board.addPieceBoard(square);

        // Simulamos la caída: mientras esté dentro del tablero, sigue bajando
        while (board.LimitesVeri(square)) {
            square.moveDown();
        }

        // Retrocedemos una fila porque el último moveDown pasó de más
        square.setY(square.getY() - 1);

        // La pieza debe quedar en la posición más baja posible
        int expectedY = board.grid.length - square.getPiece().length;
        assertEquals(expectedY, square.getY());

        // Verificamos que no puede bajar más
        square.setY(square.getY() + 1);
        assertFalse(board.LimitesVeri(square));
    }

    @Test
    public void caida_libre_pieza_LLeft() {
        Board board = new Board();
        PieceLLeft pieceL = new PieceLLeft();

        // Colocamos la L en la parte superior
        board.addPieceBoard(pieceL);

        // Simulamos la caída hasta que ya no pueda bajar
        while (board.LimitesVeri(pieceL)) {
            pieceL.moveDown();
        }

        // Retrocedemos una fila porque el último moveDown pasó de más
        pieceL.setY(pieceL.getY() - 1);

        // La pieza debe quedar en la posición más baja posible
        int expectedY = board.grid.length - pieceL.getPiece().length;
        assertEquals(expectedY, pieceL.getY());

        // Verificamos que no puede bajar más
        pieceL.setY(pieceL.getY() + 1);
        assertFalse(board.LimitesVeri(pieceL));
    }
}