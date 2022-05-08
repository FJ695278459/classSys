package cn.onehand.acss.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class MD5Utils {

    /**
     * MD5加密工具类
     * @param data 要加密的字符串
     * @return 加密后的字符串
     */
    public static String getMD5String(String data) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest(data.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte item : array) {
                sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString().toUpperCase();
        } catch (Exception exception) {
        }
        return null;
    }
}
