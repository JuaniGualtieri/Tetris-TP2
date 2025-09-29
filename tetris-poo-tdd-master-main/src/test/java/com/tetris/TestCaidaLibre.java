package com.tetris;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestCaidaLibre {

    @Test
    public void caida_libre_square() {
        Board board = new Board();
        PieceSquare square = new PieceSquare();

        // Dejamos caer el cuadrado hasta el fondo usando dropPiece
        board.dropPiece(square);

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

        // Dejamos caer la L hasta el fondo usando dropPiece
        board.dropPiece(pieceL);

        // La pieza debe quedar en la posición más baja posible
        int expectedY = board.grid.length - pieceL.getPiece().length;
        assertEquals(expectedY, pieceL.getY());

        // Verificamos que no puede bajar más
        pieceL.setY(pieceL.getY() + 1);
        assertFalse(board.LimitesVeri(pieceL));
    }
}
