package edu.imu.mapreduce.mr;

import lombok.extern.slf4j.Slf4j;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class GoalsPointReduce extends Reducer<Text, IntWritable, Text, IntWritable> {
    public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException
    {
        int goalcount = 0;
        for(IntWritable value:values)
        {
            goalcount += value.get();
        }
        context.write(new Text(key + ","),new IntWritable(goalcount/10));
    }
}
