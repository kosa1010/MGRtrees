/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mgrtrees;

import java.util.ArrayList;
import loadData.DataObject;

/**
 *
 * @author kosa1010
 */
public class MainController {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MainController mv = new MainController();
        // mv.showMainView();
        // mv.setActions();

        ArrayList<Double> entropies = new ArrayList<>();
        String[] heather = {"temperatura", "ciśnienie", "wysokość", "samopoczucie"};
        int[][] data = {
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
        double entropy;
        int[] a = {6, 4};
        int[] b = {2, 3, 5};
        int[] c = {5, 5,};
        int[][] partOfSubsets = {{3, 3}, {1, 3}};
        int[][] partOfSubsets2 = {{2, 0}, {1, 2}, {1, 4}};
        int[][] partOfSubsets3 = {{2, 3}, {2, 3}};
        C45 c45 = new C45();
        System.out.println("etropia dec " + c45.calcEntropy(C45.ENTROPY.DECISION, 10, a, null));
        entropy = c45.calcEntropy(C45.ENTROPY.ATTRIBUTE, 10, a, partOfSubsets);
        System.out.println("etropia atr1 " + entropy);
        entropies.add(entropy);
        entropy = c45.calcEntropy(C45.ENTROPY.ATTRIBUTE, 10, b, partOfSubsets2);
        System.out.println("etropia atr2 " + entropy);
        entropies.add(entropy);
        entropy = c45.calcEntropy(C45.ENTROPY.ATTRIBUTE, 10, c, partOfSubsets3);
        System.out.println("etropia atr3 " + entropy);
        entropies.add(entropy);
        System.out.println("zysk " + c45.calcGain(c45.calcEntropy(C45.ENTROPY.DECISION, 10, a, null), c45.calcEntropy(C45.ENTROPY.ATTRIBUTE, 10, a, partOfSubsets)));

    }

    private void c45(ArrayList<DataObject> dObj, String... param) {

    }

}
