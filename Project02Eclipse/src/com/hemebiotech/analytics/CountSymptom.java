package com.hemebiotech.analytics;

import java.util.List;
import java.util.TreeMap;

public class CountSymptom implements ISymptomCounter {

    public TreeMap<String, Integer> orderedSymptoms(List<String> listFromFile) {

        TreeMap<String, Integer> mapSymptoms = new TreeMap<>();
        int count = 1;
        for (String symptoms : listFromFile) {

            if (!mapSymptoms.containsKey(symptoms)) {
                mapSymptoms.put(symptoms, count);
            } else {
                Integer currentValue = mapSymptoms.get(symptoms);
                mapSymptoms.replace(symptoms, ++currentValue);
            }

        }
        return mapSymptoms;
    }
}


