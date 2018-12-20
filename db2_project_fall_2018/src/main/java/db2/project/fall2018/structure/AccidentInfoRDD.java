package db2.project.fall2018.structure;

import db2.project.fall2018.model.AccidentInfo;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class AccidentInfoRDD {

    private static JavaSparkContext config;

    private static AccidentInfoRDD instance = null;

    private JavaRDD<AccidentInfo> accidentInfoRDD;


    private AccidentInfoRDD() {
        JavaRDD<String> accidentCSV = config.textFile("/home/panos/Downloads/SELECT___from_db2_public_accident_inform.csv", 4);

        generateVehicleInfoJavaRDD(accidentCSV);
    }

    public static void setConfig(JavaSparkContext jsc) {
        config = jsc;
    }

    public static AccidentInfoRDD getInstance() {
        if (instance == null)
            instance = new AccidentInfoRDD();

        return instance;
    }


    public JavaRDD<AccidentInfo> getAccidentInfoJavaRDD() {
        return accidentInfoRDD;
    }

    private void generateVehicleInfoJavaRDD(JavaRDD<String> accidentCSV) {
        accidentInfoRDD = accidentCSV.map(x -> {

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
    }
}
