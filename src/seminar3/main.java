package seminar3;

import java.util.Arrays;
import java.util.Random;

public class main {
    private static class wow implements  Comparable<wow>{
        int a,b;
        public wow(int a,int b){
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return "wow{" +
                    "a=" + a +
                    ", b=" + b +
                    '}';
        }

        @Override
        public int compareTo(wow wow) {
            return this.a-wow.a;
        }
    }

    public static void main(String[] args) {


        int[] a = new int[]{10,12};
        int[] b;

        b=a.clone();
        b[0]=15;
        System.out.println(b[0]);
        System.out.println(b[1]);
        System.out.println(a[0]);

        StringBuilder[] x = new StringBuilder[2];
        StringBuilder[] y = new StringBuilder[2];
        x[0]=new StringBuilder("aa");
        x[1]=new StringBuilder("bb");

        y=x.clone();
        for(var cur:y){
            cur=new StringBuilder(cur);
        }

        y[0].append(100);
        System.out.println(x[0]);
        System.out.println(y[0]);

        wow[] arr = new wow[10];
        Random rgen = new Random();
        for(int i=0; i<arr.length; i++){
            arr[i]=new wow(rgen.nextInt(10),rgen.nextInt(10));
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }





    }

}
