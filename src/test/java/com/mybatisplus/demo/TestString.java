package com.mybatisplus.demo;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestString {
    @Test
    public void test(){


        StringBuffer stringBuffer=new StringBuffer();
        String totalString=stringBuffer.toString();
        int index=totalString.indexOf("、");
        String foodName=totalString.substring(0,index+1);
        String string1="香蕉、玉米、面粉";
        String string2="香蕉、玉米、面粉";
        String string3="牛奶、鸡蛋";
//        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append(string1).append("、").append(string2).append("、").append(string3).append("、");
//        String totalString=stringBuffer.toString();
        System.out.println("组拼后的字符串为:"+totalString);

        while (totalString.length()>0) {
            //得到第一个字符串比如"香蕉、"
            int index1=totalString.indexOf("、");

            System.out.println(foodName);
            Pattern pattern = Pattern.compile(foodName);
            Matcher matcher = pattern.matcher(totalString);
            int count=0;
            while(matcher.find()){
                count++;
            }
            totalString= totalString.replaceAll(foodName, "");
            System.out.println("食品名字为:"+foodName+",出现次数为:"+count);
            System.out.println("统计删除后字符串为:totalString="+totalString);
            System.out.println("===============================");
        }
    }
}
