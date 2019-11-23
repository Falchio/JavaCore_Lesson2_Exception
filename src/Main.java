public class Main {

    static int arraySize = 4;

    public static void main(String[] args){

        String[][] MyArray = {{"1","2","3","4"},
                                {"1","2","3","4"},
                                {"1","2","3","4"},
                                {"1","2","3","4"}};
        int sum = 0;
        sum=summArray(MyArray);
        System.out.println(sum);
    }

    static  int summArray(String[][] MyArray){
        int sum=0;

        for (int i   = 0; i < arraySize; i++){
            for (int j = 0; j < arraySize; j++){
                sum = sum + Integer.parseInt(MyArray[i][j]) ;
            }
        }

        return sum;
    }
}

