import exceptions.MyArraySizeException;

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
        } catch (MyArraySizeException e) {
            e.printStackTrace();

        }
        System.out.println("Результат сложения всех элементов массива: " + sum);

    }

    static int sumArray(String[][] MyArray) throws MyArraySizeException {
        int sum = 0;
        boolean dimension = true;

        checkDimensionArray(MyArray);

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
            throw new MyArraySizeException("На вход подан массив неверной размерности. \n " +
                    "-->Для корректной работы программы необходим массив размерности: --> " + arraySize + "x" + arraySize);
        }

    }
}

