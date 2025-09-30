package com.tetris;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestColision {

    @Test
    public void colision_L_y_Stick() {
        Board board = new Board();

        // 1) L cae hasta el fondo 
        PieceLLeft pieceL = new PieceLLeft();
        pieceL.setX(0);
        pieceL.setY(0);
        board.dropPiece(pieceL); // aquí se mueve y recién al final se estampa

        int finalYL = pieceL.getY();
        assertEquals(board.grid.length - pieceL.getPiece().length, finalYL);

        // 2) Ahora el stick horizontal cae y debe chocar con la L
        PieceStick stick = new PieceStick();
        stick.rotateDer();   // horizontal
        stick.setX(0);
        stick.setY(0);
        board.dropPiece(stick);

        // 3) Verificaciones
        // Quedó por encima de la L
        assertTrue("El stick debe haber colisionado con la L", stick.getY() < finalYL);

        // Si intento bajarlo una más, no debe caber
        stick.setY(stick.getY() + 1);
        assertFalse(board.LimitesVeri(stick));
    }
}
