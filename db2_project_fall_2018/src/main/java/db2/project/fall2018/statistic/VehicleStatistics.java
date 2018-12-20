package db2.project.fall2018.statistic;

import db2.project.fall2018.model.AccidentInfo;
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

}
