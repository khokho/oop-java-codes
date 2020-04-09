package seminar7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class main {

    public static void main(String[] args) {

        List<Integer> lst = new ArrayList<>();
        lst.add(5);
        System.out.println(lst);
        List<Integer> lstu = Collections.unmodifiableList(lst);
        System.out.println(lstu);
        lst.add(6);
        System.out.println(lstu);

    }
}
