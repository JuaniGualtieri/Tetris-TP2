package com.tetris;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Piece {
    
    public int[][] piece;   // Matriz que representa la forma de la pieza
    public int x;           // Posición en X
    public int y;           // Posición en Y
    private ClockDemo clock;
    private Timer timer;
    public int[][] shape;  
    private final Random random_rot = new Random(); // Para rotaciones aleatorias
    
    public Piece() {}

    // Constructor que inicializa la pieza con matriz y arranca un Timer
    public Piece(int[][] piece){
        this.piece = piece;
        this.timer = new Timer();
        this.clock = new ClockDemo();
        startTimer();
    }

    public void setPiece(int [][] piece){
        this.piece = piece;
    }

    public int[][] getPiece(){
        return piece; 
    }
    
    public int[][] getShape() {
        return getPiece(); // Alias de piece
    }
    
    public void setX(int x){ this.x = x; }
    public int getX(){ return x; }
    public void setY(int y){ this.y = y; }
    public int getY(){ return y; }

    // Rotación aleatoria a izquierda o derecha
    public void rotateRandom() {
        int num = random_rot.nextInt(2);
        if (num == 1) rotateIzq();
        else rotateDer();
    }

    // Rotación antihoraria
    public void rotateIzq() {
        int n = piece.length;
        int[][] rotatedPiece = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotatedPiece[n - 1 - j][i] = piece[i][j];
            }
        }
        this.piece = rotatedPiece;
    }

    // Rotación horaria
    public void rotateDer() {
        int n = piece.length;
        int[][] rotatedPiece = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotatedPiece[j][n - 1 - i] = piece[i][j];
            }
        }
        this.piece = rotatedPiece;
    }

    // Movimientos simples
    public void moveDown() { this.y += 1; }
    public void moveRight() { this.x += 1; }
    public void moveLeft() { this.x -= 1; }

    // Timer que baja la pieza automáticamente cada cierto tiempo
    public void startTimer() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                clock.tic();  // Marca el tiempo
                moveDown();   // Hace descender la pieza
            }
        }, 0, 2000);  // Cada 2 segundos
    }

    // Detiene el temporizador
    public void stopTimer() {
        timer.cancel();
    }
}


