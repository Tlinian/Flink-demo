package com.sics.transform;

import com.sics.Pojo;
import org.apache.flink.api.common.functions.Partitioner;

public class PartitionerFunction implements Partitioner<Integer> {
    @Override
    public int partition(Integer key, int numPartitions) {
        return key%numPartitions;
    }
}
