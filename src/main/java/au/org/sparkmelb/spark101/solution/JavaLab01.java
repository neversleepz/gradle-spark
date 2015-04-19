package au.org.sparkmelb.spark101.solution;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import java.util.Arrays;

/**
 * Example program in Java to demonstrate
 * - Use of textFile to read raw text =
 * - Use of JavaRDD
 * - Use of FlatMap
 *
 */
public class JavaLab01 {

    public static void main(String[] argsc) {

        // Setup Spark Configuration
        SparkConf sparkConf = new SparkConf().setAppName("IntelliJLab01").setMaster("local[1]");

        // Define Java Spark Context
        JavaSparkContext ctx = new JavaSparkContext(sparkConf);

        // Perform the read. Filename specified in-line
        JavaRDD<String> lines = ctx.textFile("./data/people.json", 1);

        // Lets do something different, do a word count
        JavaRDD<String> words = lines.flatMap(
                new FlatMapFunction<String, String>() {
                    @Override
                    public Iterable<String> call(String s) {
                        return Arrays.asList(s.split(" "));
                    }
                }
        );

        // Display results
        System.out.println("Read " + lines.count() + " row(s) with " + words.count() + " words" );

        ctx.stop();

    }
}

