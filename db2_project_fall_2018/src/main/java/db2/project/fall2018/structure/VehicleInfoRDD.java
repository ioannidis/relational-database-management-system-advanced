package db2.project.fall2018.structure;

import db2.project.fall2018.model.VehicleInfo;
import org.apache.spark.HashPartitioner;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class VehicleInfoRDD {

    private static JavaSparkContext config;

    private static VehicleInfoRDD instance = null;

    private JavaRDD<String> vehicleCSV;

    private JavaRDD<VehicleInfo> javaRDD = null;

    private JavaPairRDD<Integer, Iterable<VehicleInfo>> javaPairRDD = null;


    private VehicleInfoRDD( ) {
        vehicleCSV = config.textFile("/home/panos/Projects/BD2/db2_project_fall_2018/src/main/java/db2/project/fall2018/csv/db2_Vehicle_Information.csv", 4);
    }

    private VehicleInfoRDD( String absolutePathOfCSV ) {
        vehicleCSV = config.textFile( absolutePathOfCSV, 4 );
    }

    public static void setConfig( JavaSparkContext jsc ) {
        config = jsc;
    }

    public static VehicleInfoRDD getInstance() {
        if (instance == null)
            instance = new VehicleInfoRDD();

        return instance;
    }

    // Returns java rdd structure
    public JavaRDD<VehicleInfo> getJavaRDD() {
        if ( javaRDD == null ) {
            javaRDD = vehicleCSV.map(x -> {

                String[] vehicleData = x.split(",");

                return new VehicleInfo(
                        Integer.parseInt( vehicleData[0] ),
                        vehicleData[1],
                        vehicleData[2],
                        Float.parseFloat( vehicleData[3].isEmpty() ? "1.0" : vehicleData[3] ),
                        vehicleData[4],
                        vehicleData[5],
                        vehicleData[6],
                        vehicleData[7]
                );

            });
        }

        return javaRDD;
    }

    // Returns java pair rdd structure
    public JavaPairRDD<Integer, Iterable<VehicleInfo>> getJavaPairRDD() {
        if ( javaPairRDD == null )
            javaPairRDD = javaRDD.groupBy( x -> x.getId() );

        return javaPairRDD;
    }

    // Returns partitioned java pair rdd structure
    public JavaPairRDD<Integer, Iterable<VehicleInfo>> getJavaPairRDDPartitionedBy( int num ) {
        if ( javaPairRDD == null )
            getJavaPairRDD();

        return javaPairRDD.partitionBy( new HashPartitioner( num ) );
    }






}
