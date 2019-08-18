/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Dokumen;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DokumenManager {

    public String get_data(String Path) throws IOException {
        Dokumen dokumen = new Dokumen();
        String data = "";
        try {
            data = dokumen.get_all_file_from_txt(Path);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(DokumenManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    public ArrayList<String> get_kalimat(String contens) {
        ArrayList<String> kalimat = new ArrayList<>();
        String[] contens_split = contens.trim().split("\n");

        for (int i = 0; i < contens_split.length; i++) {
            if (contens_split[i] != "") {
                kalimat.add(contens_split[i]);
            }

        }
        return kalimat;
    }
}
