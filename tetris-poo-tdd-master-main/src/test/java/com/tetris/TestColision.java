package com.tetris;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestColision {

    @Test
    public void colision_L_y_Stick() {
        Board board = new Board();

        // Dejamos caer la pieza L hasta el fondo
        PieceLLeft pieceL = new PieceLLeft();
        board.dropPiece(pieceL);

        int finalYL = pieceL.getY();
        assertEquals(board.grid.length - pieceL.getPiece().length, finalYL);

        // Ahora colocamos un Stick que debe chocar con la L
        PieceStick stick = new PieceStick();
        stick.rotateDer(); // lo usamos horizontal (4 bloques en fila)
        stick.setX(0);
        stick.setY(0);

        // Dejamos caer el Stick usando dropPiece
        board.dropPiece(stick);

        // Verificación de colisión
        assertTrue("El stick debe haber colisionado con la L",
                   stick.getY() < finalYL);

        // Si intentamos bajarlo una más, no debería entrar
        stick.setY(stick.getY() + 1);
        assertFalse(board.LimitesVeri(stick));
    }
}
