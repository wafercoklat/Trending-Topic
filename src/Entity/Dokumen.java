/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Dokumen {

    public String get_all_file_from_txt(String filepath) throws FileNotFoundException, IOException {
        String contents = "";
        try {
            File f = new File(filepath);
            BufferedReader b = new BufferedReader(new FileReader(f));
            String readLine = "";
            while ((readLine = b.readLine()) != null) {
                contents = contents + readLine + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return replaceLast(contents, "~", "");
        //read all
        //return new String(Files.readAllBytes(Paths.get(filepath)));
    }

    public static String replaceLast(String text, String regex, String replacement) {
        return text.replaceFirst("(?s)(.*)" + regex, "$1" + replacement);
    }

    public ArrayList<String> get_stopword_list() throws FileNotFoundException, IOException {
        ArrayList<String> stopword = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("/Users/Back/Desktop/Tugas Akhir 2/Program/TrendingTopicBerita/Kamus/stopword.txt"))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                stopword.add(line);
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
        }
        return stopword;
    }

    public ArrayList<String> get_kata_dasar() throws FileNotFoundException, IOException {
        ArrayList<String> kata_dasar = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("/Users/Back/Desktop/Tugas Akhir 2/Program/TrendingTopicBerita/Kamus/kata_dasar.txt"))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                kata_dasar.add(line);
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
        }
        return kata_dasar;
    }

}
