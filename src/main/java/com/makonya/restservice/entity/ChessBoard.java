package com.makonya.restservice.entity;

import com.makonya.restservice.action.ArrangeQueenAction;
import com.makonya.restservice.store.ChessStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("chessBoard")
public class ChessBoard {

    @Autowired
    private ArrangeQueenAction arrangeQueenAction;

    private String firstQueenPosition;

    //  получение последовательности установленных фигур, с учетом первой поставленной
    public String findQueenSequence() {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            for (String positionsString : arrangeQueenAction.getArrangeSet()) {
                if (Integer.parseInt(String.valueOf(positionsString.charAt(ChessStore.getYPositions(firstQueenPosition)))) == ChessStore.getXPositions(firstQueenPosition)) {
                    printBoard(positionsString.toCharArray());
                    stringBuilder.append("Установка ферзей: ");
                    for (int i = 0; i < positionsString.length(); i++) {
                        stringBuilder.append(ChessStore.getValueByXPosition(Integer.parseInt(String.valueOf(positionsString.charAt(i)))));
                        stringBuilder.append(ChessStore.getValueByYPosition(i));
                        if (i != positionsString.length() - 1) {
                            stringBuilder.append(", ");
                        }
                    }
                    break;
                }
            }
        } catch (RuntimeException e) {
            stringBuilder.append("Введите значение входящее в пределы шахматной доски, от a1 до h8!");
        }
        return stringBuilder.toString();
    }

    // установка первой фигуры
    public void setFirstQueenPosition(String firstQueenPosition) {
        this.firstQueenPosition = firstQueenPosition;
    }

    // метод для отображения установленных фигур
    public static void printBoard(char[] pos) {
        System.out.println("Расположкние фигур:");
        for (int i = 0; i < pos.length; i++) {
            // Печать одной горизонтали
            int queenPos = Integer.parseInt(String.valueOf(pos[i]));
            for (int k = 1; k < queenPos; k++) {
                System.out.print("- ");
            }
            System.out.print("Q ");
            for (int k = queenPos + 1; k <= pos.length; k++) {
                System.out.print("- ");
            }
            System.out.print("\n");
        }
    }
}
