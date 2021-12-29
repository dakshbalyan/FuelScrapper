package com.personal.webscrapper.service;

import com.personal.webscrapper.models.CityFuelPrice;
import com.personal.webscrapper.models.StateFuelPrice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;

@Service
public class WriterService {
    private final Logger logger = LoggerFactory.getLogger(WriterService.class);

    public String convertToCityCSV(CityFuelPrice cityFuelPrice) {
        return cityFuelPrice.toString()+"\n";
    }
    public String convertToStateCSV(StateFuelPrice stateFuelPrice) {
        return stateFuelPrice.toString()+"\n";
    }

    public void writingToCityCSV(List<CityFuelPrice> fuelList, String fileName) {
        final String pathName = "src/main/resources/fuelprices-csv/"+fileName;

        try (FileWriter fw = new FileWriter(pathName, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter pw = new PrintWriter(bw)) {
            fuelList.stream()
                    .map(this::convertToCityCSV)
                    .forEach(pw::append);
            pw.flush();
            logger.info("Successfully written in "+fileName+" !");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void writingToStateCSV(List<StateFuelPrice> fuelList, String fileName) {
        final String pathName = "src/main/resources/fuelprices-csv/"+fileName;

        try (FileWriter fw = new FileWriter(pathName, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw)) {
            fuelList.stream()
                    .map(this::convertToStateCSV)
                    .forEach(pw::append);
            pw.flush();
            logger.info("Successfully written in "+fileName+" !");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
