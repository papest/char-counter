package ru.papest.charcounter;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class FrequencyMap {

    Map<String, Integer> map;

    public FrequencyMap(String text) {
        List<String> list = Arrays.stream(text.split("")).collect(Collectors.toList());
        map = list.stream().distinct()
                .collect(Collectors.toMap(a -> a, a -> Collections.frequency(list, a)))
                .entrySet().stream().sorted(Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (v1, v2) -> v1, LinkedHashMap::new));
    }

    public Map<String, Integer> getMap() {
        return map;
    }

    public String getMapToString() {
        return map.entrySet().stream().map(a -> "\"" + a.getKey() + "\": " + a.getValue())
                .collect(Collectors.joining(", ", "", ""));

    }
}
