package com.sics.transform;

import com.sics.Pojo;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.util.Collector;

public class FlatFuntion implements FlatMapFunction<Pojo,Pojo> {

    @Override
    public void flatMap(Pojo value, Collector out) throws Exception {
        Pojo pojo = null;
        if(value instanceof Pojo){
            pojo = (Pojo) value;
        }else {
            throw new Exception("flat is null");
        }
        pojo.addFunctionNum();
        out.collect(pojo);
    }
}
