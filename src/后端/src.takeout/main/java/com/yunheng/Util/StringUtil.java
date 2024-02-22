package com.yunheng.Util;
//字符串工具类  判断是否为空
public class StringUtil {
    public static boolean isEmpty(String str){
        if (str==null||"".equals(str.trim())){
            return true;
        }
        return false;
    }
}
