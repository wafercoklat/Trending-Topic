/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Model_Trending;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author rizagamal
 */
public class Model_Manager {

    public ArrayList<Model_Trending> make_model(ArrayList<String> safikstree, ArrayList<Integer> score_safikstree, ArrayList<Integer> jumlah_safikstree) {
        ArrayList<Model_Trending> model_trending = new ArrayList<>();
        for (int i = 0; i < safikstree.size(); i++) {
            Model_Trending mt = new Model_Trending();
            mt.setJumlah_safikstree(jumlah_safikstree.get(i));
            mt.setSafikstree(safikstree.get(i));
            mt.setScore_safikstree(score_safikstree.get(i));
            model_trending.add(mt);
        }
        return model_trending;

    }
}
