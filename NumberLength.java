package part2A.task1;
import java.util.Arrays;
import java.util.Scanner;

public class NumberLength {
    public static void main(String[] args) {
        NumberLength numberLength = new NumberLength();
        Author petrov = new Author("Petrov");
        System.out.println(petrov);
        Task getTask = new Task(23,1,2023,10,20);
        Task taskDone = new Task(27,1,2023,22, 0);
        System.out.println(getTask+ "\n"+taskDone);

//        int[] arrayOfNumbers = numberLength.arrayfill();
//        System.out.println("Массив " + Arrays.toString(arrayOfNumbers));
//        int[] numberOfDigits = numberLength.numberOfDigits(arrayOfNumbers);
//        System.out.println("Количество цифр " + Arrays.toString(numberOfDigits));
//        int[] minElemIndexes = numberLength.minElemIndexes(numberOfDigits);
//        System.out.println("Индексы с минимальными элементами " + Arrays.toString(minElemIndexes));
//        numberLength.print(minElemIndexes,arrayOfNumbers);
//        System.out.println();



        numberLength.print(numberLength.minElemIndexes(numberLength.numberOfDigits(numberLength.arrayfill())), numberLength.arrayfill());

    }

    /**
     * Заполняет массив arrayOfNumbers
     * @return Возвращает заполненный массив
     */
    int [] arrayOfNumbers;
    public int[] arrayfill(){
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the number of numbers: ");
            int n = sc.nextInt();
            arrayOfNumbers = new int[n];
            for (int i = 0; i < arrayOfNumbers.length; i++) {
                System.out.println("enter " +(i+1)+ " number: ");
                arrayOfNumbers[i] = sc.nextInt();
            }
            return arrayOfNumbers;
    }

    /**
     * @param arrayOfNumbers Массив чисел
     * @return Массив c количеством цифр в числе
     */
    int[] numberOfDigits(int[] arrayOfNumbers) {
        int [] numberDigits = new int[arrayOfNumbers.length];
        for (int i = 0; i < arrayOfNumbers.length; i++) {
            int n = 1;
            while ((arrayOfNumbers[i] /= 10) > 1) {
                n++;
            }
            numberDigits[i] = n;
        }
        return numberDigits;
    }

    /**
     * @param numberDigits Массив количества цифр в числе
     * @return Возвращает массив минимальных индеков чисел массива элементов чисел arrayOfNumbers
     */
    int minDig;
    int[] minElemIndexes(int [] numberDigits){
        int []minElemIndexes = new int[numberDigits.length];
        for (int i=0; i< numberDigits.length;i++){
            minDig = Integer.MAX_VALUE;
            if (numberDigits[i]<minDig){
                minDig=numberDigits[i];
            }
        }
        int n = 0;
        for (int i=0; i< numberDigits.length;i++){
            if (numberDigits[i]==minDig){
                minElemIndexes[n++] = i;
            }
        }
        return minElemIndexes;
    }

    /**
     *
     * @param minElemIndexes Массив индексов минимальных элементов
     * @param arrayOfNumbers Массив элементов
     */
    void print(int[] minElemIndexes, int [] arrayOfNumbers){
        for (int i = 0; i < minElemIndexes.length; i++) {
            if (minElemIndexes[i]!=0){
                System.out.print("Index: "+ minElemIndexes[i]+ " = " + arrayOfNumbers[minElemIndexes[i]]+ "\n");
            }
        }
    }
}
