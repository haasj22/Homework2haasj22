/**
 * class that acts as a controller for the radio buttons
 *
 * @author John Haas
 */

package com.example.homework21;

import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;

public class FeatureRadioButtonListener implements RadioGroup.OnClickListener{
    //instance variables
    Face myFaceSurfaceView;
    FaceModel affectedFaceModel;

    SeekBar red;
    SeekBar green;
    SeekBar blue;

    /**
     * constructor for objects of the featureRadioButtonController class
     *
     * @param fsv the surface view that the radio buttons will affect
     * @param r the redSeekBar affected by the radio buttons
     * @param g the greenSeekBar affected by the radio buttons
     * @param b the blueSeekBar affected by the radio buttons
     */
    public FeatureRadioButtonListener(Face fsv, SeekBar r, SeekBar g, SeekBar b) {
        //initializes the instance variables
        myFaceSurfaceView = fsv;
        affectedFaceModel = myFaceSurfaceView.getFaceModel();

        red=r;
        green=g;
        blue=b;
    }

    /**
     * method that controls what will happen when a radio button is clicked
     *
     * @param view view that was clicked
     */
    @Override
    public void onClick(View view) {
        //gets the text of the clicked radio button
        RadioButton theOneClicked=(RadioButton)view;
        CharSequence label=theOneClicked.getText();

        //changes radio choice and the seekBars progress based on which button was clicked
        if(label.charAt(0)=='H') { //hair
            affectedFaceModel.radioChoice = 0;

            red.setProgress(affectedFaceModel.hairRed);
            green.setProgress(affectedFaceModel.hairGreen);
            blue.setProgress(affectedFaceModel.hairBlue);
        }
        else if(label.charAt(0)=='E') { //eyes
            affectedFaceModel.radioChoice = 1;

            red.setProgress(affectedFaceModel.eyeRed);
            green.setProgress(affectedFaceModel.eyeGreen);
            blue.setProgress(affectedFaceModel.eyeBlue);
        }
        else { //skin
            affectedFaceModel.radioChoice = 2;

            red.setProgress(affectedFaceModel.skinRed);
            green.setProgress(affectedFaceModel.skinGreen);
            blue.setProgress(affectedFaceModel.skinBlue);
        }
    }
}
