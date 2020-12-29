import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
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
        String[] str = "1-story".split("-");
        System.out.println("");
    }


}
