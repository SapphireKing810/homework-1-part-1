import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String[] prototypeInputPaths = {"prototype-ordered.txt", "prototype-reverse.txt", "prototype-random01.txt"};
        String[] largeInputPaths = {"large-ordered.txt", "large-reverse.txt", "large-random01.txt"};

        int[]   prototypeWorstCase = new int[16];
        int[]   prototypeBestCase = new int[16];
        int[]   prototypeAverageCase = new int[16];

        int[]   largeWorstCase = new int[2000];
        int[]   largeBestCase = new int[2000];
        int[]   largeAverageCase = new int[2000];

        for (int i = 0; i < 3; i++){
            File file = new File(prototypeInputPaths[i]);
            Scanner scanner = new Scanner(file);
            for (int j = 0; j < 16; j++){
                if(i == 0){
                    if (j == 0)
                        System.out.println("Best case data set: ");
                    prototypeBestCase[j] = scanner.nextInt();
                    System.out.println("Index: " + j + " number: " + prototypeBestCase[j]);
                } else if (i == 1) {
                    if (j == 0)
                        System.out.println("Worst case data set: ");
                    prototypeWorstCase[j] = scanner.nextInt();
                    System.out.println("Index: " + j + " number: " + prototypeWorstCase[j]);
                } else if (i == 2) {
                    if (j == 0)
                        System.out.println("Average case data set: ");
                    prototypeAverageCase[j] = scanner.nextInt();
                    System.out.println("Index: " + j + " number: " + prototypeAverageCase[j]);
                }

            }
            System.out.println("");
        }
        for (int i = 0; i < 3; i++){
            File file = new File(largeInputPaths[i]);
            Scanner scanner = new Scanner(file);
            for (int j = 0; j < 2000; j++){
                if(i == 0){
                    if (j == 0)
                        System.out.println("Best case data set: ");
                    largeBestCase[j] = scanner.nextInt();
                    System.out.println("Index: " + j + " number: " + largeBestCase[j]);
                } else if (i == 1) {
                    if (j == 0)
                        System.out.println("Worst case data set: ");
                    largeWorstCase[j] = scanner.nextInt();
                    System.out.println("Index: " + j + " number: " + largeWorstCase[j]);
                } else if (i == 2) {
                    if (j == 0)
                        System.out.println("Average case data set: ");
                    largeAverageCase[j] = scanner.nextInt();
                    System.out.println("Index: " + j + " number: " + largeAverageCase[j]);
                }

            }
            System.out.println("");
        }

        System.out.println(" ========================= ");
        System.out.println("Testing selection sort: ");
        System.out.println(" --- best case ---");
        selectionSort(prototypeBestCase);
        System.out.println(" --- worst case ---");
        selectionSort(prototypeWorstCase);
        System.out.println(" --- avarage case ---");
        selectionSort(prototypeAverageCase);
        System.out.println(" ========================= ");

    }
        public static void selectionSort(int[] array) {
            int temp, min, exchanges = 0, comparisons = 0;
            int n = array.length;

            for (int i = 0; i < n-1; i++) {
                    min = i;
                    for (int j = i + 1; j < n; j++) {
                        comparisons++;
                        if (array[j] < array[min]) {
                            min = j;

                        }
                    } // end inner loop
                    if(min != i){
                        temp = array[min];
                        array[min] = array[i];
                        array[i] = temp;
                        exchanges++;
                    }
            }// end outer loop
            System.out.println("Selection Sort: Number of Exchanges: " +
                    exchanges);
            System.out.println("Selection Sort: Number of Comparisons: " +
                    comparisons);
            System.out.println ("Sorted file:");
            for (int i= 0; i < array.length; i++)
                System.out.print (array[i] + " ");
            System.out.println ();
        } // end selection sort
    public static void bubbleSort(int[] array){
        int temp, comparisons = 0, exchanges = 0, n = array.length;
        boolean isSorted;

        for(int i = 1; i != n; i++){
            isSorted = true;
            for(int j = 0; j < n-i; j++){
                comparisons++;
                if(array[j] > array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    isSorted = false;
                    exchanges++;
                }
            }// end inner loop
            if(isSorted)
                break;
        } // end outer loop

        System.out.println("Bubble Sort: Number of Exchanges: " +
                exchanges);
        System.out.println("Bubble Sort: Number of Comparisons: " +
                comparisons);
        System.out.println ("Sorted file:");
        for (int j : array) System.out.print(j + " ");
        System.out.println ();
    }// end bubble sort

    public static void insertionSort(int[] array){
        //                 Comparisons      Exchanges
        //Best Case     |   O(n)        |   O(1)
        //Worst Case    |   O(n^2)      |   O(n^2)
        //Avg Case      |   O(n^2)      |   O(n^2)
        int temp, comparisons = 0, exchanges = 0, bestCaseComparison = 0;

        for(int i = 1; i < array.length; i++){
            temp = array[i];
            int j = i - 1;

            bestCaseComparison++;
            while(j >= 0 && array[j] > temp){
                comparisons++;
                array[j+1] = array[j];
                j--;
                exchanges++;
            } //end while loop
            array[j+1] = temp;
        } //end loop
        System.out.println("Insertion Sort: Number of Exchanges: " +
                exchanges);
        System.out.println("Insertion Sort: Number of Comparisons: " +
                comparisons);
        System.out.println("Insertion Sort: Number of Comparisons: " +
                bestCaseComparison);
        System.out.println ("Sorted file:");
        for (int j : array) System.out.print(j + " ");
        System.out.println ();
    }
}