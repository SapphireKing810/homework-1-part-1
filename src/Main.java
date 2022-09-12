import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String[] fileNames = {"prototype-ordered.txt", "prototype-reverse.txt", "prototype-random01.txt"};
        Integer[] numberSelection;
        ArrayList<Integer> listOfNumbers = new ArrayList<Integer>();
        //for each fileName in FileNames
        for (String fileName : fileNames) {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextInt()) {
                listOfNumbers.add(scanner.nextInt());
            }
            numberSelection = listOfNumbers.toArray(new Integer[0]);
            System.out.println(" ========================= ");
            System.out.println("Testing selection sort: ");
            if (fileName == fileNames[0]) {
                System.out.println(" --- best case ---");
                selectionSort(numberSelection);
            } else if (fileName == fileNames[1]) {
                System.out.println(" --- worst case ---");
                selectionSort(numberSelection);
            } else if (fileName == fileNames[2]) {
                System.out.println(" --- avarage case ---");
                selectionSort(numberSelection);
            }
            System.out.println(" ========================= ");
            System.out.println(listOfNumbers);

            listOfNumbers.clear();
        } //end for loop
    }
        public static void selectionSort(Integer[] array) {
            int temp, min, exchanges = 0, comparisons = 0;
            int numberOfItems = array.length;
            for (int pass=0; pass != numberOfItems - 1; pass++) {
                min = pass;
                for (int index = pass+1; index != numberOfItems; index++) {
                    comparisons++;
                    if (array[index] < array[min])
                        min = index;
                } // end inner loop
                temp = array[min];
                array[min] = array[pass];
                array[pass] = temp;
                exchanges++;


            } // end outer loop
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

        int temp, comparisons = 0, swaps = 0, n = array.length;
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
                    swaps++;
                }
            }// end inner loop
            if(isSorted)
                break;
        } // end outer loop

        System.out.println("Bubble Sort: Number of Exchanges: " +
                swaps);
        System.out.println("Bubble Sort: Number of Comparisons: " +
                comparisons);
        System.out.println ("Sorted file:");
        for (int j : array) System.out.print(j + " ");
        System.out.println ();
    }// end bubble sort

    public static void insertionSort(int[]array){
        //                 Comparisons      Exchanges
        //Best Case     |   O(n)        |   O(1)
        //Worst Case    |   O(n^2)      |   O(n^2)
        //Avg Case      |   O(n^2)      |   O(n^2)
        int temp, comparisons = 0, exchanges = 0, bestCaseComparison = 0;

        for(int i = 1; i < array.length; i++){
            temp = array[i];
            int j = i - 1;
            //noinspection ReassignedVariable
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