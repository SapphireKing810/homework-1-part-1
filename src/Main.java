import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String[] prototypeInputPaths = {"prototype-ordered.txt", "prototype-reverse.txt", "prototype-random02.txt"};
        String[] largeInputPaths = {"large-ordered.txt", "large-reverse.txt", "large-random01.txt"};
        int prototypeDataLength = 16;
        int largeDataLength = 2000;

        int[]   prototypeWorstCase = new int[prototypeDataLength];
        int[]   prototypeBestCase = new int[prototypeDataLength];
        int[]   prototypeAverageCase = new int[prototypeDataLength];

        int[]   largeWorstCase = new int[largeDataLength];
        int[]   largeBestCase = new int[largeDataLength];
        int[]   largeAverageCase = new int[largeDataLength];

        for (int i = 0; i < prototypeInputPaths.length; i++){
            File file = new File(prototypeInputPaths[i]);
            Scanner scanner = new Scanner(file);
            for (int j = 0; j < prototypeDataLength; j++){
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

        for (int i = 0; i < largeInputPaths.length; i++){
            File file = new File(largeInputPaths[i]);
            Scanner scanner = new Scanner(file);
            for (int j = 0; j < largeDataLength; j++){
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
        System.out.println("Prototype Data Sets");
        System.out.println(" ========================= ");
        System.out.println("Testing selection sort: ");
        System.out.println(" --- best case ---");
        selectionSort(prototypeBestCase.clone());
        System.out.println(" --- worst case ---");
        selectionSort(prototypeWorstCase.clone());
        System.out.println(" --- average case ---");
        selectionSort(prototypeAverageCase.clone());
        System.out.println(" ========================= ");
        System.out.println("Testing bubble sort: ");
        System.out.println(" --- best case ---");
        bubbleSort(prototypeBestCase.clone());
        System.out.println(" --- worst case ---");
        bubbleSort(prototypeWorstCase.clone());
        System.out.println(" --- average case ---");
        bubbleSort(prototypeAverageCase.clone());
        System.out.println(" ========================= ");
        System.out.println("Testing insertion sort: ");
        System.out.println(" --- best case ---");
        insertionSort(prototypeBestCase.clone());
        System.out.println(" --- worst case ---");
        insertionSort(prototypeWorstCase.clone());
        System.out.println(" --- average case ---");
        insertionSort(prototypeAverageCase.clone());
        System.out.println(" ========================= ");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("Large Data Sets");
        System.out.println(" ========================= ");
        System.out.println("Testing selection sort: ");
        System.out.println(" --- best case ---");
        selectionSort(largeBestCase.clone());
        System.out.println(" --- worst case ---");
        selectionSort(largeWorstCase.clone());
        System.out.println(" --- average case ---");
        selectionSort(largeAverageCase.clone());
        System.out.println(" ========================= ");
        System.out.println("Testing bubble sort: ");
        System.out.println(" --- best case ---");
        bubbleSort(largeBestCase.clone());
        System.out.println(" --- worst case ---");
        bubbleSort(largeWorstCase.clone());
        System.out.println(" --- average case ---");
        bubbleSort(largeAverageCase.clone());
        System.out.println(" ========================= ");
        System.out.println("Testing insertion sort: ");
        System.out.println(" --- best case ---");
        insertionSort(largeBestCase.clone());
        System.out.println(" --- worst case ---");
        insertionSort(largeWorstCase.clone());
        System.out.println(" --- average case ---");
        insertionSort(largeAverageCase.clone());
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

        for(int i = 1; i < n; i++){
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
        int n = array.length;
        System.out.print("Unsorted Array: ");
        for (int k : array) System.out.print(k + " ");
        System.out.println("");

        for(int i = 1; i < n; i++){
            temp = array[i];
            int j = i - 1;
            while(j >= 0 && array[j] > temp){
                array[j + 1] = array[j];
                j--;
                exchanges++;
                comparisons++;
            } //end while loop
            array[j+1] = temp;

        } //end loop
        System.out.println("Insertion Sort: Number of Exchanges: " +
                exchanges);
        System.out.println("Insertion Sort: Number of Comparisons: " +
                comparisons);
        System.out.println ("Sorted file:");
        for (int j : array) System.out.print(j + " ");
        System.out.println ();
    }
}