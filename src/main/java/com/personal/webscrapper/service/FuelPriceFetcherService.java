package com.personal.webscrapper.service;

import com.personal.webscrapper.constants.Constant;
import com.personal.webscrapper.models.CityFuelPrice;
import com.personal.webscrapper.models.StateFuelPrice;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class FuelPriceFetcherService {
    private final Logger logger = LoggerFactory.getLogger(FuelPriceFetcherService.class);

    public List<CityFuelPrice> getCityFuelPrice(String petrolURL, String dieselURL, String stateName) {
        List<CityFuelPrice> fuelList = new ArrayList<>();
        final Document documentPetrol;
        Document fuelDocumentTmp;
        try {
            fuelDocumentTmp = Jsoup.connect(petrolURL).get();
        } catch (Exception e) {
            logger.error("Error while Fetching petrolURL : {}", e.toString());
            return new ArrayList<>();
        }
        documentPetrol = fuelDocumentTmp;

        for (Element row : documentPetrol.select(Constant.fuelPriceTableBloackAddress)) {
            if (!row.select(Constant.cityNameBlockAddress).text().equals("")) {
                CityFuelPrice cityFuelPrice = new CityFuelPrice();
                final String[] tmpPetrolPrice = row.select(Constant.fuelPriceBlockAddress).text().split(" ");

                cityFuelPrice.setCityName(row.select(Constant.cityNameBlockAddress).text());
                cityFuelPrice.setPetrolRate(Double.parseDouble(tmpPetrolPrice[0]));
                cityFuelPrice.setCurrDate(LocalDate.now());
                cityFuelPrice.setStateName(stateName);

                fuelList.add(cityFuelPrice);
            }
        }
        int itr = 0;
        final Document documentDiesel;
        try {
            fuelDocumentTmp = Jsoup.connect(dieselURL).get();
        } catch (Exception e) {
            logger.error("Error while Fetching dieselURL : {}", e.toString());
            return new ArrayList<>();
        }

        documentDiesel = fuelDocumentTmp;
        for (Element row : documentDiesel.select(Constant.fuelPriceTableBloackAddress)) {
            if (!row.select(Constant.cityNameBlockAddress).text().equals("")) {
                if (itr < fuelList.size()) {
                    final String[] tmpDieselPrice = row.select(Constant.fuelPriceBlockAddress).text().split(" ");
                    fuelList.get(itr).setDieselRate(Double.parseDouble(tmpDieselPrice[0]));
                    itr++;
                }
            }
        }

        return fuelList;
    }

    public List<StateFuelPrice> getStateFuelPrice(String petrolURL, String dieselURL) {
        List<StateFuelPrice> list = new ArrayList<>();

        try {
            final Document documentPetrol = Jsoup.connect(petrolURL).get();

            for (Element row : documentPetrol.select(Constant.fuelPriceTableBloackAddress)) {
                if (row.select(Constant.cityNameBlockAddress).text().equals("")) {
                    continue;
                } else {
                    StateFuelPrice stateFuelPrice = new StateFuelPrice();
                    final String[] tmpPetrolPrice = row.select(Constant.fuelPriceBlockAddress).text().split(" ");

                    stateFuelPrice.setStateName(row.select(Constant.cityNameBlockAddress).text());
                    stateFuelPrice.setStatePetrolPrice(Double.parseDouble(tmpPetrolPrice[0]));
                    stateFuelPrice.setCurrDate(LocalDate.now());
                    stateFuelPrice.setStatePetrolURL(row.getElementsByTag("a").attr("href"));

                    list.add(stateFuelPrice);
                }
            }
            int itr = 0;
            final Document documentDiesel = Jsoup.connect(dieselURL).get();
            for (Element row : documentDiesel.select(Constant.fuelPriceTableBloackAddress)) {
                if (row.select(Constant.cityNameBlockAddress).text().equals("")) {
                    continue;
                } else {
                    if (itr < list.size()) {
                        final String[] tmpDieselPrice = row.select(Constant.fuelPriceBlockAddress).text().split(" ");
                        list.get(itr).setStateDieselPrice(Double.parseDouble(tmpDieselPrice[0]));
                        list.get(itr).setStateDieselURL(row.getElementsByTag("a").attr("href"));
                        itr++;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
