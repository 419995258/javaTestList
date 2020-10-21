package test;

import java.util.zip.CRC32;

public class testCrc {
    public static void main(String[] args) {
        String value = "71033FCAFCB6405D929A56F0863310B5";
        CRC32 crc32 = new CRC32();
        crc32.update(value.getBytes());
        String s = String.valueOf(crc32.getValue() % 128);
        System.out.println(s);
    }

}
