package db2.project.fall2018.statistic;

import db2.project.fall2018.model.AccidentInfo;
import db2.project.fall2018.model.VehicleInfo;
import db2.project.fall2018.structure.VehicleInfoRDD;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import scala.Tuple2;

import java.util.*;

public class VehicleStatistics {

    private VehicleInfoRDD instance;

    // Total number of vehicles
    private long totalNumOfVehicles;

    public VehicleStatistics( VehicleInfoRDD instance  ) {
        this.instance = instance;
        totalNumOfVehicles = instance.getJavaRDD().count();
    }

    // Print the total number of accidents
    public void totalNumOfVehicles() {
        System.out.println( totalNumOfVehicles );
    }

    // Print the number of the makes
    public void numberOfMakes() {
        long numberOfMakes = instance.getJavaRDD()
                .map(x -> x.getMake())
                .distinct()
                .count();

        System.out.println( "The number of the makes is: " + numberOfMakes);
    }

    // Print sex of the driver percentage
    public void sexOfTheDriver() {
        float men = instance.getJavaRDD()
                .filter( x-> x.getSexOfDriver().equalsIgnoreCase( "male" ) )
                .count();

        float women = instance.getJavaRDD()
                .filter( x-> x.getSexOfDriver().equalsIgnoreCase( "female" ) )
                .count();


        System.out.println( "The percentage of the male drivers is: " + men / totalNumOfVehicles * 100 + "%");
        System.out.println( "The percentage of the female drivers is: " + women / totalNumOfVehicles * 100 + "%");
    }

    // Prints the age percentage for drivers between 26 - 35
    public void ageBandBetween26And35() {
        float count = instance.getJavaRDD()
                .filter( x -> x.getAgeBandOfDriver().equals( "26 - 35" ) )
                .count();

        System.out.println( "The percentage of the age band 26 - 35 is: " + count / totalNumOfVehicles * 100 + "%" );
    }

    public void vehicleTypePercentage( String type ) {
         List<Tuple2<String, Iterable<Tuple2<Integer, Iterable<VehicleInfo>>>>> a = instance.getJavaPairRDDPartitionedBy( 20 )
                .groupBy( x -> x._2.iterator().next().getVehicleType() )
                .filter( x -> x._1.equalsIgnoreCase( type ) )
                .collect();

        a.forEach( x-> System.out.println( "The percentage of accidents caused by " + x._1 + " is: " + ( (Collection<?>)x._2 ).size() / (float)totalNumOfVehicles * 100 + "%" ) );
    }
}





































