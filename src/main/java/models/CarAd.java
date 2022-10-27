package models;

import java.time.*;
import java.util.Date;

public class CarAd {
    Car carObject;
    Date startDate;
    Date endDate;
    int renterId; //if 0 car is available for renting

    public Car getCarObject() {
        return carObject;
    }

    public void setCarObject(Car carObject) {
        this.carObject = carObject;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getRenterId() {
        return renterId;
    }

    public void setRenterId(int renterId) {
        this.renterId = renterId;
    }

    public CarAd (Car carObject, Date startDate, Date endDate, int renterId) {
        this.carObject = carObject;
        this.startDate = startDate;
        this.endDate = endDate;
        this.renterId = renterId;

    }
}
