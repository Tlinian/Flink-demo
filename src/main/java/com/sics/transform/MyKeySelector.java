package com.sics.transform;


import com.sics.Pojo;
import org.apache.flink.api.java.functions.KeySelector;
import scala.Int;

public class MyKeySelector implements KeySelector<Pojo, Integer> {

    @Override
    public Integer getKey(Pojo value) throws Exception {
        return value.getId();
    }
}
