package db2.project.fall2018.statistic;

import db2.project.fall2018.model.AccidentInfo;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class AccidentStatistics {

    private JavaRDD<AccidentInfo> accidentInfoRDD;

    // Total number of accidents
    private long totalNumOfAccidents;

    public AccidentStatistics( JavaRDD<AccidentInfo> accidentInfoRDD  ) {
        this.accidentInfoRDD = accidentInfoRDD;
        totalNumOfAccidents = this.accidentInfoRDD.count();
    }

    // 2.b Implementing exercise 1.a.i
    public void accidentsPerRoadClass() {
        Map<String, Iterable<AccidentInfo>> accidentsPerRoadClass = new TreeMap<>( Comparator.naturalOrder() );

        accidentsPerRoadClass.putAll( accidentInfoRDD
                .groupBy( x -> x.getFirstRoadClass() )
                .collectAsMap()
        );

        System.out.println( "2.b - The number of the accidents per road class are: " );
        accidentsPerRoadClass.forEach( (x, y) -> System.out.println( x + ": " + ( (Collection<?>)y ).size() ) );
    }

    // 2.c
    public void accidentsPerRoadUsingPartitions( JavaPairRDD<Integer, Iterable<AccidentInfo>> javaPairRDD ) {
        System.out.println( "2.c - The number of the accidents per road class are): " );
        javaPairRDD
                .groupBy( x -> { return x._2.iterator().next().getFirstRoadClass(); } )
                .foreach( x-> System.out.println( x._1 + ": " + ( (Collection<?>)x._2 ).size() ) );
    }

    // Print the total number of accidents
    public void totalNumOfAccidents() {
        System.out.println( totalNumOfAccidents );
    }

    // Percentage of accidents in Scotland
    public void accidentsInScotland() {
        float accidentsInScotland = accidentInfoRDD
                .filter( x -> x.getInScotland().equalsIgnoreCase( "Yes" ) )
                .count();
        System.out.println( "The is percentage of the accidents in Scotland is: " + accidentsInScotland / totalNumOfAccidents * 100 + "%" );
    }

    // Number of accidents in specific year
    public void accidentsIn( String year ) {
        float accidents2015 = accidentInfoRDD
                .filter( x -> x.getYear().equals( year ) )
                .count();
        System.out.println( "The is percentage of the accidents in 2015 was: " + accidents2015 / totalNumOfAccidents * 100 + "%" );
    }

    // Print the number of the accidents per year
    public void accidentPerYearSorted() {
        Map<String, Iterable<AccidentInfo>> accidentsPerYearSorted = new TreeMap<>( Comparator.naturalOrder() );

        accidentsPerYearSorted.putAll( accidentInfoRDD
                .groupBy( x -> x.getYear() )
                .collectAsMap()
        );

        System.out.println( "The number of the accidents per year are: " );
        accidentsPerYearSorted.forEach( (x, y) -> System.out.println( x + ": " + ( (Collection<?>)y ).size() ) );
    }


}
