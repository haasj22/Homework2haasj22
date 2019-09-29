/**
 * class that acts as a listener for the randomize button
 *
 * @author John Haas
 */

package com.example.homework21;

import android.view.View;
import android.widget.SeekBar;

public class RandomizeButtonListener implements View.OnClickListener {
    //instance variable
    private Face FaceSurfaceView;
    private FaceModel ourFaceModel;

    SeekBar red;
    SeekBar green;
    SeekBar blue;

    /**
     * class that constructs an object of the RandomizeButtonListener class
     *
     * @param fsv surface view that the randomizeButton affects
     */
    public RandomizeButtonListener(Face fsv, SeekBar r, SeekBar g, SeekBar b) {
        FaceSurfaceView = fsv;
        ourFaceModel=fsv.getFaceModel();
        red=r;
        green=g;
        blue=b;
    }

    /**
     * class that controls what happens when randomize button is clicked
     *
     * @param view surface view that the button affects
     */
    @Override
    public void onClick(View view) {
        FaceSurfaceView.randomize();
        switch(ourFaceModel.radioChoice) {
            case 0: //face
                red.setProgress(ourFaceModel.hairRed);
                green.setProgress(ourFaceModel.hairGreen);
                blue.setProgress(ourFaceModel.hairBlue);
                break;
            case 1: //eyes
                red.setProgress(ourFaceModel.eyeRed);
                green.setProgress(ourFaceModel.eyeGreen);
                blue.setProgress(ourFaceModel.eyeBlue);
                break;
            case 2: //skin
                red.setProgress(ourFaceModel.skinRed);
                green.setProgress(ourFaceModel.skinGreen);
                blue.setProgress(ourFaceModel.skinBlue);
                break;
        }
    }
}
