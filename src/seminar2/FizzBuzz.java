package seminar2;

public class FizzBuzz {

    public static String evaluate(int i){
        String res="";
        if(i%3==0)
            res += "Fizz";
        if(i%5==0)
            res += "Buzz";
        if(res.equals(""))
            return ""+i;
        else
            return res;
    }

}
