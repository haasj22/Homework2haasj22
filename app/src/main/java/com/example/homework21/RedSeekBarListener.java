/**
 * class that acts as a listener for the program's greenSeekBar
 *
 * @author John Haas
 */

package com.example.homework21;

import android.widget.SeekBar;

public class RedSeekBarListener implements SeekBar.OnSeekBarChangeListener {
    //instance variables
    Face myFaceSurfaceView;
    FaceModel affectedFaceModel;

    /**
     * constructor for objects of the GreenSeekBarListener class
     *
     * @param fsv the Face (Surface View) being passed in
     *            that will influence Seekbar's progress
     */
    public RedSeekBarListener(Face fsv) {
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
        //sets the faceModel's green color variables appropriately
        if(affectedFaceModel.radioChoice == 0) { //hair
            affectedFaceModel.hairRed=i;
            affectedFaceModel.reevaluateHairColor();
        } else if (affectedFaceModel.radioChoice == 1) { //eyes
            affectedFaceModel.eyeRed=i;
            affectedFaceModel.reevaluateEyeColor();
        } else { //skin
            affectedFaceModel.skinRed=i;
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
