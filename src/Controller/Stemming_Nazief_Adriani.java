/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Dokumen;
import java.io.IOException;
import java.util.ArrayList;

public class Stemming_Nazief_Adriani {
      
   public String KataDasar(String kata) throws IOException {
        String akarkata = null;
         Dokumen dokumen=new Dokumen();
        ArrayList<String> kata_dasar =dokumen.get_kata_dasar();
        if(kata_dasar.contains(kata)){
            akarkata=kata;
        }else{
            kata=hapusInfleksionalSuffiks(kata);
            kata=hapusDerivationSuffiks(kata);
            akarkata=kata;
        }
        
        return akarkata;
                
    }
   
    public String  hapusInfleksionalSuffiks(String kata) {
        if (kata.endsWith("lah") || kata.endsWith("kah") || kata.endsWith("nya")
                || kata.endsWith("tah") || kata.endsWith("pun")) {
            kata = kata.substring(0, kata.length() - 3);
        } else if (kata.endsWith("ku") || kata.endsWith("mu")) {
            kata = kata.substring(0, kata.length() - 2);
        }
        return kata;
        
    }
    
    
     public String hapusDerivationSuffiks(String kata) throws IOException {
       boolean isHapusSuffix = false;
       String bersikan;
       String akarkata;
        if (kata.endsWith("i")) {
            bersikan = kata.substring(0, kata.length() - 1);
            isHapusSuffix = true;
        } else if (kata.endsWith("kan")) {
            bersikan = kata.substring(0, kata.length() - 3);
            isHapusSuffix = true;
        } else if (kata.endsWith("an")) {
            bersikan = kata.substring(0, kata.length() - 2);
            isHapusSuffix = true;
        }else{
            bersikan=kata;
        }

        //3a.jika kata ditemukan dalam kamus maka algoritma berhenti
        Dokumen dokumen=new Dokumen();
        ArrayList<String> kata_dasar =dokumen.get_kata_dasar();
          
        if(kata_dasar.contains(bersikan)){
            akarkata=bersikan;
           
        }else {
            //lanjut ke langkah 4.
            //jika ada suffiks yang dihapus pergi ke langkah 4a.
            akarkata = kata;
           
            if (isHapusSuffix == true) {
              
                akarkata=derivationPrefiksA(akarkata);
                
            } else {//jika tidak ada pergi langkah 4b.
                
                akarkata=derivationPrefiksB(akarkata);
               
            }

        }
        return akarkata;
    }
     
     private String derivationPrefiksA(String akarKata) {
        //periksa kombinasi awalan dan akhiran yang tidak diijinkan
        boolean tipe1 = (akarKata.startsWith("be") && akarKata.endsWith("i"));
        boolean tipe2 = akarKata.startsWith("di") && akarKata.endsWith("an");
        boolean tipe3 = akarKata.startsWith("ke") && (akarKata.endsWith("i") || akarKata.endsWith("kan"));
        boolean tipe4 = akarKata.startsWith("me") && akarKata.endsWith("an");
        boolean tipe5 = akarKata.startsWith("se") && (akarKata.endsWith("i") || akarKata.endsWith("kan"));
        //jika kata tidak ditemukan maka menuju ke langkah 4b
        if (((tipe1) || (tipe2) || (tipe3) || (tipe4) || (tipe5)) == false) {
         
            akarKata=derivationPrefiksB(akarKata);
           
        }
        
        return akarKata;
    }

    private String derivationPrefiksB(String akarKata) {
        //tipe awalan ke-1 : -di,-ke,-se
        if ((akarKata.startsWith("di") || akarKata.startsWith("ke") || akarKata.startsWith("se"))
                && akarKata.length() > 2) {
            akarKata = akarKata.substring(2, akarKata.length());
        } //tipe awalan ke-2 : -te,-me,-be,-pe
        else if ((akarKata.startsWith("te") || akarKata.startsWith("me")
                || akarKata.startsWith("be") || akarKata.startsWith("pe"))) {
            //jika tipe prefiks bukan none digunakan rabel 2.
            String kata2 = akarKata.substring(2, akarKata.length());
            
            /*
             * tipe prefik : row 1 -->prefix none pada row pertama di tabel 2.
             * huruf r pada index pertama dihilangkan untuk mendapatkan kata dasar
             */
            if (kata2.length() > 3) {
                if ((kata2.charAt(0) == 'r') && (kata2.charAt(1) == 'r')) {
                    akarKata = kata2;
                } //tipe prefik:row 2 --> ter-luluh,digunakan tabel 3 sehingga yang dihilangkan adalah prefiks ter-
                else if ((kata2.charAt(0) == 'r') && (vowel(kata2.charAt(1)))) {
                    akarKata = kata2.substring(1, kata2.length());
                    //contoh: terevolusi-->evolusi
                } //tipe prefik: row 3 -->digunakan tabel 3 sehingga yang dihilangkan adalah prefiks ter-
                else if ((kata2.charAt(0) == 'r') && !((kata2.charAt(1) == 'r') || (vowel(kata2.charAt(1))))
                        && (kata2.charAt(2) == 'e') && (kata2.charAt(3) == 'r') && (vowel(kata2.charAt(4)))) {
                    akarKata = kata2.substring(1, kata2.length());
                }//row 4
                else if ((kata2.charAt(0) == 'r') && !((kata2.charAt(1) == 'r') || (vowel(kata2.charAt(1))))
                        && (kata2.charAt(2) == 'e') && (kata2.charAt(3) == 'r') && !(vowel(kata2.charAt(4)))) {
                    akarKata = kata2;
                }//row 5
                else if ((kata2.charAt(0) == 'r') && !((kata2.charAt(1) == 'r') || (vowel(kata2.charAt(1))))
                        && !(kata2.charAt(2) == 'e') && !(kata2.charAt(3) == 'r')) {
                    akarKata = kata2.substring(1, kata2.length());
                }//row 6
                else if (!((kata2.charAt(0) == 'r') || (vowel(kata2.charAt(0))))
                        && (kata2.charAt(1) == 'e') && (kata2.charAt(2) == 'r') && (vowel(kata2.charAt(3)))) {
                    akarKata = kata2;
                }//row 7
                else if (!((kata2.charAt(0) == 'r') || (vowel(kata2.charAt(0))))
                        && (kata2.charAt(1) == 'e') && (kata2.charAt(2) == 'r') && (!vowel(kata2.charAt(3)))) {
                    akarKata = kata2;
                } else {
                    akarKata = kata2;
                }
            }
        }
        return akarKata;
    }
    private boolean vowel(char huruf) {
        if (huruf == 'a' || huruf == 'i' || huruf == 'u' || huruf == 'e' || huruf == 'o') {
            return true;
        }
        return false;
    }
}
