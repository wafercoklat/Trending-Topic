/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Dokumen;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PreProcessingProses {

    public ArrayList<String> tokenization(String pdfFileInText) {
        ArrayList<String> tokenization = new ArrayList<>();

        // split by whitespace
        String lines[] = pdfFileInText.split(" ");
        for (String line : lines) {
            tokenization.add(line.replace("\n", ""));
//      System.out.println("lines "+line.replace("\n","").toLowerCase());
        }
        return tokenization;
    }

    public ArrayList<String> casefolding(ArrayList<String> tokenization) {
        ArrayList<String> casefolding = new ArrayList<>();
        for (int i = 0; i < tokenization.size(); i++) {
            String kata = tokenization.get(i).toLowerCase();
            casefolding.add(kata);
        }
        return casefolding;
    }

    public ArrayList<String> stopword_removal(ArrayList<String> casefolding) {
        ArrayList<String> stopword_removal = new ArrayList<>();
        Dokumen dokumen = new Dokumen();
        try {
            ArrayList<String> stopword = dokumen.get_stopword_list();
            for (int i = 0; i < casefolding.size(); i++) {
                if (!casefolding.get(i).equals("")) {
                    if (!stopword.contains(casefolding.get(i))) {
                        stopword_removal.add(casefolding.get(i));
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(PreProcessingProses.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stopword_removal;
    }

    public ArrayList<String> stemming(ArrayList<String> stopword_removal) throws IOException {
        ArrayList<String> kata_dasar_dokumen_tes = new ArrayList<>();
        Stemming_Nazief_Adriani sna = new Stemming_Nazief_Adriani();
        for (int i = 0; i < stopword_removal.size(); i++) {
            kata_dasar_dokumen_tes.add(sna.KataDasar(stopword_removal.get(i).toString()));

        }
        return kata_dasar_dokumen_tes;
    }
}
