package models;

import java.util.Date;

public class CarAd {
    int adId;
    String carRegnum;
    Date startDate;
    Date endDate;
    int renterId; //if 0, car is available for renting

    public CarAd (String carRegnum, Date startDate, Date endDate, int renterId) {
        this.adId = (int)(Math.random() * 10000); //change to guarantee unique in future
        this.carRegnum = carRegnum;
        this.startDate = startDate;
        this.endDate = endDate;
        this.renterId = renterId;
    }

    public boolean rentCar(int user){
        if (renterId == 0) {
            this.renterId = user;
            return true;
        }
        else {
            return false;
        }
    }

    public String getCarObject() {
        return carRegnum;
    }

    public void setCarObject(String carRegnum) {
        this.carRegnum = carRegnum;
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


}
