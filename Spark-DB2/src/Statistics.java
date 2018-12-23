import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import scala.Tuple2;

public class Statistics {
	
	public static <K, V> void printMap(Map<K, V> map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.println("Key : " + entry.getKey() 
				+ " Value : " + entry.getValue());
        }
    }
	public static void main(String[] args) {
		// Spark Initialization
		SparkConf conf = new SparkConf();
		conf.setAppName("JavaStatusAPIDemo").setMaster("local[*]");
		JavaSparkContext jsc = new JavaSparkContext(conf);
		
		jsc.setLogLevel("WARN");
		// Spark Initialization End
		
		//Import csv file with 4 core processor power
		JavaRDD<String> accidents = jsc.textFile("/Users/Dennis/Downloads/db2_Accident_Information.csv",4);
		JavaRDD<String> vehicles = jsc.textFile("/Users/Dennis/Downloads/db2_Vehicle_Information.csv",4);
		
		
		/*
		 /Statistic for how many car makes are involved in the accidents
		 */
		JavaPairRDD<String, String> car_make = vehicles.mapToPair(s -> {
			String[] foo= s.split(",");
			
			return new Tuple2<>(foo[4], s);
		});
		/*
		 /END
		 */
		
		
		/*
		 /Statistic for how many accidents happened per year
		 */
		JavaPairRDD<Integer, String> accident_year = accidents.mapToPair(s -> {
			String[] foo= s.split(",");
			
			return new Tuple2<>(Integer.parseInt(foo[7]), foo[1].toString());
		});
		/*
		 /END
		 */
		
		
		
		
		
		
		//FINAL DATA
		
			//MAKE DATA
			int makes_counts = (car_make.countByKey().size()-1); //-1 because the first line is the line with the column decleration
			//END
			
			/*
			 * //TODO FIND A WAY TO SORT THE TREE MAP/RESULTS BASED ON THE KEY=YEAR
			 *
			 * Map<Integer, Long> accidents_per_year = new TreeMap<Integer,Long>(accident_year.countByKey());
			  
			   System.out.println(accidents_per_year.containsKey("Year"));
			   Map<Integer, Long> sorted_years = new TreeMap<Integer, Long>(accidents_per_year);
			 */
		//END
		
		
		System.out.println("~~~~~~~~~~~~~ Statistics ~~~~~~~~~~~~");
		System.out.println("How many car makes were involved in the accident: ");
		System.out.println(car_make.countByKey().size()-1);
		System.out.println("How many accidents happened per year: ");
		//NOT YET SORTED BUT RIGHT RESULTS
	//	System.out.println(sorted_years);
		jsc.close();
		}
}
