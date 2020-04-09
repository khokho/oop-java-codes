package seminar5;

public class Number extends Node {
    Integer num;

    public Number(Integer x){
        num = x;
        left=right=null;
    }

    @Override
    Integer evaluate() {
        return num;
    }
}
