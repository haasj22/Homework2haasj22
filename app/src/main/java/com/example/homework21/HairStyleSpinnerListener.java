/**
 * class that acts as a controller for the spinner
 *
 * @author John Haas
 */

package com.example.homework21;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;

public class HairStyleSpinnerListener extends Activity implements AdapterView.OnItemSelectedListener {
    //instance variables
    private Face programFaceView;
    private FaceModel affectedFaceModel;

    /**
     * method that constructs an objects of the hairStyleSpinnerController class
     *
     * @param fsm
     */
    public HairStyleSpinnerListener(Face fsm) {
        //instantiates instance variables
        super();
        programFaceView=fsm;
        affectedFaceModel=fsm.getFaceModel();
    }

    /**
     * method that controls what happens when a new item is selected
     *
     * @param adapterView adapter that controls what clicked
     * @param view button that was clicked
     * @param i position of clicked button
     * @param l id of the clicked button
     */
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        //changes the hairstyle to the one selected
        affectedFaceModel.hairStyle=i;
        programFaceView.invalidate();
    }

    /**
     * necessary method for interface not needed for this program
     *
     * @param adapterView adapter that controls what clicked
     */
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
