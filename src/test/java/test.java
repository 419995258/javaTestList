import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class test {

    public Integer get(Integer[] array,Integer lo,Integer hi){
        Integer i = array[lo];
        if(lo < hi){
            while (i<=array[hi]){
                hi = hi - 1;
            }
            array[lo] = array[hi];
            while (i>array[lo]){
                lo = lo + 1;
            }
            array[hi] = array[lo];

        }
        array[hi] = i;

        return null;
    }

    public void sort(Integer[] array,Integer lo,Integer hi){
        if(lo >= hi){
            return;
        }

    }


    public static void main(String[] args){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        long whichDay1 = cal.get(Calendar.DAY_OF_YEAR);
        System.out.println(whichDay1);

        System.out.println(UUID.randomUUID().toString());

        String a = new String("1");
        String b = new String("1");
        System.out.println(a == b);

        Integer i = 0;

        Integer aa = i++;
        System.out.println(aa);
        Integer bb = ++i;
        System.out.println(bb);

        System.out.println("1".hashCode());

        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();

    }


}
