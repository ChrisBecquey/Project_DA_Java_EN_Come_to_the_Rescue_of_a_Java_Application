package com.hemebiotech.analytics;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.TreeMap;

public class AnalyticsCounter {

    public static void main(String[] args) throws Exception {
        CheckSymptomFile checkSymptomFile = new CheckSymptomFile();
        String filePathFromClassPath;
        String fileName = "symptoms.txt";
        String outPutFile = "result";

        try {
            filePathFromClassPath = checkSymptomFile.getFilePathFromClassPath(fileName);
            ISymptomReader reader = new ReadSymptomDataFromFile(filePathFromClassPath);
            ISymptomCounter counter = new CountSymptom();
            ISymptomWriter writer = new WriteSymptomOnNewFile(outPutFile);

            List<String> symptoms = reader.readSymptoms();
            TreeMap<String, Integer> mapSymptoms = counter.orderedSymptoms(symptoms);
            writer.writeSymptoms(mapSymptoms);

        } catch (FileNotFoundException e) {
            System.out.println("File " + fileName + " not found");
        }
    }
}

