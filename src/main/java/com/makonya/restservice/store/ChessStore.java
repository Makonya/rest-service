package com.makonya.restservice.store;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ChessStore {
    private static final Map<Integer, Integer> yPositions = new HashMap<>(); // y-позиции шахматной доски (от 1-8)
    private static final Map<Character, Integer> xPositions = new HashMap<>(); // x-позиции шахматной доски (от a-h)

    static {
        yPositions.put(8, 0);
        yPositions.put(7, 1);
        yPositions.put(6, 2);
        yPositions.put(5, 3);
        yPositions.put(4, 4);
        yPositions.put(3, 5);
        yPositions.put(2, 6);
        yPositions.put(1, 7);

        xPositions.put('a', 1);
        xPositions.put('b', 2);
        xPositions.put('c', 3);
        xPositions.put('d', 4);
        xPositions.put('e', 5);
        xPositions.put('f', 6);
        xPositions.put('g', 7);
        xPositions.put('h', 8);
    }

    public static int getYPositions(String s) {
        return yPositions.get(Integer.parseInt(String.valueOf(s.charAt(1)))); //пример: a2 берем значение 2
    }

    public static int getXPositions(String s) {
        return xPositions.get(s.charAt(0)); //пример: a2 берем значение a
    }

    public static Character getValueByXPosition(Integer value) {
        for (Map.Entry<Character, Integer> entry : xPositions.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

    public static Integer getValueByYPosition(Integer value) {
        for (Map.Entry<Integer, Integer> entry : yPositions.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }
}
