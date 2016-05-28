/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mgrtrees;

import java.util.ArrayList;

/**
 *
 * @author kosa1010
 */
public class MainController {

    static ArrayList<Double> entropies = new ArrayList<>();
    static String[] heather = {"temperatura", "ciśnienie", "wysokość", "samopoczucie"};
    static int[][] data = {
        {1, 1, 0, 1},
        {1, 1, 1, 1},
        {1, 0, 0, 1},
        {0, 0, 1, 1},
        {0, 0, 1, 0},
        {0, 0, 1, 0},
        {0, 2, 1, 0},
        {0, 2, 0, 0},
        {1, 2, 0, 0},
        {1, 2, 0, 0}};
    static double entropy;
    static int[] a = {6, 4};
    static int[] b = {2, 3, 5};
    static int[] c = {5, 5};
    static int[][] partOfSubsets = {{3, 3}, {1, 3}};
    static int[][] partOfSubsets2 = {{2, 0}, {1, 2}, {1, 4}};
    static int[][] partOfSubsets3 = {{2, 3}, {2, 3}};

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //MainController mv = new MainController();
        // mv.showMainView();
        // mv.setActions();
        buildtreeC45();

    }

    private static void buildtreeC45() {//ArrayList<DataObject> dObj, String... param) {
        C45 c45 = new C45();
        entropy = c45.calcEntropy(C45.ENTROPY.ATTRIBUTE, 10, b, partOfSubsets2);
        System.out.println("etropia atr2 " + entropy);
        entropies.add(entropy);
    }
}
