import javax.swing.*;

import java.util.Arrays;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 * @author Cagatay KARASU
 * @since 23.12.2020
 */

public class Cagatay_Karasu_Assignment3 {


    /*
    METHOD : MAIN
    ------------------------------------------------
    */
    public static void main(String[] args) {

        int n = Integer.parseInt(showInputDialog(null,
                "Enter the number of elements you want to store.",
                "YOUR ARRAY", JOptionPane.INFORMATION_MESSAGE));

        int[] array01 = new int[n];

        showMessageDialog(null,
                "Enter the elements of the array please.",
                "YOUR ARRAY", JOptionPane.INFORMATION_MESSAGE);

        System.out.print("Type your " + n + " numbers : ");
        for (int i = 0; i < n; i++) {
            array01[i] = Integer.parseInt(showInputDialog(null,
                    "Your " + (i+1) + ". element : ",
                    "YOUR ARRAY", JOptionPane.INFORMATION_MESSAGE));
        }

        int[] array02 = array01.clone();

        System.out.print("Your array : [");

        for (int i = 0; i < n; i++) {
            System.out.print(array01[i]);

            if (i != array01.length-1)
                System.out.print(", ");
            else
                System.out.println("]\n");
        }

        removeDuplicates(array01);
        freqElements(array02);
        determinantMatrix();
        multiply2matrix();
    }

