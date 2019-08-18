/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.ArrayList;

/**
 *
 * @author digitalcreative
 */
public class Node {

    String root;
    ArrayList<String> children = new ArrayList<>();

    public void addChild(String parent, String kata_children) {
        children = new ArrayList<>();
        this.root = parent;
        children.add(kata_children);
    }

    public String getParent() {
        return root;
    }

    public void addParent(String phrase) {
        this.root = phrase;
    }
}
