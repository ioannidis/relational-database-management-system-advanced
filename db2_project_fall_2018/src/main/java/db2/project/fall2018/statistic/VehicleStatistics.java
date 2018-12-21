package db2.project.fall2018.statistic;

import db2.project.fall2018.model.VehicleInfo;
import org.apache.spark.api.java.JavaRDD;

public class VehicleStatistics {

    private JavaRDD<VehicleInfo> vehicleInfoRDD;

    // Total number of vehicles
    private long totalNumOfVehicles;

    public VehicleStatistics( JavaRDD<VehicleInfo> vehicleInfoRDD  ) {
        this.vehicleInfoRDD = vehicleInfoRDD;
        totalNumOfVehicles = this.vehicleInfoRDD.count();
    }

    // Print the number of the makes
    public void numberOfMakes() {
        long numberOfMakes = vehicleInfoRDD
                .map(x -> x.getMake())
                .distinct()
                .count();

        System.out.println( "The number of the makes is: " + numberOfMakes);
    }

    // Print sex of the driver percentage
    public void sexOfTheDriver() {
        float men = vehicleInfoRDD
                .filter( x-> x.getSexOfDriver().equalsIgnoreCase( "male" ) )
                .count();

        float women = vehicleInfoRDD
                .filter( x-> x.getSexOfDriver().equalsIgnoreCase( "female" ) )
                .count();


        System.out.println( "The percentage of the male drivers is: " + men / totalNumOfVehicles * 100 + "%");
        System.out.println( "The percentage of the female drivers is: " + women / totalNumOfVehicles * 100 + "%");
    }

}
