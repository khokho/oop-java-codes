package seminar4;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Visa A = new Visa(100);

        Mastercard B = new Mastercard(200);
        Amex C = new Amex(120);
        Card D = new Card(120) {
            @Override
            public void tax() {

            }
        };
        List<Card> ls = new ArrayList<>();
        ls.add(C);
        ls.add(D);
        ls.add(A);
        for(Card t:ls){
            t.endMonth();
        }
/* es chemi kitxva
        Set<Integer> st = Collections.emptySet();// Set.of(2,3);
        st.contains(null);
        st = new HashSet<>();
        st.contains(null);
*/
        A.deposit(20);
        A.withdraw(15);

        A.endMonth();
        B.endMonth();
        C.endMonth();
        D.endMonth();


    }

}
