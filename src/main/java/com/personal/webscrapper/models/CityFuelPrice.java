package com.personal.webscrapper.models;

import java.time.LocalDate;

public class CityFuelPrice {
    private String cityName;
    private String stateName;
    private double petrolRate;
    private double dieselRate;
    private LocalDate currDate;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public double getPetrolRate() {
        return petrolRate;
    }

    public void setPetrolRate(double petrolRate) {
        this.petrolRate = petrolRate;
    }

    public double getDieselRate() {
        return dieselRate;
    }

    public void setDieselRate(double dieselRate) {
        this.dieselRate = dieselRate;
    }

    public LocalDate getCurrDate() {
        return currDate;
    }

    public void setCurrDate(LocalDate currDate) {
        this.currDate = currDate;
    }

    @Override
    public String toString() {
        return cityName + "," + stateName + "," + petrolRate +
                "," + dieselRate + "," + currDate;
    }
}
