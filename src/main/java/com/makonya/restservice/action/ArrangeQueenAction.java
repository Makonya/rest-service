package com.makonya.restservice.action;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class ArrangeQueenAction {
    //Множество для хранения уникальных позиций расстоновок(по вертикали)
    private Set<String> arrangeSet = new HashSet<String>();

    public ArrangeQueenAction() {
        //new int[8] - шахматная доска 8*8
        arrangeQueen(new int[8], 0);
    }

    // метод для формирования всех возсожных расстановок
    public int[] arrangeQueen(int[] positions, int n) {
        int count = positions.length; // количество фигур
        if (n == count) return positions; // все фигуры уже расставлены
        for (int j = 1; j <= count; j++) {
            // Пробуем поставить фигуру последовательно на вертикали
            boolean correct = true; // признак корректной расстановки
            for (int i = 0; i < n; i++) {
                // Проверяем, не атакует ли новая фигура расставленных
                if (positions[i] == j || n - i == Math.abs(j - positions[i])) {
                    // проверяем по одной вертикали или диагонали
                    correct = false;
                    break;
                }
            }
            if (correct) {
                positions[n] = j;
                // Установили фигуру в свою позицию и пробуем расставить остальные фигуры с помощью рекурсивного вызова функции                //
                int[] pos = arrangeQueen(positions, n + 1);
                if (pos != null) {// расстановка найдена!
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int i = 0; i < pos.length; i++) {
                        stringBuilder.append(pos[i]);
                    }
                    arrangeSet.add(stringBuilder.toString());
                }
            }
        }
        return null;
    }

    public Set<String> getArrangeSet() {
        return arrangeSet;
    }
}
