package com.itacademy.nikolaichik.run;

import java.util.Random;

public class Matrix {

  private int[][] matrix;
  private int rows;
  private int columns;
  
  public Matrix(int rows, int columns) {
    matrix = new int[rows][columns];
    this.rows = rows;
    this.columns = columns;
  }
  
  public void fillRandom(int bounds) {
    Random random = new Random();
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        int randomValue = random.nextInt((bounds * 2) + 1) - bounds;
        matrix[i][j] = randomValue;
      }
    }
  }
  
  public void fillMathRandom(int bounds) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        int randomValue = (int) (Math.random() * (bounds * 2 + 1)) - bounds;
        matrix[i][j] = randomValue; 
      }
    }
  }
  
  public void print() {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println("============");
  }
  
  public void transponent() {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = i; j < matrix[i].length; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
      }
    }
  }
  
  public void sortRowsByColumn(int column) {
    for (int i = 1; i < matrix.length; i++) {
      for (int j = i; j > 0; j--) {
        if (matrix[j][column] > matrix[j - 1][column]) {
          for (int k = 0; k < matrix.length; k++) {
            int temp = matrix[j - 1][k];
            matrix[j - 1][k] = matrix[j][k];
            matrix[j][k] = temp;
          }
          
        }
      }
    }
  }
  
  public void sortColumnsByRow(int row) {
    for (int i = 1; i < matrix.length; i++) {
      for (int j = i; j > 0; j--) {
        if (matrix[row][j] > matrix[row][j - 1]) {
          for (int k = 0; k < matrix.length; k++) {
            int temp = matrix[k][j - 1];
            matrix[k][j - 1] = matrix[k][j];
            matrix[k][j] = temp;
          }
          
        }
      }
    }
  }
  
  public static void main(String[] args) {
    Matrix matrix = new Matrix(5, 5);
    matrix.fillMathRandom(10);
    matrix.print();
    matrix.transponent();
    matrix.print();
    matrix.sortRowsByColumn(0);
    matrix.print();
    matrix.sortColumnsByRow(0);
    matrix.print();
  }
}
