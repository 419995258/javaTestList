package xdf;

import java.util.zip.CRC32;

public class testCrc {
    public static void main(String[] args) {
        // 分表处理
        String value = "BJ0820201689";
        CRC32 crc32 = new CRC32();
        crc32.update(value.getBytes());
        String s = String.valueOf(crc32.getValue() % 128);
        System.out.println(s);
    }

}
