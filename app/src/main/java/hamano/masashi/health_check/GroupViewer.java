package hamano.masashi.health_check;

import android.widget.TextView;

/**
 * Created by masashihamano on 2018/03/08.
 */

public class GroupViewer {

    private TextView aval;
    private TextView bval;
    private TextView abval;
    private TextView oval;

    private int fathergroup;
    private int mothergroup;

    GroupViewer(int fgroup, int mgrp, TextView avalue, TextView bvalue, TextView abvalue, TextView ovalue) {
        this.abval = abvalue;
        this.aval = avalue;
        this.bval = bvalue;
        this.oval = ovalue;

        this.fathergroup = fgroup;
        this.mothergroup = mgrp;

    }

    void show(){

        aval.setText("0 %");
        bval.setText("0 %");
        abval.setText("0 %");
        oval.setText("0 %");

        if (fathergroup == 0 && mothergroup == 0) {
            aval.setText("84 %");
            oval.setText("16 %");
        }

        if ((fathergroup == 0 && mothergroup == 1) | (fathergroup == 1 && mothergroup == 0)) {
            aval.setText("26 %");
            bval.setText("23 %");
            abval.setText("34 %");
            oval.setText("17 %");
        }

        if ((fathergroup == 0 && mothergroup == 2) | (fathergroup == 2 && mothergroup == 0)) {
            aval.setText("50 %");
            abval.setText("30 %");
            bval.setText("20 %");
        }

        if ((fathergroup == 0 && mothergroup == 3) | (fathergroup == 3 && mothergroup == 0)) {
            aval.setText("60 %");
            oval.setText("40 %");
        }

        if (fathergroup == 1 && mothergroup == 1) {
            bval.setText("81 %");
            oval.setText("19 %");
        }
        if ((fathergroup == 1 && mothergroup == 2) | (fathergroup == 2 && mothergroup == 1)) {
            bval.setText("50 %");
            abval.setText("28 %");
            aval.setText("22 %");
        }

        if ((fathergroup == 1 && mothergroup == 3) | (fathergroup == 3 && mothergroup == 1)) {
            bval.setText("57 %");
            oval.setText("43 %");
        }

        if (fathergroup == 2 && mothergroup == 2) {
            aval.setText("25 %");
            abval.setText("50 %");
            bval.setText("25 %");
        }
        if ((fathergroup == 2 && mothergroup == 3) | (fathergroup == 3 && mothergroup == 2)) {
            aval.setText("50 %");
            bval.setText("50 %");
        }
        if (fathergroup == 3 && mothergroup == 3) {
            oval.setText("100 %");
        }
    }


}
