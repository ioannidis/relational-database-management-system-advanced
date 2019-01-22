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

        SparkConf conf = new SparkConf();
        conf.setMaster("local[*]").setAppName("Main");
        JavaSparkContext jsc = new JavaSparkContext(conf);

        /*
        * Accident info config
        * */
        AccidentInfoRDD.setConfig( jsc );
        // Generate an instance of accident info data
        AccidentInfoRDD accidentInfoRDDInstance = AccidentInfoRDD.getInstance();
        // Accident statistics obj
        AccidentStatistics accidentStatistics = new AccidentStatistics( accidentInfoRDDInstance );


        /*
        * Vehicle info config
        * */
        VehicleInfoRDD.setConfig( jsc );
        // Generate an instance of vehicle info data
        VehicleInfoRDD vehicleInfoRDDInstance   = VehicleInfoRDD.getInstance();
        // Vehicle statistics obj
        VehicleStatistics vehicleStatistics = new VehicleStatistics( vehicleInfoRDDInstance );

        /*
        * Accident statistics
        * */
        // Total number of accidents
//        accidentStatistics.totalNumOfAccidents();

        // Percentage of accidents in Scotland
//        accidentStatistics.accidentsInScotland();

        // Number of accidents in 2015
//        accidentStatistics.accidentsIn( "2015" );

        // Print the number of the accidents per year
//        accidentStatistics.accidentPerYearSorted();

        // Exercise 2.b
        // Print the number of the accidents per road class
//        accidentStatistics.accidentsPerRoadClass();

        // Exercise 2.c
//        accidentStatistics.accidentsPerRoadUsingPartitions( 20 );

        /*
        * Vehicle statistics
        * */
        // Prints the total numbwer of vehicles
//        vehicleStatistics.totalNumOfVehicles();

        // Prints the number of the makes
//        vehicleStatistics.numberOfMakes();

        // Prints the percentage of male and female drivers
//        vehicleStatistics.sexOfTheDriver();

        // Prints the age percentage for drivers between 26 - 35
//        vehicleStatistics.ageBandBetween26And35();

        // Prints accidents percentage caused by tram
//        vehicleStatistics.vehicleTypePercentage( "Tram" );

        // Prints accidents percentage caused by Motorcycle over 500cc
        vehicleStatistics.vehicleTypePercentage( "Motorcycle over 500cc" );

    }

}
