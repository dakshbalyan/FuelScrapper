package com.personal.webscrapper.models;

import java.time.LocalDate;

public class StateFuelPrice {
    private String stateName;
    private Double statePetrolPrice;
    private Double stateDieselPrice;

    private String statePetrolURL;
    private String stateDieselURL;

    private LocalDate currDate;

    @Override
    public String toString() {
        return stateName + "," + statePetrolPrice + "," + stateDieselPrice + "," + currDate;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public Double getStatePetrolPrice() {
        return statePetrolPrice;
    }

    public void setStatePetrolPrice(Double statePetrolPrice) {
        this.statePetrolPrice = statePetrolPrice;
    }

    public Double getStateDieselPrice() {
        return stateDieselPrice;
    }

    public void setStateDieselPrice(Double stateDieselPrice) {
        this.stateDieselPrice = stateDieselPrice;
    }

    public String getStatePetrolURL() {
        return statePetrolURL;
    }

    public void setStatePetrolURL(String statePetrolURL) {
        this.statePetrolURL = statePetrolURL;
    }

    public String getStateDieselURL() {
        return stateDieselURL;
    }

    public void setStateDieselURL(String stateDieselURL) {
        this.stateDieselURL = stateDieselURL;
    }

    public LocalDate getCurrDate() {
        return currDate;
    }

    public void setCurrDate(LocalDate currDate) {
        this.currDate = currDate;
    }
}
