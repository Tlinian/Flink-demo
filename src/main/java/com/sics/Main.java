package com.sics;

import com.sics.sink.SinkFactory;
import com.sics.source.ClickSource;
import com.sics.transform.FlatFuntion;
import com.sics.transform.MyKeySelector;
import com.sics.transform.PartitionerFunction;
import org.apache.flink.api.common.typeinfo.Types;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class Main {
    public static void main(String[] args) throws Exception {
        // 1. 创建流式执行环境
        StreamExecutionEnvironment env =
                StreamExecutionEnvironment.getExecutionEnvironment();

        DataStreamSource<Pojo> dataStreamSource = env.addSource(new ClickSource()).setParallelism(1);
        DataStream<Pojo> dataStream  = dataStreamSource.flatMap(
                new FlatFuntion()
        );
        dataStream.partitionCustom(new PartitionerFunction(), new MyKeySelector());
        dataStream.addSink(new SinkFactory()).setParallelism(10);
//        dataStream.print();
        env.execute();
    }
}
