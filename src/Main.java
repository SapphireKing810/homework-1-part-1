import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int prototypeDataLength = 16;
        int largeDataLength = 2000;

        String[] prototypeInputPaths = {"prototype-ordered.txt", "prototype-reverse.txt", "prototype-random03.txt"};
        String[] largeInputPaths = {"large-ordered.txt", "large-reverse.txt", "large-random03.txt"};

        //initialize the arrays
        int[]   prototypeWorstCase = new int[prototypeDataLength];
        int[]   prototypeBestCase = new int[prototypeDataLength];
        int[]   prototypeAverageCase = new int[prototypeDataLength];

        int[]   largeWorstCase = new int[largeDataLength];
        int[]   largeBestCase = new int[largeDataLength];
        int[]   largeAverageCase = new int[largeDataLength];

        //populate the arrays
        populateArray(prototypeInputPaths[0], prototypeBestCase);
        populateArray(prototypeInputPaths[1], prototypeWorstCase);
        populateArray(prototypeInputPaths[2], prototypeAverageCase);

        populateArray(largeInputPaths[0], largeBestCase);
        populateArray(largeInputPaths[1], largeWorstCase);
        populateArray(largeInputPaths[2], largeAverageCase);


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
        writeFile(prototypeInputPaths[0], prototypeBestCase);
    }

    public static void populateArray(String path, int[] array) {
        try{
            File file = new File(path);
            Scanner scanner = new Scanner(file);

            System.out.println(path + " data set: "); //debug
            for (int j = 0; j < array.length; j++){
                array[j] = scanner.nextInt();
                System.out.println("Index: " + j + " number: " + array[j]); //debug
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void writeFile(String path, int[] array) {


        try{
            Scanner scanner = new Scanner(System.in);
            File file = new File("output-" + path);
            BufferedWriter writer = new BufferedWriter(new FileWriter(file.getName(), true));
            if(file.exists())
            {
                System.out.println("File already exist. Overwrite file?(y/n)");
                String input = scanner.nextLine();
                if (input == "y" || input == "Y")
                {
                    file.delete();
                }
            }
            else
            {
                for (int i = 0;i < array.length; i++){
                    //writer.write("Hello");
                    writer.write(array[i] + "\n");
                }
            }

            writer.close();
            //System.out.println(file.getName() + " file created.");
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void selectionSort(int[] array) {
            int temp, min, exchanges = 0, comparisons = 0;
            int n = array.length;

            for (int i = 0; i < n; i++) {
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