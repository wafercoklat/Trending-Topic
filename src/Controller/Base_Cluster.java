/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

/**
 *
 * @author rizagamal
 */
public class Base_Cluster {

    ArrayList<ArrayList> documentCount = new ArrayList<>();

    public ArrayList<ArrayList> sufix(ArrayList<ArrayList> all_data) {
        ArrayList<ArrayList> bangkit_suffixtree = new ArrayList<>();
        ArrayList<String> safikstree;
        for (int i = 0; i < all_data.size(); i++) {
            safikstree = new ArrayList<>();
            String bangkit_gram = "";
            for (int j = all_data.get(i).size() - 1; j >= 0; j--) {
                bangkit_gram = all_data.get(i).get(j) + " " + bangkit_gram;
                safikstree.add(bangkit_gram.trim());
            }
            bangkit_suffixtree.add(safikstree);
        }
        return bangkit_suffixtree;
    }

    public ArrayList<String> parentWord(ArrayList<ArrayList> suffixtree_withalldata) {
        ArrayList<String> parentWords = new ArrayList<>();

        //Generate Suffix Tree Dynamiclly
        //Document suffix
        ArrayList<Node> tes = null;
        ArrayList<String> temp;
        String kata_children = "";

        //Create Parent first
        for (int i = 0; i < suffixtree_withalldata.size(); i++) {
            for (int j = 0; j < suffixtree_withalldata.get(i).size(); j++) {
                Node tree = new Node();
                String phrase = suffixtree_withalldata.get(i).get(j).toString().trim();

                if (tes == null) {
                    tes = new ArrayList<>();
                    tree.addChild(phrase, "");
                    tes.add(tree);
                } else {
                    for (int k = 0; k < tes.size(); k++) {
                        String kata = "";
                        String split_phrase[] = tes.get(k).getParent().split(" ");
                        for (int l = 0; l < split_phrase.length; l++) {
                            temp = new ArrayList();
                            kata = kata + split_phrase[l] + " ";
                            temp.add(kata.trim());
                            for (int m = 0; m < temp.size(); m++) {
                                String phraseBanding = temp.get(m).trim();
                                if (phrase.startsWith(phraseBanding) && !phraseBanding.equals("") && phraseBanding.length() > 3 && phraseBanding.length() < 25) {
                                    String kataFinal = temp.get(m).toString().trim();
                                    parentWords.add(kataFinal.toString().trim());
                                }
                            }
                        }
                    }
                    tree.addChild(phrase, kata_children);
                    tes.add(tree);
                }
            }
        }

        //Delete duplicate words for Parent
        return deleteDuplicate(parentWords);
    }

    public void children(ArrayList<String> parentWords, ArrayList<ArrayList> suffixtree_withalldata) {
        ArrayList<String> getDocument = null;
        for (int i = 0; i < parentWords.size(); i++) {
            getDocument = new ArrayList<>();
            for (int j = 0; j < suffixtree_withalldata.size(); j++) {
                for (int k = 0; k < suffixtree_withalldata.get(j).size(); k++) {
                    String phrase = suffixtree_withalldata.get(j).get(k).toString().trim();
                    if (phrase.startsWith(parentWords.get(i)) && !parentWords.get(i).equals("")) {
                        getDocument.add(String.valueOf(j));
                    }
                }
            }
            documentCount.add(getDocument);
        }
    }

    public ArrayList<Integer> score_safikstree(ArrayList<String> node, ArrayList<Integer> document) {
        ArrayList<Integer> score_suffiList = new ArrayList<>();
        for (int i = 0; i < node.size(); i++) {
            String split_safikstree[] = node.get(i).toString().split(" ");
            int total_dokument = split_safikstree.length;
            score_suffiList.add(document.get(i) * total_dokument);
        }
        return score_suffiList;
    }

    public ArrayList<Integer> jumlah_suffix(ArrayList<ArrayList> count) {
        ArrayList<Integer> jumlah_safikstree = new ArrayList<>();
        for (int i = 0; i < count.size(); i++) {
            jumlah_safikstree.add(count.get(i).size());
        }
        return jumlah_safikstree;
    }

    private ArrayList<String> deleteDuplicate(ArrayList<String> parent) {
        Set<String> set = new HashSet<>(parent);
        parent.clear();
        parent.addAll(set);
        return parent;
    }

    public ArrayList<ArrayList> getdocumentCount() {
        ArrayList<String> count = new ArrayList<>();
        ArrayList<ArrayList> getCount = new ArrayList<>();
        for (int i = 0; i < documentCount.size(); i++) {
            count = deleteDuplicate(documentCount.get(i));
            getCount.add(count);
        }
        return getCount;
    }
}
