package exceptions;

public class MyArrayDataException extends NumberFormatException {
    int x;
    int y;

    public MyArrayDataException(String s, int x, int y){
        super(s);
        this.x=x;
        this.y=y;
    }

    public MyArrayDataException(String s){
        super(s);
    }
}

