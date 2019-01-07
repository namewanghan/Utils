package com.wh.utilsapp.utils;

import android.util.Log;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class LogUtils {

    public static String TAG="SUCCESS ++";

    public static void showTestLog(String str) {
        Log.i(TAG, str);
    }

    public static void showArr(String [] arr){
        StringBuilder sb=new StringBuilder();
        for(String s : arr) {
            sb.append(s).append("\t");
        }
        Log.i(TAG,sb.toString());
    }

    //打印list
    public static void showObjectList(List<Object> list) {
        StringBuilder sb=new StringBuilder();
        for( int i = 0 ; i < list.size() ; i++) {
            sb.append(list.get(i)).append("\t");
        }
        Log.i(TAG,sb.toString());
    }

    //打印list
    public static void showObjectMap(Map<Object,Object> map) {
        StringBuilder sb=new StringBuilder();
        Set<Map.Entry<Object,Object>>set=map.entrySet();
        for (Map.Entry<Object,Object>me:set){
            String key=me.getKey()+"";
            String value=me.getValue()+"";
            sb.append(key).append("---").append(value).append("\t");
        }
        Log.i(TAG,sb.toString());
    }

    public static void showFormatJson(String jsonStr){
        Log.i(TAG,formatJson(jsonStr));
    }

    //格式化的json
    public static String formatJson(String jsonStr) {
        if (null == jsonStr || "".equals(jsonStr)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        char last;
        char current = '\0';//char 可以 switch
        int indent = 0;
        boolean isInQuotationMarks = false;
        for (int i = 0; i < jsonStr.length(); i++) {
            last = current;
            current = jsonStr.charAt(i);
            switch (current) {
                case '"':
                    if (last != '\\') {
                        isInQuotationMarks = !isInQuotationMarks;
                    }
                    sb.append(current);
                    break;
                case '{':
                case '[':
                    sb.append(current);
                    if (!isInQuotationMarks) {
                        sb.append('\n');
                        indent++;
                        addIndentBlank(sb, indent);
                    }
                    break;
                case '}':
                case ']':
                    if (!isInQuotationMarks) {
                        sb.append('\n');
                        indent--;
                        addIndentBlank(sb, indent);
                    }
                    sb.append(current);
                    break;
                case ',':
                    sb.append(current);
                    if (last != '\\' && !isInQuotationMarks) {
                        sb.append('\n');
                        addIndentBlank(sb, indent);
                    }
                    break;
                default:
                    sb.append(current);
            }
        }
        return sb.toString();
    }

    /**
     * 添加space
     * @param sb
     * @param indent
     */
    private static void addIndentBlank(StringBuilder sb, int indent) {
        for (int i = 0; i < indent; i++) {
            sb.append('\t');
        }
    }
}
