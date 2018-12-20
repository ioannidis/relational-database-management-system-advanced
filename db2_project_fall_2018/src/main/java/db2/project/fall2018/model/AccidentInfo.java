package db2.project.fall2018.model;

import java.io.Serializable;


public class AccidentInfo implements Serializable {

    private int id;

    private String accidentIndex;

    private String firstRoadClass;

    private String accidentSeverity;

    private String date;

    private String urbanOrRuralArea;

    private String weatherConditions;

    private String year;

    private String inScotland;

    public AccidentInfo() {}

    public AccidentInfo(int id, String accidentIndex, String firstRoadClass, String accidentSeverity, String date, String urbanOrRuralArea, String weatherConditions, String year, String inScotland) {
        this.id = id;
        this.accidentIndex = accidentIndex;
        this.firstRoadClass = firstRoadClass;
        this.accidentSeverity = accidentSeverity;
        this.date = date;
        this.urbanOrRuralArea = urbanOrRuralArea;
        this.weatherConditions = weatherConditions;
        this.year = year;
        this.inScotland = inScotland;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccidentIndex() {
        return accidentIndex;
    }

    public void setAccidentIndex(String accidentIndex) {
        this.accidentIndex = accidentIndex;
    }

    public String getFirstRoadClass() {
        return firstRoadClass;
    }

    public void setFirstRoadClass(String firstRoadClass) {
        this.firstRoadClass = firstRoadClass;
    }

    public String getAccidentSeverity() {
        return accidentSeverity;
    }

    public void setAccidentSeverity(String accidentSeverity) {
        this.accidentSeverity = accidentSeverity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUrbanOrRuralArea() {
        return urbanOrRuralArea;
    }

    public void setUrbanOrRuralArea(String urbanOrRuralArea) {
        this.urbanOrRuralArea = urbanOrRuralArea;
    }

    public String getWeatherConditions() {
        return weatherConditions;
    }

    public void setWeatherConditions(String weatherContitions) {
        this.weatherConditions = weatherContitions;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getInScotland() {
        return inScotland;
    }

    public void setInScotland(String inScotland) {
        this.inScotland = inScotland;
    }

    @Override
    public String toString() {
        return "AccidentInfo{" +
                "id=" + id +
                ", accidentIndex='" + accidentIndex + '\'' +
                ", firstRoadClass='" + firstRoadClass + '\'' +
                ", accidentSeverity='" + accidentSeverity + '\'' +
                ", date=" + date +
                ", urbanOrRuralArea='" + urbanOrRuralArea + '\'' +
                ", weatherContitions='" + weatherConditions + '\'' +
                ", year=" + year +
                ", inScotland='" + inScotland + '\'' +
                '}';
    }
}
