package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class ReadSymptomDataFromFile implements ISymptomReader {
    private final String filepath;
    /**
     * @param filepath a full or partial path to file with symptom strings in it, one per line
     */
    public ReadSymptomDataFromFile(String filepath) {
        this.filepath = filepath;
    }
    // On utilise le TreeMap pour avoir le tri par ordre alphabétique
    @Override
    public List<String> readSymptoms() {
        List<String> symptomsList = new ArrayList<>();

        File file = new File(filepath);

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();

            while ((line != null)) {
                symptomsList.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return symptomsList;
    }
}
