/**
 * class that runs the faceCustomizationApp.
 * It sets appropriate listeners to classes
 *
 * @author John Haas
 */

package com.example.homework21;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    /**
     * method that starts the app and sets appropriate listeners to classes
     *
     * @param savedInstanceState    I have no idea what this is
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * External Citation
         * Problem: I did not know how to implement spinners
         *
         * Resource: https://developer.android.com/guide/topics/ui/controls/spinner#java
         * Solution: I used a lot of the sample code in this resource
         */
        //the common surface view
        Face affectedImage = (Face)findViewById(R.id.myFaceSurfaceView);

        //the common faceModel
        FaceModel programFaceModel=affectedImage.getFaceModel();

        //spinner that controls the different hairstyles
        Spinner hairSpinner = findViewById(R.id.hairTypeSpinner);

        //Creates an array adapter and assigns it to the spinner
        ArrayAdapter<CharSequence> hairStyleAdapter = ArrayAdapter.createFromResource(this,
                R.array.hair_type_array, android.R.layout.simple_spinner_item);
        hairStyleAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        hairSpinner.setAdapter(hairStyleAdapter);

        //creates a controller for the different types of hairstyles
        HairStyleSpinnerListener hairStyleController=new HairStyleSpinnerListener(affectedImage);

        //sets the face style controller to the appropriate spinner
        hairSpinner.setOnItemSelectedListener(hairStyleController);



        //creates a redSeekBarListener and assigns it to the appropriate seekbar
        RedSeekBarListener redController = new RedSeekBarListener(affectedImage);
        SeekBar redSeekBar = findViewById(R.id.redSeekBar);
        redSeekBar.setOnSeekBarChangeListener(redController);

        //creates a greenSeekBarListener and assigns it to the appropriate seekbar
        GreenSeekBarListener greenController= new GreenSeekBarListener(affectedImage);
        SeekBar greenSeekBar = findViewById(R.id.greenSeekBar);
        greenSeekBar.setOnSeekBarChangeListener(greenController);

        //creates a blueSeekBarListener and assigns it to the appropriate seekbar
        BlueSeekBarListener blueController = new BlueSeekBarListener(affectedImage);
        SeekBar blueSeekBar = findViewById(R.id.blueSeekBar);
        blueSeekBar.setOnSeekBarChangeListener(blueController);

        //creates controller for the radioButtons
        FeatureRadioButtonListener FeatureController =
                new FeatureRadioButtonListener(affectedImage, redSeekBar, greenSeekBar, blueSeekBar);

        //attaches the radioButtonController to the hairRadioButton
        RadioButton hairRadioButton = findViewById(R.id.hairRadioButton);
        hairRadioButton.setOnClickListener(FeatureController);

        //attaches the radioButtonController to the eyesRadioButton
        RadioButton eyesRadioButton = findViewById(R.id.eyesRadioButton);
        eyesRadioButton.setOnClickListener(FeatureController);

        //attaches the radioButtonController to the skinRadioButton
        RadioButton skinRadioButton = findViewById(R.id.skinRadioButton);
        skinRadioButton.setOnClickListener(FeatureController);

        //starts out program SeekBars and buttons to show randomized hair colors
        hairRadioButton.setChecked(true);
        redSeekBar.setProgress(programFaceModel.hairRed);
        greenSeekBar.setProgress(programFaceModel.hairGreen);
        blueSeekBar.setProgress(programFaceModel.hairBlue);

        //attaches the randomizeButton controller to the appropriate button
        RandomizeButtonListener rbl =
                new RandomizeButtonListener(affectedImage, redSeekBar, greenSeekBar, blueSeekBar);
        Button randomizeButton = (Button)findViewById(R.id.randomizeButton);
        randomizeButton.setOnClickListener(rbl);

    }
}
