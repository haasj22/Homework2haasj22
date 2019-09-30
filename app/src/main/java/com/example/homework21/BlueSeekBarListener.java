/**
 * class that acts as a listener for the program's blueSeekBar
 *
 * @author John Haas
 */

package com.example.homework21;

import android.widget.SeekBar;

public class BlueSeekBarListener implements SeekBar.OnSeekBarChangeListener {
    //instance variables
    Face myFaceSurfaceView;
    FaceModel affectedFaceModel;

    /**
     * constructor for objects of the blueSeekBarListener class
     *
     * @param fsv the Face (Surface View) being passed in
     *            that will influence Seekbar's progress
     */
    public BlueSeekBarListener(Face fsv) {
        myFaceSurfaceView = fsv;
        affectedFaceModel = fsv.getFaceModel();
    }

    /**
     * method that will react when SeekBar's progress is changed
     *
     * @param seekBar SeekBar whose progress needs to be changed
     * @param i the current progress level
     * @param b whether the change was from the user
     */
    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        //sets the faceModel's red color variables appropriately
        if(affectedFaceModel.radioChoice == 0) { //hair
            affectedFaceModel.hairBlue=i;
            affectedFaceModel.reevaluateHairColor();
        } else if (affectedFaceModel.radioChoice == 1) { //eyes
            affectedFaceModel.eyeBlue=i;
            affectedFaceModel.reevaluateEyeColor();
        } else { //skin
            affectedFaceModel.skinBlue=i;
            affectedFaceModel.reevaluateSkinColor();
        }
        //redraws image
        myFaceSurfaceView.invalidate();
    }

    /**
     * method that needs to be implemented but is not used
     *
     * @param seekBar not really applicable
     */
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    /**
     * method that needs to be implemented but is not used
     *
     * @param seekBar not really applicable
     */
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
