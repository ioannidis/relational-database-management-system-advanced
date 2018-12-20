package db2.project.fall2018;

import java.time.format.DateTimeFormatter;
import java.util.*;

import db2.project.fall2018.model.AccidentInfo;
import db2.project.fall2018.model.VehicleInfo;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class Main {

    public static void main( String args[] ) {

        final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        final DateTimeFormatter yearFormatter = DateTimeFormatter.ofPattern("u");


        SparkConf conf = new SparkConf();
        conf.setAppName("Main").setMaster("local[*]");
        JavaSparkContext jsc = new JavaSparkContext(conf);

        // TODO: paths must change to relative
        JavaRDD<String> accidentCSV = jsc.textFile("/home/panos/Downloads/SELECT___from_db2_public_accident_inform.csv",4);
        JavaRDD<String> vehicleCSV = jsc.textFile("/home/panos/Downloads/db2_data/db2_Vehicle_Information.csv", 4);

        // Create accidents RDD structure using the data of the csv file
        JavaRDD<AccidentInfo> accidentInfoRDD = accidentCSV.map(x -> {

            String[] accidentData = x.split(",");

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

        // Total number of accidents
        long totalNumOfAccidents = accidentInfoRDD.count();

        // Percentage of accidents in Scotland
        float accidentsInScotland = accidentInfoRDD
                .filter( x -> x.getInScotland().equalsIgnoreCase( "Yes" ) )
                .count();
        System.out.println( "The is percentage of the accidents in Scotland is: " + accidentsInScotland / totalNumOfAccidents * 100 + "%" );

        float accidents2015 = accidentInfoRDD
                .filter( x -> x.getYear().equals("2015"))
                .count();
        System.out.println( "The is percentage of the accidents in 2015 was: " + accidents2015 / totalNumOfAccidents * 100 + "%" );

        // Print the number of the accidents per year
        Map<String, Iterable<AccidentInfo>> accidentsPerYearSorted = new TreeMap<>( Comparator.naturalOrder() );

        accidentsPerYearSorted.putAll( accidentInfoRDD
                .groupBy( x -> x.getYear() )
                .collectAsMap()
        );

        System.out.println( "The number of the accidents per year are: " );
        accidentsPerYearSorted.forEach( (x, y) -> System.out.println( x + ": " + ( ( Collection<?>)y ).size() ) );


        // Create vehicle RDD structure using the data of the csv file
        JavaRDD<VehicleInfo> vehicleInfoRDD = vehicleCSV.map(x -> {

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

        System.out.println(vehicleInfoRDD.count());


    }
}
