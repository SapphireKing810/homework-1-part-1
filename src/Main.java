import java.io.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner inputScanner = new Scanner(System.in);
        String fileName = null;
        int length;

        System.out.print("Please enter the size the input: ");
        length = Integer.parseInt(inputScanner.nextLine());
        System.out.println("The size of data is: " + length);
        int[] data = new int[length];

        while(fileName == null){
            System.out.print("Please type the name of file to be sorted: ");
            fileName = inputScanner.nextLine();
            System.out.println("file name: " + fileName);
            if(!fileName.matches("(.*).txt")){ //basic error handling
                fileName = null;
                System.out.println("ERROR: Please add \".txt\" file extension to the file name.");
            }
        }

        //populates the array
        populateArray(fileName, data);

        //clone array as not to reference
        System.out.println(fileName);
        //bubbleSort(fileName, data.clone());
        //selectionSort(fileName, data.clone());
        insertionSort(fileName, data.clone());
    }

    public static void populateArray(String path, int[] array) throws Exception {
        File file = new File(path);
        Scanner scanner = new Scanner(file);

        System.out.println(path + " data set: "); //debug

        for (int j = 0; j < array.length; j++){
            array[j] = scanner.nextInt();
            System.out.println("Index: " + j + " number: " + array[j]); //debug
        }
    }
    public static void writeFile(String path, int[] array) {
        try{
            File file = new File("output-" + path);
            FileWriter fWriter = new FileWriter(file); //will override current file if the file already exist
            PrintWriter pWriter = new PrintWriter(fWriter);

            for (int j : array) {
                pWriter.println(j);
            } //end for

            pWriter.close();
        } catch (Exception e){
            e.printStackTrace();
        } // end try-catch
    } // end write file

    public static void selectionSort(String fileName, int[] array) {
        int temp, minIndex, exchanges = 0, comparisons = 0;
        int n = array.length;

        for (int i = 0; i < n-1; i++) {

            minIndex = i;
            for (int j = i + 1; j < n; j++) {
                comparisons++;
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                } //end if
            } // end inner loop
            if(minIndex != i){
                temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
                exchanges++;
            } //end if
        }// end outer loop

        System.out.println("=========================================================");
        System.out.println("Selection Sort");
        System.out.println("Number of Exchanges: " + exchanges);
        System.out.println("Number of Comparisons: " + comparisons);
        System.out.println("=========================================================");
        writeFile("selection-" + fileName, array);
        } // end selection sort

    public static void bubbleSort(String fileName, int[] array){
        int temp, comparisons = 0, exchanges = 0, n = array.length;
        boolean isSorted;

        //debug prototype-reverse.txt
        System.out.println("Before: ");
        for (int k: array) { System.out.print(k + " ");}
        System.out.println("");

        //Print throughout
        for(int i = 1; i < n; i++){
            isSorted = true;
            System.out.println("Pass " + i + ": ");
            for(int j = 0; j < n-i; j++){
                comparisons++;
                System.out.print("Iteration " + (j+1) + ": ");
                if(array[j] > array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    isSorted = false;
                    exchanges++;
                    for (int k: array) { System.out.print(k + " ");}
                    System.out.print(" exchange successful. count = " + exchanges);
                    System.out.println("");
                }
                else {
                    for (int k: array) { System.out.print(k + " ");}
                    System.out.print(" no exchange performed.");
                    System.out.println("");
                }
            }// end inner loop
            System.out.println("Current # of comparisons " + comparisons);
            if(isSorted)
                break;
        } // end outer loop
        //debug
        System.out.println("After: ");
        for (int k: array) { System.out.print(k + " ");}
        System.out.println("");

        System.out.println("=========================================================");
        System.out.println("Bubble Sort");
        System.out.println("Number of Exchanges: " + exchanges);
        System.out.println("Number of Comparisons: " + comparisons);
        System.out.println("=========================================================");
        writeFile("bubble-" + fileName, array);
    }// end bubble sort

    public static void insertionSort(String fileName, int[] array){
        int temp, comparisons = 0, exchanges = 0;
        int n = array.length;

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

        System.out.println("=========================================================");
        System.out.println("Insertion Sort");
        System.out.println("Number of Exchanges: " + exchanges);
        System.out.println("Number of Comparisons: " + comparisons);
        System.out.println("=========================================================");
        writeFile("insertion-" + fileName, array);
    } //end insertion sort
}