package com.personal.webscrapper.service;

/*
Websites scrapping from -> https://www.ndtv.com/fuel-prices/petrol-price-in-uttar-pradesh-state
 */

import com.personal.webscrapper.constants.Constant;
import com.personal.webscrapper.models.CityFuelPrice;
import com.personal.webscrapper.models.StateFuelPrice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

@Service
public class FuelPriceScrapperService {
    private final Logger logger = LoggerFactory.getLogger(FuelPriceScrapperService.class);
    @Autowired
    FuelPriceFetcherService fetcherService;
    @Autowired
    WriterService writer;

    @Autowired
    Properties properties;
    @PostConstruct
    public void getStateList() throws IOException {
//        String pURL = "https://www.ndtv.com/fuel-prices/petrol-price-in-karnataka-state";
//        String dURL = "https://www.ndtv.com/fuel-prices/diesel-price-in-karnataka-state";
//        List<CityFuelPrice> list = fetcherService.getCityFuelPrice(pURL,dURL,"Karnataka");
//        String stateFileName = "KarnatakaFuelPrice.csv";
//        writer.writingToCityCSV(list,stateFileName);

        String pURL = properties.getProperty(Constant.PETROL_PRICE_URL_KEY);
        String dURL = properties.getProperty(Constant.DIESEL_PRICE_URL_KEY);
        List<StateFuelPrice> list = fetcherService.getStateFuelPrice(pURL,dURL);

        writer.writingToStateCSV(list,Constant.STATE_FILE_NAME);
        getCityFuelPrice(list);
    }

    public void getCityFuelPrice(List<StateFuelPrice> list){

        for(int i = 0 ; i < list.size() ; i++){
            String pURL = list.get(i).getStatePetrolURL();
            String dURL = list.get(i).getStateDieselURL();
            String stateName = list.get(i).getStateName();
            if(stateName.equals("Delhi"))
                continue;

            String fileName = stateName.replaceAll("\\s","")+"FuelPrice.csv";
            List<CityFuelPrice> cityList = fetcherService.getCityFuelPrice(pURL,dURL,stateName);

            writer.writingToCityCSV(cityList, fileName);
        }
    }
}
