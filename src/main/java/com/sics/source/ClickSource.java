package com.sics.source;

import com.sics.Pojo;
import org.apache.flink.streaming.api.functions.source.RichSourceFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class ClickSource extends RichSourceFunction<Pojo> {
    Logger logger = LoggerFactory.getLogger(RichSourceFunction.class);
    private volatile Boolean running = true;
    int i = 0;
    @Override
    public void run(SourceContext<Pojo> ctx) throws Exception {

        while (running&&i<10){
            i++;
            System.out.println(i);
            ctx.collect(new Pojo(i,new Date(),1));
        }
    }

    @Override
    public void cancel() {
        logger.info("i value if {}",i);
        running = false;
    }
}