    /*
    METHOD : REMOVING DUPLICATE ELEMENTS FROM THE ARRAY
    ------------------------------------------------
    */
    public static void removeDuplicates(int[] arr) {

        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (arr[i] == arr[j]) {

                    arr[j] = arr[n-1];
                    n--;
                    j--;
                }
            }
        }

        int[] newArray = Arrays.copyOf(arr,n);

        Arrays.sort(newArray);

        System.out.print("Your new array : [");

        for (int i = 0; i < newArray.length; i++) {
            System.out.print(newArray[i]);

            if (i != newArray.length-1)
                System.out.print(", ");
            else
                System.out.println("]\n");
        }
    }


    /*
    METHOD : GETTING THE FREQUENCIES OF THE ELEMENTS FROM A GIVEN ARRAY
    ------------------------------------------------
    */
    public static void freqElements(int[] arr) {

    int n = arr.length;

    boolean[] controlPoint = new boolean[n];

    Arrays.fill(controlPoint, false);

    for (int i = 0; i < n; i++) {
        if (!controlPoint[i]) {
            int count = 1;

            for (int j = i+1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    controlPoint[j] = true;
                    count++;

                }
            }
            System.out.println("Item " + i + ": " + arr[i] + " \t-- Frequency " + count);
        }
    }
    }

    /*
    METHOD : CALCULATING THE DETERMINANT OF A 3x3 MATRIX THAT IS GIVEN BY THE USER
    ------------------------------------------------
    */
    public static void determinantMatrix () {

        int[][] dMatrix = new int[3][3];

        showMessageDialog(null,
                "Enter 3 elements of your matrix's 1st row please.",
                "YOUR 3x3 MATRIX", JOptionPane.INFORMATION_MESSAGE);

        for (int i = 0; i < 3; i++) {
            dMatrix[0][i] = Integer.parseInt(showInputDialog(null,
                    "Your 1st row's " + (i + 1) + ". element : ",
                    "YOUR 3x3 MATRIX", JOptionPane.INFORMATION_MESSAGE));
        }

        showMessageDialog(null,
                "Enter 3 elements of your matrix's 2nd row please.",
                "YOUR 3x3 MATRIX", JOptionPane.INFORMATION_MESSAGE);

        for (int i = 0; i < 3; i++) {
            dMatrix[1][i] = Integer.parseInt(showInputDialog(null,
                    "Your 2nd row's " + (i + 1) + ". element : ",
                    "YOUR 3x3 MATRIX", JOptionPane.INFORMATION_MESSAGE));
        }

        showMessageDialog(null,
                "Enter 3 elements of your matrix's 3rd row please.",
                "YOUR 3x3 MATRIX", JOptionPane.INFORMATION_MESSAGE);

        for (int i = 0; i < 3; i++) {
            dMatrix[2][i] = Integer.parseInt(showInputDialog(null,
                    "Your 3rd row's " + (i + 1) + ". element : ",
                    "YOUR 3x3 MATRIX", JOptionPane.INFORMATION_MESSAGE));
        }

        System.out.println("\n\nYour 3x3 matrix is : \n--------------------");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(dMatrix[i][j] + "\t");
            }
            System.out.println();
        }

            int x = (dMatrix[0][0] * (dMatrix[1][1] * dMatrix[2][2] - dMatrix[1][2] * dMatrix[2][1]));
            int y = (dMatrix[0][1] * (dMatrix[1][0] * dMatrix[2][2] - dMatrix[1][2] * dMatrix[2][0]));
            int z = (dMatrix[0][2] * (dMatrix[1][0] * dMatrix[2][1] - dMatrix[1][1] * dMatrix[2][0]));

            double determinant = x - y + z;

            System.out.println("\nDeterminant of your matrix is : " + determinant);
    }


    /*
    METHOD : MULTIPLYING TWO GIVEN MATRICES
    ------------------------------------------------
    */
    public static void multiply2matrix () {

        int row01 = Integer.parseInt(showInputDialog(null,
                "Enter the number of rows of your 1st matrix please.",
                "YOUR 1ST MATRIX", JOptionPane.INFORMATION_MESSAGE));

        int col01 = Integer.parseInt(showInputDialog(null,
                "Enter the number of columns of your 1st matrix please.",
                "YOUR 1ST MATRIX", JOptionPane.INFORMATION_MESSAGE));

        int row02 = Integer.parseInt(showInputDialog(null,
                "Enter the number of rows of your 2nd matrix please.",
                "YOUR 2ND MATRIX", JOptionPane.INFORMATION_MESSAGE));

        int col02 = Integer.parseInt(showInputDialog(null,
                "Enter the number of columns of your 2nd matrix please.",
                "YOUR 2ND MATRIX", JOptionPane.INFORMATION_MESSAGE));

        int[][] matrix01 = new int[row01][col01];
        int[][] matrix02 = new int[row02][col02];

        for (int i = 0; i < row01; i++) {
            for (int j = 0; j < col01; j++) {
                matrix01[i][j] = Integer.parseInt(showInputDialog(null,
                        "Your 1st matrix's [" + i + "] [" + j + "]. element : ",
                        "YOUR 1st MATRIX", JOptionPane.INFORMATION_MESSAGE));
            }
        }

        for (int i = 0; i < row02; i++) {
            for (int j = 0; j < col02; j++) {
                matrix02[i][j] = Integer.parseInt(showInputDialog(null,
                        "Your 2nd matrix's [" + i + "] [" + j + "]. element : ",
                        "YOUR 2nd MATRIX", JOptionPane.INFORMATION_MESSAGE));
            }
        }

        System.out.println("\nYour 1st matrix\n----------------");

        for (int i = 0; i < row01; i++) {
            for (int j = 0; j < col01; j++) {
                System.out.print(matrix01[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("\nYour 2nd matrix\n----------------");

        for (int i = 0; i < row02; i++) {
            for (int j = 0; j < col02; j++) {
                System.out.print(matrix02[i][j] + "\t");
            }
            System.out.println();
        }

        if (row02 != col01) {
            showMessageDialog(null,
                    "Matrices dont match! So multiplication is not possible.",
                    "ERROR!", JOptionPane.WARNING_MESSAGE);
            // System.out.println("\nMatrices dont match! So multiplication is not possible.");
        }

        else {
            int[][] multipliedMatrix = new int[row01][col02];

            for (int i = 0; i < row01; i++) {
                for (int j = 0; j < col02; j++) {
                    for (int k = 0; k < row02; k++) {
                        multipliedMatrix[i][j] += matrix01[i][k] * matrix02[k][j];
                    }
                }
            }

            System.out.println("\nThe Result of the multiplication\n--------------------------------");

            for (int i = 0; i < row02; i++) {
                for (int j = 0; j < col02; j++) {
                    System.out.print(multipliedMatrix[i][j] + "\t");
                }
                System.out.println();
            }
        }
    }
}
