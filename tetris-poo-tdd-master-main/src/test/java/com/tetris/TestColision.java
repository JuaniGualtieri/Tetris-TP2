package com.tetris;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class TestColision {

    @Test
    public void colision_L_y_Stick() {
        Board board = new Board();

        // Dejamos caer la pieza L hasta el fondo 
        PieceLLeft pieceL = new PieceLLeft();
        board.addPieceBoard(pieceL);

        while (board.LimitesVeri(pieceL)) {
            pieceL.moveDown();
        }
        // retrocedemos porque se pasó una fila
        pieceL.setY(pieceL.getY() - 1);

        int finalYL = pieceL.getY();
        assertEquals(board.grid.length - pieceL.getPiece().length, finalYL);

        // Ahora colocamos un Stick que debe chocar con la L 
        PieceStick stick = new PieceStick();
        stick.rotateDer(); // lo usamos horizontal (4 bloques en fila)
        stick.setX(0);
        stick.setY(0);
        board.placePiece(stick, stick.getX(), stick.getY());

        // Simulamos la caída del Stick
        while (board.LimitesVeri(stick)) {
            stick.moveDown();
        }
        stick.setY(stick.getY() - 1); // corregimos el paso de más

        // Verificación de colisión
        // El stick debería haber quedado justo encima de la L
        assertTrue("El stick debe haber colisionado con la L",
                   stick.getY() < finalYL);

        // si intentamos bajarlo una más, no debería entrar
        stick.setY(stick.getY() + 1);
        assertFalse(board.LimitesVeri(stick));
    }
}
