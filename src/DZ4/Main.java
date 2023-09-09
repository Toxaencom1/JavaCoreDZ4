package DZ4;

import DZ4.exceptions.MyArrayDataException;
import DZ4.exceptions.MyArraySizeException;

import java.util.Arrays;
import java.util.Random;

/*
1 Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4. При
подаче массива другого размера необходимо бросить исключение MyArraySizeException.
2 Далее метод должен пройтись по всем элементам массива, преобразовать в int и
просуммировать. Если в каком-то элементе массива преобразование не удалось (например, в
ячейке лежит символ или текст вместо числа), должно быть брошено исключение
MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
3 В методе main() вызвать полученный метод, обработать возможные исключения
MyArraySizeException и MyArrayDataException и вывести результат расчета.
 */

/**
 * Entry point to Main
 */
public class Main {
    /**
     * Static Const variable to rule size needs
     */
    private static final int ARRAY_SIZE_NEEDS = 4;
    /**
     * Static Object of Random class
     */
    private static final Random random = new Random();

    /**
     * main method to Demonstrate exceptions working
     * One run - one hundred attempts
     *
     * @param args of app
     */
    public static void main(String[] args) {
        System.out.println("Demonstrate exceptions working\n");
//        String[][] strArray =
//                new String[][]{
//                        {"1", "2", "3", "4"},
//                        {"5", "6", "7", "8"},
//                        {"9", "10", "11", "12"},
//                        {"13", "14", "15", "16"}}; // to manual tests
        int sum = 0, sumCount = 0, sizeExCount = 0, dataExCount = 0;
        for (int i = 0; i < 100; i++) {
            String[][] strArray = generateRandomArray();
            System.out.println((i + 1) + ". " + Arrays.deepToString(strArray));
            try {
                sum = arraySumParsing(strArray);
                sumCount++;
                System.out.printf(((sum != 0) ? "Sum = %d" : " ") + "%n", sum);
            } catch (MyArraySizeException e) {
                System.out.printf(e.getMessage() + ", size is %dx%d\n", e.getRows(), e.getColumns());
                sizeExCount++;
            } catch (MyArrayDataException e) {
                System.out.printf(e.getMessage() + ", array cell[%d][%d] is \"%s\"\n\n",
                        e.getRow(), e.getColumn(), e.getValue());
                dataExCount++;
//                e.printStackTrace();
            }
        }
        System.out.printf("\nCorrect program ending!!!\n Sum count = %d, SizeExCount = %d, DataExCount = %d\n",
                sumCount, sizeExCount, dataExCount);
        System.out.println(" Try again!");
    }

    /**
     * Method to check array size, using ARRAY_SIZE_NEEDS
     *
     * @param arr input Array to check.
     * @return boolean value
     * @throws MyArraySizeException if not ARRAY_SIZE_NEEDS
     */
    private static boolean checkArraySize(String[][] arr) throws MyArraySizeException {
        for (int i = 0; i < arr.length; i++) {
            if (arr.length != ARRAY_SIZE_NEEDS || arr[i].length != ARRAY_SIZE_NEEDS) {
                throw new MyArraySizeException(
                        String.format("The array size is not %1$dx%1$d", ARRAY_SIZE_NEEDS),
                        arr.length,
                        arr[i].length);
            }
        }
        return true;
    }

    /**
     * Method to sum parsed strings in integer value
     * Method checks array size, then parse string value to integer, and sum them
     *
     * @param arr input array who needs a sum.
     * @return Integer value (sum)
     * @throws MyArrayDataException if string value not a number
     */
    public static int arraySumParsing(String[][] arr) throws MyArrayDataException, MyArraySizeException {
        int sum = 0;
        if (checkArraySize(arr)) {
            for (int i = 0; i < ARRAY_SIZE_NEEDS; i++) {
                for (int j = 0; j < ARRAY_SIZE_NEEDS; j++) {
                    try {
                        sum += Integer.parseInt(arr[i][j]);
                    } catch (NumberFormatException e) {
                        throw new MyArrayDataException("Can't parse to Integer", arr[i][j], i, j, e);
                    }
                }
            }
        }
        return sum;
    }

    /**
     * Generate a random String[][] array with random elements and parameters.
     * Also in random cases generate "Not A Number" element in a random position.
     *
     * @return String[][] array
     */
    public static String[][] generateRandomArray() {
        int rows = random.nextInt(ARRAY_SIZE_NEEDS - 1, ARRAY_SIZE_NEEDS + 2);
        int columns = random.nextInt(ARRAY_SIZE_NEEDS - 1, ARRAY_SIZE_NEEDS + 2);
        String[][] newArray = new String[rows][columns];
        for (int i = 0; i < newArray.length; i++) {
            for (int j = 0; j < newArray[i].length; j++) {
                newArray[i][j] = Integer.toString(random.nextInt(100));
            }
        }
        if ((rows == ARRAY_SIZE_NEEDS && rows == columns) && random.nextInt(4) == 1) {
            newArray[random.nextInt(rows)][random.nextInt(columns)] = "NAN";
        }
        return newArray;
    }
}
