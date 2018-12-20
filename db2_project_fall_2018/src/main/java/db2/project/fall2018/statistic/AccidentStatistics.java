package db2.project.fall2018.statistic;

import db2.project.fall2018.model.AccidentInfo;
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
