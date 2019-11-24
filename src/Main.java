import exceptions.MyArraySizeException;
import exceptions.MyArrayDataException;

public class Main {

    static int arraySize = 4;

    public static void main(String[] args) {

        String[][] MyArray = {{"1", "2", "3", "1"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}};
        int sum = 0;

        try {
            sum = sumArray(MyArray);
            System.out.println("Результат сложения всех элементов массива: " + sum);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Работа программы завершена.");
        }
    }

    static int sumArray(String[][] MyArray) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;

        checkDimensionArray(MyArray);
        checkDataInArray(MyArray);

        for (int i = 0; i < MyArray.length; i++) {
            for (int j = 0; j < MyArray[i].length; j++) {

                sum = sum + Integer.parseInt(MyArray[i][j]);
            }
        }

        return sum;
    }

    static void checkDimensionArray(String[][] MyArray) throws MyArraySizeException {

        boolean dimension = true;
        if (MyArray.length != arraySize) {
            dimension = false;
        } else {
            for (int i = 0; i < MyArray.length; i++) {
                if (MyArray[i].length != arraySize) {
                    dimension = false;
                    break;
                }
            }
        }


        if (!dimension) {
            throw new MyArraySizeException("\n На вход подан массив неверной размерности. \n " +
                    "-->Для корректной работы программы необходим массив размерности: --> " + arraySize + "x" + arraySize);
        }

    }

    static void checkDataInArray(String[][] MyArray) throws MyArrayDataException {
        for (int i = 0; i < MyArray.length; i++) {
            for (int j = 0; j < MyArray[i].length; j++) {
                if (MyArray[i][j] == null || MyArray[i][j].isEmpty()) {
                    throw new MyArrayDataException("\n В ячейкe массива [" + i + "] [" + j + "] содержится не чиcловое значение.\n Пожалуйста исправьте для продолжения");
                } else {
                    for (int k = 0; k < MyArray[i][j].length(); k++) {
                        if (!Character.isDigit(MyArray[i][j].charAt(k))) {
                            throw new MyArrayDataException("\n В ячейкe массива [" + i + "] [" + j + "] содержится не чиcловое значение.\n Пожалуйста исправьте для продолжения");
                        }
                    }

                }
            }
        }
    }
}

