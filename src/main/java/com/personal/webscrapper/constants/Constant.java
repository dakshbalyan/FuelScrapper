package com.personal.webscrapper.constants;

public class Constant {
    // Properties Key value
    public static final String PETROL_PRICE_URL_KEY = "petrol-price-url";
    public static final String DIESEL_PRICE_URL_KEY = "diesel-price-url";

    // File names
    public static final String STATE_FILE_NAME = "StateFuelPrices.csv";

    // Web page element block names
    public static final String cityNameBlockAddress = "td:nth-of-type(1)";
    public static final String fuelPriceBlockAddress = "td:nth-of-type(2)";
    public static final String fuelPriceTableBloackAddress = "table.font-16.color-blue tr";
}
