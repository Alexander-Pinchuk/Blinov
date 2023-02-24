package part2A;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

/**
 * @author Petrov
 * @version 1.0
 */

public class Task1 {
    public static void main(String[] args) {
        ArrayFilling arrayFilling = new ArrayFilling();
        int [] mass = arrayFilling.arrayFill();
        int []massChisel = mass.clone();
        TaskProcess taskProcess = new TaskProcess();
        AuthorName authorName = new AuthorName();

        NumberLength numberLength = new NumberLength();
        MinElemIndexes minElemIndexes = new MinElemIndexes();

        WriteElements writeElements = new WriteElements();
        writeElements.print(minElemIndexes.minElemIndexes(numberLength.numberOfDigits(mass)),massChisel);
        // Почему нельзя просто mass вместо arrayFilling.arrayFill() ????
        // Создать копию массива и с ней работать.


        authorName.setName("Petrov");
        authorName.WriteName();
        taskProcess.getTask(2,1,2023,10,20);
        taskProcess.TaskDone(5,1,2023,17,40);
    }
}

class ArrayFilling{
    /**
     * Заполняет массив
     * @return Возвращает заполненный массив
     */
    public int[] arrayFill(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            System.out.println("enter " +(i+1)+ " number: ");
            array[i] = sc.nextInt();
        }

        return array;
    }
}

/**
 * Вывод даты и времени получения и сдачи задания
 */
class TaskProcess{
    Calendar calendarGetTask = Calendar.getInstance();
    Calendar calendarTaskDone = Calendar.getInstance();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d MMMM y HH:mm");

    public void getTask (int day, int month, int year, int hours, int minutes){
        calendarGetTask.set(year,month,day,hours,minutes);
        System.out.println("Getting task: " + simpleDateFormat.format(calendarGetTask.getTime()));
    }
    public void TaskDone (int day, int month, int year, int hours, int minutes){
        calendarTaskDone.set(year,month,day,hours,minutes);
        System.out.println("Task was done: " + simpleDateFormat.format(calendarTaskDone.getTime()));
    }
}

/**
 * @author Выводит имя автора
 */
class AuthorName{

    private String name;

    public void setName(String name){
        this.name = name;
    }
    public void WriteName(){
        System.out.println("Name: " + name);
    }
}


 class NumberLength {
     /**
      * @param mas Массив чисел
      * @return Массив c количеством цифр в числе
      */

    int [] numberOfDigits(int[] mas) {
       int [] numberDigits = new int[mas.length];
        for (int i = 0; i < mas.length; i++) {
            int n = 1;
            while ((mas[i] /= 10) > 1) {
                n++;
            }
            numberDigits[i] = n;
        }
        return numberDigits;
    }
}

class MinElemIndexes{
    int minDig;
    /**
     *
     * @param numberDigits Массив количества цифр в числе
     * @return Возвращает массив минимальных индеков чисел массива элементов чисел mass
     */
    int [] minElemIndexes(int [] numberDigits){
        int [] minElemIndexes = new int[numberDigits.length];
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
}

class WriteElements{
    /**
     *
     * @param minElemIndexes Массив индексов минимальных элементов
     * @param mass Массив элементов
     */
    void print(int[] minElemIndexes, int [] mass){
        for (int i = 0; i < minElemIndexes.length; i++) {
            if (minElemIndexes[i]!=0){
                System.out.print("Index: "+ minElemIndexes[i]+ " = " + mass[minElemIndexes[i]]+ "\n");
            }
        }
    }
}