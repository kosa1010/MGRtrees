/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loadData;

import java.util.ArrayList;

/**
 *
 * @author kosa1010
 */
public class DataObject {

    private ArrayList<Integer> features;
    private String decisionAtrib;

    public DataObject(String decAtrib) {
        this.features = new ArrayList<>();
        this.decisionAtrib = decAtrib;
    }

    public ArrayList<Integer> getFeatures() {
        return features;
    }

    public int getFeature(int index) {
        return features.get(index);
    }

    public String getDecisionAtrib() {
        return decisionAtrib;
    }

    public void setFeatures(ArrayList<Integer> features) {
        this.features = features;
    }

    public void setDecisionAtrib(String decisionAtrib) {
        this.decisionAtrib = decisionAtrib;
    }

//    public void readOneObject(String line, char separator) {
//        String[] values = line.split(new Character(separator).toString());
//
//        for (String value : values) {
//            if (value.startsWith("#")) {
//                if (line.length() > 1) {
//                    this.id = Integer.parseInt(value.substring(1, value.length()));
//                }
//            }
//            if (DataOblect.isNum(value)) {
//                this.features.add(Double.parseDouble(value));
//            }
//            if (value.startsWith("+")) {
//                if (line.length() > 1) {
//                    this.name = value.substring(1, value.length());
//                }
//            }
//            if (value.startsWith("%")) {
//                if (line.length() > 1) {
//                    if (value.charAt(1) == 'M' || value.charAt(1) == 'm') {
//                        this.gender = Case.M;
//                    }
//                    if (value.charAt(1) == 'F' || value.charAt(1) == 'f') {
//                        this.gender = Case.F;
//                    }
//                }
//            }
//        }
//    }
}
