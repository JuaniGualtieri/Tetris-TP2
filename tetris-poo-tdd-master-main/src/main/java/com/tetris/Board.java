package com.tetris;
import java.util.Random;

public class Board {

    private final int ancho = 10;
    private final int alto = 20; // Cambié a 20 para cumplir con el requerimiento de 10x20
    public final int[][] grid = new int[alto][ancho]; // La matriz debe ser alto x ancho
    private Piece pieceActual;
    private final Random random = new Random();
    private int totalCleared = 0;
    private final int linesToClear = 5; //completar 5 lineas :p

    // Agrega la pieza al tablero de manera aleatoria en el primer renglón
    public void addPieceBoard(Piece piece) {
        int xPos = random.nextInt(ancho - piece.getShape()[0].length); // Evita que la pieza salga de los bordes
        pieceActual = piece;
        placePiece(pieceActual, xPos, 0); // Coloca la pieza en el tablero en la fila superior
    }

    // Método que verifica si la pieza está dentro de los límites del tablero y considera las colisiones 
    public boolean LimitesVeri(Piece piece) {  // EL GOAT
        int[][] shape = piece.getPiece();
        int pieceWidth = shape[0].length;
        int pieceHeight = shape.length;
        int x = piece.getX();
        int y = piece.getY();
    
        // Verifica que la pieza no salga por los lados ni por abajo del tablero
        if (x < 0 || x + pieceWidth > ancho || y < 0 || y + pieceHeight > alto) {
            return false;
        }
    
        // Verifica si la pieza se superpone con otras piezas en el tablero
        for (int i = 0; i < pieceHeight; i++) {
            for (int j = 0; j < pieceWidth; j++) {
                if (shape[i][j] != 0) { // Si la celda de la pieza es diferente de 0
                    if (grid[y + i][x + j] != 0) {
                        return false; // La pieza se superpone con otra pieza
                    }
                }
            }
        }
    
        return true;    
    } 

    public boolean moveDown() {
        int currentY = pieceActual.getY();
        pieceActual.setY(currentY + 1);
    
        // Verifica si el movimiento está dentro de los límites del tablero
        if (!LimitesVeri(pieceActual)) {
            pieceActual.setY(currentY); // Revertir el movimiento si está fuera de los límites
        }
        return true; // Movimiento válido
    }

    public boolean moveRight() {
        if (pieceActual == null) {
            return false;
        }
    
        int currentX = pieceActual.getX(); // Coordenada actual 'x'
        pieceActual.setX(currentX + 1); 
    
        // Verifica si la pieza sigue dentro de los límites después del movimiento
        if (!LimitesVeri(pieceActual)) {
            pieceActual.setY(currentX); 
        }

        pieceActual.moveDown();
    
        // Actualiza el tablero con la nueva posición de la pieza
        updateBoard();
        return true; // Movimiento válido
    }

    public boolean moveLeft() {
        if (pieceActual == null) {
            return false;
        }
    
        int currentX = pieceActual.getX(); // Coordenada actual 'x'
        pieceActual.setX(currentX - 1); 
    
        // Verifica si la pieza sigue dentro de los límites después del movimiento
        if (!LimitesVeri(pieceActual)) {
            pieceActual.setY(currentX); // Si se sale, vuelve a la posición anterior
        }
        
        pieceActual.moveDown();

        // Actualiza el tablero con la nueva posición de la pieza
        updateBoard();
        return true; // Movimiento válido
    }
    
    public void updateBoard() {
        // Primero, limpia el tablero
        clearBoard();
        
        // Luego, coloca la pieza en la nueva posición
        placePiece(pieceActual, pieceActual.getX(), pieceActual.getY());
        checkFinalDelJuego();
    }
    
    private void clearBoard() {
        // Limpia las celdas ocupadas por la pieza actual
        int[][] shape = pieceActual.getPiece();
        int pieceWidth = shape[0].length;
        int pieceHeight = shape.length;
        int x = pieceActual.getX();
        int y = pieceActual.getY();
    
        for (int i = 0; i < pieceHeight; i++) {
            for (int j = 0; j < pieceWidth; j++) {
                if (shape[i][j] != 0) { // Si la celda de la pieza es diferente de 0
                    grid[y + i][x + j] = 0; // Limpia la celda en el tablero
                }
            }
        }
    }
    
    private void placePiece(Piece piece, int x, int y) {
        int[][] shape = piece.getPiece();
        int pieceWidth = shape[0].length;
        int pieceHeight = shape.length;
    
        for (int i = 0; i < pieceHeight; i++) {
            for (int j = 0; j < pieceWidth; j++) {
                if (shape[i][j] != 0) { // Si la celda de la pieza es diferente de 0
                    grid[y + i][x + j] = shape[i][j]; // Coloca la pieza en el tablero
                }
            }
        }
    }

    public boolean isLineComplete(int[] row) {
        for (int cell : row) {
            if (cell == 0) {  // si encuentra vacia corto
                return false;
            }
        }
        return true;  // si la linea esta completa
    }

    public void removeLine(int row) { //elimina fila y baja las superiores
        for (int i = row; i > 0; i--) {
            grid[i] = grid[i - 1];
        }
        grid[0] = new int[ancho]; 
    }

    
    public int clearLinea() { //limpia la linea :P (se integran las func anteriores)
        int linesCleared = 0;
        for (int row = 0; row < alto; row++) {
            if (isLineComplete(grid[row])) {
                removeLine(row);
                linesCleared++;
            }
        }
        return linesCleared;
    }

    public boolean checkFinalDelJuego() { //se modifico por boolean
        int linesCleareds = clearLinea();
        totalCleared += linesCleareds;
    
        return totalCleared >= linesToClear;
    }
}
