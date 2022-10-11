package com.example.dedalusbackend.Service;

import com.example.dedalusbackend.Model.TextModel;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class TextAnalyzerService {

    HashMap<Character, Integer> LetterQuantityMap;
    String vowels = "aeiou";
    String consonants = "bcdfghjklmnpqrstvwxyz";

    public HashMap<Character, Integer> analyzeText(TextModel userInput) {
        LetterQuantityMap = new HashMap<>();
        String charLookingFor;
        if(userInput.getType().equals("vowels")){
            charLookingFor = vowels;
        }else{
            charLookingFor = consonants;
        }
        for(int i = 0; i < userInput.getText().length(); i++){
            char letter = userInput.getText().charAt(i);
            if(charLookingFor.contains(Character.toString(letter))){
                countLetters(letter);
            }
        }
        return LetterQuantityMap;
    }

    public void countLetters(char letter) {
        if(LetterQuantityMap.containsKey(letter)){
            LetterQuantityMap.put(letter, LetterQuantityMap.get(letter) + 1);
            return;
        }
        LetterQuantityMap.put(letter, 1);
    }
}
