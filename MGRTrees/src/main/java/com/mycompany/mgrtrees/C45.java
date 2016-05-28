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
public class C45 {

    /**
     * Pokazuje czy atrybut jest decyzyjny czy zwyczajny
     */
    enum ENTROPY {
        DECISION, ATTRIBUTE
    }

    /**
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
}
