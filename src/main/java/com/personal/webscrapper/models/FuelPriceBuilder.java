package com.personal.webscrapper.models;

import lombok.NonNull;

import java.time.LocalDate;

public class FuelPriceBuilder {
    // Required properties
    private String cityName;
    private String stateName;
    private double petrolRate;
    private double dieselRate;
    private LocalDate currDate;

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String cityName;
        private String stateName;
        private double petrolRate;
        private double dieselRate;
        private LocalDate currDate;

        public Builder cityName(@NonNull String cityName) {
            this.cityName = cityName;
            return this;
        }

        public Builder stateName(@NonNull String stateName) {
            this.stateName = stateName;
            return this;
        }

        public Builder petrolRate(@NonNull Double petrolRate) {
            this.petrolRate = petrolRate;
            return this;
        }

        public Builder dieselRate(@NonNull Double dieselRate) {
            this.dieselRate = dieselRate;
            return this;
        }

        public Builder currDate(@NonNull LocalDate date) {
            this.currDate = date;
            return this;
        }

        public FuelPriceBuilder build() {
            if (this.cityName.equals("") || this.stateName.equals("")
                    || this.dieselRate == 0 || this.petrolRate == 0 || this.currDate == null) {
                throw new RuntimeException("All values should be present!");
            }

            FuelPriceBuilder fuelPriceBuilder = new FuelPriceBuilder();
            fuelPriceBuilder.currDate = currDate;
            fuelPriceBuilder.petrolRate = petrolRate;
            fuelPriceBuilder.dieselRate = dieselRate;
            fuelPriceBuilder.cityName = cityName;
            fuelPriceBuilder.stateName = stateName;


            return fuelPriceBuilder;
        }

    }

}
