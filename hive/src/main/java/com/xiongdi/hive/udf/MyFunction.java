package com.xiongdi.hive.udf;
import org.apache.hadoop.hive.ql.exec.UDF;
public class MyFunction extends UDF{
    public String evaluate(String name){
        return name + "hahaha!";
    }
}
