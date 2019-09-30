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
    private FaceModel programFaceModel;

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
        programFaceModel=fsv.getFaceModel();
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
        switch(programFaceModel.radioChoice) {
            case 0: //face
                red.setProgress(programFaceModel.hairRed);
                green.setProgress(programFaceModel.hairGreen);
                blue.setProgress(programFaceModel.hairBlue);
                break;
            case 1: //eyes
                red.setProgress(programFaceModel.eyeRed);
                green.setProgress(programFaceModel.eyeGreen);
                blue.setProgress(programFaceModel.eyeBlue);
                break;
            case 2: //skin
                red.setProgress(programFaceModel.skinRed);
                green.setProgress(programFaceModel.skinGreen);
                blue.setProgress(programFaceModel.skinBlue);
                break;
        }
    }
}
