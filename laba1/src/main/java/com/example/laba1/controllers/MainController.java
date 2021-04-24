package com.example.laba1.controllers;

import com.example.laba1.service.FileWorkerService;
import com.example.laba1.exceptions.InputException;
import com.example.laba1.parametres.entityParametres;
import com.example.laba1.validator.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    private static final Logger logger = LogManager.getLogger();
    private static final String DATABASE = "D:\\Учеба\\КПП\\laba1\\database.txt";

    @GetMapping("/main")
    public String main(Model model) {
        model.addAttribute("message");
        return "fib";
    }

    @PostMapping("/main")
    public String processMain(@RequestParam String inputPosition, Model model) {
        Validator validator = new Validator();
        try {
            FileWorkerService fileWorker = new FileWorkerService();
            logger.info("Input: " + inputPosition);
            validator.CheckString(inputPosition);
            int position = Integer.parseInt(inputPosition);
            entityParametres parametres = new entityParametres(position);
            parametres.CalculateFibonacci();
            model.addAttribute("input",inputPosition);
            model.addAttribute("message", "Значение: " + parametres.getNewValue());
            fileWorker.write(DATABASE, parametres);
            logger.info("Output: " + parametres.getNewValue());
        }
        catch (InputException ex) {
            logger.error("Exception: " + ex.getMessage());
            model.addAttribute("message", ex.getMessage());
        }
        return "fib";
    }

    @PostMapping("/database")
    public String database(Model model) {
        return "database";
    }
}
