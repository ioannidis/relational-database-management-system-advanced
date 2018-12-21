package db2.project.fall2018;

import java.time.format.DateTimeFormatter;
import java.util.*;

import db2.project.fall2018.model.AccidentInfo;
import db2.project.fall2018.model.VehicleInfo;
import db2.project.fall2018.statistic.AccidentStatistics;
import db2.project.fall2018.statistic.VehicleStatistics;
import db2.project.fall2018.structure.AccidentInfoRDD;
import db2.project.fall2018.structure.VehicleInfoRDD;
import org.apache.spark.HashPartitioner;
import org.apache.spark.Partitioner;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class Main {

    public static void main( String args[] ) {

//        final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        final DateTimeFormatter yearFormatter = DateTimeFormatter.ofPattern("u");


        SparkConf conf = new SparkConf();
        conf.setAppName("Main").setMaster("local[*]");
        JavaSparkContext jsc = new JavaSparkContext(conf);


        /*
        * Accident info config
        * */
        AccidentInfoRDD.setConfig( jsc );
        // Generate an instance of accident info data
        AccidentInfoRDD accidentInfoRDDInstance = AccidentInfoRDD.getInstance();
        // Get JavaRDD structure populated with accident info
        JavaRDD<AccidentInfo> accidentInfoRDD   = accidentInfoRDDInstance.getJavaRDD();
        // Accident statistics obj
        AccidentStatistics accidentStatistics = new AccidentStatistics( accidentInfoRDD );


        /*
        * Vehicle info config
        * */
//        VehicleInfoRDD.setConfig( jsc );
        // Generate an instance of vehicle info data
//        VehicleInfoRDD vehicleInfoRDDInstance   = VehicleInfoRDD.getInstance();
        // Get JavaRDD structure populated with vehicle info
//        JavaRDD<VehicleInfo> vehicleInfoRDD     = vehicleInfoRDDInstance.getVehicleInfoJavaRDD();
        // Vehicle statistics obj
//        VehicleStatistics vehicleStatistics = new VehicleStatistics( vehicleInfoRDD );

        /*
        * Accident statistics
        * */
        // Total number of accidents
        //accidentStatistics.totalNumOfAccidents();

        // Percentage of accidents in Scotland
        //accidentStatistics.accidentsInScotland();

        // Number of accidents in 2015
        //accidentStatistics.accidentsIn( "2015" );

        // Print the number of the accidents per year
        //accidentStatistics.accidentPerYearSorted();

        // Exercise 2.b
        // Print the number of the accidents per road class
        //accidentStatistics.accidentsPerRoadClass();

        // Exercise 2.c
        JavaPairRDD<Integer, Iterable<AccidentInfo>> accidentJavaPairRDD = accidentInfoRDDInstance.getJavaPairRDDPartitionedBy( 20 );
        accidentStatistics.accidentsPerRoadUsingPartitions( accidentJavaPairRDD );

        /*
        * Vehicle statistics
        * */
        //System.out.println(vehicleInfoRDD.count());

        // Print the number of the makes
        //vehicleStatistics.numberOfMakes();

        // Prints the percentage of male and female drivers
        //vehicleStatistics.sexOfTheDriver();


    }

}
