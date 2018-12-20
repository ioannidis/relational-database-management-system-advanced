package db2.project.fall2018.structure;

import db2.project.fall2018.model.VehicleInfo;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class VehicleInfoRDD {

    private static JavaSparkContext config;

    private static VehicleInfoRDD instance = null;

    private JavaRDD<VehicleInfo> vehicleInfoJavaRDD;


    private VehicleInfoRDD() {
        JavaRDD<String> vehicleCSV = config.textFile("/home/panos/Downloads/db2_data/db2_Vehicle_Information.csv", 4);

        generateVehicleInfoJavaRDD(vehicleCSV);
    }

    public static void setConfig(JavaSparkContext jsc) {
        config = jsc;
    }

    public static VehicleInfoRDD getInstance() {
        if (instance == null)
            instance = new VehicleInfoRDD();

        return instance;
    }


    public JavaRDD<VehicleInfo> getVehicleInfoJavaRDD() {
        return vehicleInfoJavaRDD;
    }

    private void generateVehicleInfoJavaRDD(JavaRDD<String> vehicleCSV) {
        vehicleInfoJavaRDD = vehicleCSV.map(x -> {

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
}
