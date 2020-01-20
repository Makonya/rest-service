package com.makonya.restservice.controller;

import com.makonya.restservice.entity.ChessBoard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ChessController {

    @Autowired
    @Qualifier("chessBoard")
    private  ChessBoard chessBoard;

    // Пример запроса - http://localhost:8080/arrange?position=h6
    @GetMapping("/arrange")
    public String arrange(@RequestParam( value = "position") String position) {
        chessBoard.setFirstQueenPosition(position);
        return chessBoard.findQueenSequence();
    }
}
