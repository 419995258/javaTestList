import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class test2 {
    public static void main(String[] args){

        int n = 7;
        System.out.println(n++);
        int a = "a".charAt(0);
        System.out.println(a > 'a');
        System.out.println(a <'a');
        System.out.println(a =='a');
        System.out.println(a);
        System.out.println("a".charAt(0));
        System.out.println(Integer.valueOf("b".charAt(0)));


        List<Integer> list = new ArrayList<>();
        Integer i = 2;
        list.add(1);
        list.add(1);
        while (i <= 20){
            Integer aa = list.get(i-1) + list.get(i-1-1);
            System.out.println(aa);
            list.add(aa);
            i = i + 1;
        }

    }

}
