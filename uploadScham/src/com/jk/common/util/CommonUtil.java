package com.jk.common.util;


import java.security.MessageDigest;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

/**
 * java常用工具�?
 * @ClassName CommonUtil
 * @author 86159
 * @date 2022�?7�?24�? 下午4:45:20
 */
public class CommonUtil
{

    /**
     * 获取随机长度的串
     * @param length
     * @return
     */
    private static final String ALL_CHAR_NUM = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    public static String getStringNumRandom(int length) {
        //生成随机数字和字�?,
        Random random = new Random();
        StringBuilder saltString = new StringBuilder(length);
        for (int i = 1; i <= length; ++i) {
            saltString.append(ALL_CHAR_NUM.charAt(random.nextInt(ALL_CHAR_NUM.length())));
        }
        return saltString.toString();
    }
    
    /**
     * 生成uuid
     * @return
     */
    public static String generateUUID()
    {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
    }

    /**
     * MD5加密
     * @param data
     * @return
     */
    public static String MD5(String data)
    {
        try
        {
            java.security.MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest(data.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for (byte item : array)
            {
                sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
            }

            return sb.toString().toUpperCase();
        }
        catch (Exception exception)
        {
        }
        return null;

    }

    /**
     * 返回map中所有value字符�?
     * @param map
     * @return
     */
    public static String printMap(Map map)
    {
        String mapStr = "{";
        Set<String> keySet = map.keySet();
        Iterator<String> iterator = keySet.iterator();
        while (iterator.hasNext())
        {
            mapStr += map.get(iterator.next()) + ",";
        }
        return mapStr + "}";
    }
}
