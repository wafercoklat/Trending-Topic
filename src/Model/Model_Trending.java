/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Comparator;

/**
 *
 * @author rizagamal
 */
public class Model_Trending {

    String trending;
    String safikstree;
    int score_safikstree;
    int jumlah_safikstree;

    public String getTrending() {
        return safikstree;
    }

    public void setTrending(String trending) {
        this.trending = trending;
    }

    public String getSafikstree() {
        return safikstree;
    }

    public void setSafikstree(String safikstree) {
        this.safikstree = safikstree;
    }

    public int getScore_safikstree() {
        return score_safikstree;
    }

    public void setScore_safikstree(int score_safikstree) {
        this.score_safikstree = score_safikstree;
    }

    public int getJumlah_safikstree() {
        return jumlah_safikstree;
    }

    public void setJumlah_safikstree(int jumlah_safikstree) {
        this.jumlah_safikstree = jumlah_safikstree;
    }

    public static Comparator<Model_Trending> Score_Safiks = new Comparator<Model_Trending>() {

        public int compare(Model_Trending s1, Model_Trending s2) {
            int score1 = s1.getScore_safikstree();
            int score2 = s2.getScore_safikstree();

            //ascending order
            return score2 - score1;

            //descending order
            //return StudentName2.compareTo(StudentName1);
        }
    };

    @Override
    public String toString() {
        return "[trending=" + safikstree + ", jumlah_suffixtree= " + jumlah_safikstree + ", score_safikstree=" + score_safikstree + "]";
    }
}
