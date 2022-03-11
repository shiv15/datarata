package com.datarata.datagenerator.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Random;

import com.datarata.datagenerator.Constants;
import com.datarata.datagenerator.ErrorMessages;

import org.springframework.stereotype.Service;

@Service
public class DataService {

    private Random random = SecureRandom.getInstanceStrong();

    DataService() throws NoSuchAlgorithmException {

    }


    public String generateWord(int size) throws IOException {
        int randomNumber = this.random.nextInt((Constants.ADJECTIVE_UPPER_BOUND - size) + 1) + size;

        StringBuilder generatedWord = new StringBuilder(10);
        int stringLength = 0;
        ArrayList<String> adjectiveList = this.loadWordFile("adjective", randomNumber);
        ArrayList<String> nounList = this.loadWordFile("noun", randomNumber);
        ArrayList<String> verbList = this.loadWordFile("verb", randomNumber);

        for (int i = 1; stringLength < size ; i++) {
            generatedWord.append(adjectiveList.get(randomNumber - i) 
                    + "_" + nounList.get(randomNumber - i) 
                    + "_" + verbList.get(randomNumber - i)); 
            generatedWord.append("_");
            stringLength = generatedWord.toString().length();
        }

        // trim the generated word.
        return generatedWord.substring(0, size);
    }

    private ArrayList<String> loadWordFile(String wordType, int randomNumber) throws IOException {

        int count = 1;
        ArrayList<String> wordArray = new ArrayList<>();
        try (
            InputStream fs = this.getFileStream(wordType);
            BufferedReader r = new BufferedReader(new InputStreamReader(fs));
        ) {
            while (randomNumber >= count) {
                wordArray.add(r.readLine());
                count++;
            }
            return wordArray;
        } catch(Exception exp) {
            throw new FileNotFoundException(ErrorMessages.FILE_NOT_FOUND_ERROR);
        }
    }

    private InputStream getFileStream(String wordType) throws FileNotFoundException {
        switch(wordType) {
            case "adjective":
                return DataService.class.getResourceAsStream("/static/a.txt");
            case "noun":
                return DataService.class.getResourceAsStream("/static/n.txt");
            case "verb": 
                return DataService.class.getResourceAsStream("/static/v.txt");
            default:
                throw new FileNotFoundException(ErrorMessages.FILE_NOT_FOUND_ERROR);
        }
    }
}
