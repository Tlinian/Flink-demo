package com.sics.sink;

import com.sics.Pojo;
import org.apache.flink.streaming.api.functions.sink.RichSinkFunction;
import org.apache.flink.streaming.api.functions.source.RichSourceFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SinkFactory extends RichSinkFunction<Pojo> {
    Logger logger = LoggerFactory.getLogger(RichSourceFunction.class);
    @Override
    public void invoke(Pojo value, Context context) throws Exception {
        Pojo pojo = null;
        if(value instanceof Pojo){
            pojo = (Pojo) value;
        }else {
            throw new Exception("flat is null");
        }
        System.out.println(pojo.toString()+"  "+getRuntimeContext().getTaskNameWithSubtasks());
        logger.info(pojo.toString());
        super.invoke(pojo, context);
    }
}
