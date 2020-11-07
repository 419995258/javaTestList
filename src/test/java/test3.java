import org.apache.commons.codec.digest.DigestUtils;

import java.util.ArrayList;
import java.util.List;

public class test3 {
    public static void main(String[] args){

        Long start = System.currentTimeMillis();
        String hash="39";
        String txt ="39";

        // MD2
        Integer i1 = 10000000;
        Integer i2 = 50000000;
        for(int i=0;i<100000000;i++){
            ///   public static byte[] md2(String data) {
            //        return md2(StringUtils.getBytesUtf8(data));
            //    }
            hash = DigestUtils.md2Hex(hash);
        }

        System.out.println(hash);
        Long end = System.currentTimeMillis();
        System.out.println((end-start) / 1000 + "s");
    }

}
