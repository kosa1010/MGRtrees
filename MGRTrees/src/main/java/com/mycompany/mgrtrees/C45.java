/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mgrtrees;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kosa1010
 */
public class C45 {

    /**
     * Pokazuje czy atrybut jest decyzyjny czy zwyczajny
     */
    enum ENTROPY {
        DECISION, ATTRIBUTE
    }

    /**
     * Metoda oblicza entropię
     *
     * @param en atrybut zwykły lub decyzyjny
     * @param allObj liczba wszkich objektów w tablicy
     * @param subS liczba podzbiorów danego atrybutu
     * @param partSubs podział podzbiorów danego atrybutu
     * @return
     */
    public double calcEntropy(ENTROPY en, int allObj, int[] subS, int[][] partSubs) {
        double entropy = 0;
        if (en.equals(ENTROPY.DECISION)) {
            for (int s : subS) {
                entropy += ((double) s / (double) allObj)
                        * (Math.log((double) s / (double) allObj) / Math.log(2));
            }
        } else {
            ArrayList<Double> subEntropy = new ArrayList<>();
            for (int i = 0; i < subS.length; i++) {
                double subentropy = 0;
                for (int k = 0; k < partSubs[i].length; k++) {
                    if ((double) partSubs[i][k] / subS[i] != 0) {
                        subentropy += (double) partSubs[i][k] / subS[i]
                                * (Math.log((double) partSubs[i][k] / (double) subS[i]) / Math.log(2));
                    }
                }
                subEntropy.add(subentropy);
            }
            for (int i = 0; i < subEntropy.size(); i++) {
                entropy += (double) subS[i] / allObj * subEntropy.get(i);
            }
        }
        return entropy * (-1);
    }

    /**
     * Metoda oblicza zysk fla danego atrybutu
     *
     * @param entDec
     * @param entAtrribute
     * @return
     */
    public double calcGain(double entDec, double entAtrribute) {
        return entDec - entAtrribute;
    }

    /**
     * Zlicza liczność podzbiorów na jakie są dzielone dane wedługo określonego
     * atrybutu
     *
     * @param tab talbicza z danymi
     * @param heather tablicza nazw nagłówków
     * @return
     */
    public List<int[]> countDataSubsets(int tab[][], String[] heather) {
        List<int[]> listOfSubsets = new ArrayList<>();
        return listOfSubsets;
    }

    /**
     * Zliczanie liczby elementów
     *
     * @param tab
     * @return
     */
    private int[] countElements(int tab[]) {
        ArrayList<Integer> countOfElems = new ArrayList<>();
        boolean all = false;
        int i = 0;
        int sum;
        while (!all) {
            sum = 0;
            for (int a : tab) {
                if (tab[i] == a) {
                    sum += 1;
                }
            }
            countOfElems.add(sum);
            i++;
            int buf = 0;
            buf = countOfElems.stream().map((s) -> s).reduce(buf, Integer::sum);//foreach sumujący el w liscie
            if (buf >= tab.length) {
                all = true;
            }
        }
        int t[] = new int[countOfElems.size()];
        for (int ii = 0; ii < countOfElems.size(); ii++) {
            t[ii] = countOfElems.get(ii);
        }
        return t;
    }
}
