package com.example.dedalusbackend.Controller;

import com.example.dedalusbackend.Model.TextModel;
import com.example.dedalusbackend.Service.TextAnalyzerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;


@RestController
public class TextAnalyzerController {

    @Autowired
    private TextAnalyzerService service;

    @PostMapping(path="/analyze")
    public HashMap<Character, Integer> apiCallPost(@RequestBody TextModel text){
        return service.analyzeText(text);
    }
}
