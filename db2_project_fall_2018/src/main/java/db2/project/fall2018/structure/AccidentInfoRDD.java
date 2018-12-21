package db2.project.fall2018.structure;

import db2.project.fall2018.model.AccidentInfo;
import org.apache.spark.HashPartitioner;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class AccidentInfoRDD {

    private static JavaSparkContext config;

    private static AccidentInfoRDD instance = null;

    private JavaRDD<String> accidentCSV;

    private JavaRDD<AccidentInfo> javaRDD = null;

    private JavaPairRDD<Integer, Iterable<AccidentInfo>> javaPairRDD = null;


    private AccidentInfoRDD() {
        accidentCSV = config.textFile( "/home/panos/Downloads/SELECT___from_db2_public_accident_inform.csv",4 );
    }

    public static void setConfig( JavaSparkContext jsc ) {
        config = jsc;
    }

    public static AccidentInfoRDD getInstance() {
        if ( instance == null )
            instance = new AccidentInfoRDD();

        return instance;
    }

    // Returns java rdd structure
    public JavaRDD<AccidentInfo> getJavaRDD() {
        if ( javaRDD == null ) {
            javaRDD = accidentCSV.map( x -> {

                String[] accidentData = x.split( "," );

                return new AccidentInfo(
                        Integer.parseInt( accidentData[0] ),
                        accidentData[1],
                        accidentData[2],
                        accidentData[3],
                        accidentData[4],
                        accidentData[5],
                        accidentData[6],
                        accidentData[7],
                        accidentData[8]
                );

            });
        }

        return javaRDD;
    }

    // Returns java pair rdd structure
    public JavaPairRDD<Integer, Iterable<AccidentInfo>> getJavaPairRDD() {
        if ( javaPairRDD == null )
            javaPairRDD = javaRDD.groupBy( x -> x.getId() );

        return javaPairRDD;
    }

    // Returns partitioned java pair rdd structure
    public JavaPairRDD<Integer, Iterable<AccidentInfo>> getJavaPairRDDPartitionedBy( int num ) {
        if ( javaPairRDD == null )
            getJavaPairRDD();

        return javaPairRDD.partitionBy( new HashPartitioner( num ) );
    }

}
