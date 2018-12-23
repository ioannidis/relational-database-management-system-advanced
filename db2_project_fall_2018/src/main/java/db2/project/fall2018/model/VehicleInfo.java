package db2.project.fall2018.model;

import java.io.Serializable;

public class VehicleInfo implements Serializable {

    private int id;

    private String accidentIndex;

    private String ageBandOfDriver;

    private float ageOfVehicle;

    private String make;

    private String model;

    private String sexOfDriver;

    private String vehicleType;

    public VehicleInfo() {
    }

    public VehicleInfo(int id, String accidentIndex, String ageBandOfDriver, float ageOfVehicle, String make, String model, String sexOfDriver, String vehicleType) {
        this.id = id;
        this.accidentIndex = accidentIndex;
        this.ageBandOfDriver = ageBandOfDriver;
        this.ageOfVehicle = ageOfVehicle;
        this.make = make;
        this.model = model;
        this.sexOfDriver = sexOfDriver;
        this.vehicleType = vehicleType;
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

    public String getAgeBandOfDriver() {
        return ageBandOfDriver;
    }

    public void setAgeBandOfDriver(String ageBandOfDriver) {
        this.ageBandOfDriver = ageBandOfDriver;
    }

    public float getAgeOfVehicle() {
        return ageOfVehicle;
    }

    public void setAgeOfVehicle(float ageOfVehicle) {
        this.ageOfVehicle = ageOfVehicle;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSexOfDriver() {
        return sexOfDriver;
    }

    public void setSexOfDriver(String sexOfDriver) {
        this.sexOfDriver = sexOfDriver;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public String toString() {
        return "VehicleInfo{" +
                "id=" + id +
                ", accidentIndex='" + accidentIndex + '\'' +
                ", ageBandOfDriver='" + ageBandOfDriver + '\'' +
                ", ageOfVehicle=" + ageOfVehicle +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", sexOfDriver='" + sexOfDriver + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                '}';
    }

}
