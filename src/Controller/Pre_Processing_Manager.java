/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author rizagamal
 */
public class Pre_Processing_Manager {

    PreProcessingProses preProcessingProses = new PreProcessingProses();

    public ArrayList<String> tokenization_manager(String berita) {
        return preProcessingProses.tokenization(berita);
    }

    public ArrayList<String> casefolding_manager(ArrayList<String> tokenization_manager) {
        return preProcessingProses.casefolding(tokenization_manager);
    }

    public ArrayList<String> stopword_removal_manager(ArrayList<String> casefolding_manager) {
        return preProcessingProses.stopword_removal(casefolding_manager);
    }

    public ArrayList<String> stemming_manager(ArrayList<String> stopword_removal_manager) throws IOException {
        return preProcessingProses.stemming(stopword_removal_manager);
    }

}
