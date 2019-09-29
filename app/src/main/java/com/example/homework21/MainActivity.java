/**
 * class that runs the faceCustomizationApp.
 * It sets appropriate listeners to classes
 *
 * @knownDeficiencies RandomizeButton does not update spinner
 *                    which is not required in the rubric
 *
 * @author John Haas
 * @programVersion September 2019
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
    Face affectedImage;
    FaceModel programFaceModel;

    SeekBar redSeekBar;
    SeekBar greenSeekBar;
    SeekBar blueSeekBar;

    /**
     * method that starts the app and sets appropriate listeners to classes
     *
     * @param savedInstanceState    I have no idea what this is
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //the common surface view
        affectedImage = (Face)findViewById(R.id.myFaceSurfaceView);

        //the common faceModel
        programFaceModel=affectedImage.getFaceModel();

        //sets the proper listeners to their views
        createSpinner();
        initializeSeekBars();
        createRadioButtons();
        createRandomizeButtonListener();
    }

    /**
     * method that creates a spinner with the appropriate text
     */
    public void createSpinner() {
        /**
         * External Citation
         * Problem: I did not know how to implement spinners
         *
         * Resource: https://developer.android.com/guide/topics/ui/controls/spinner#java
         * Solution: I used a lot of the sample code in this resource
         */
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
    }

    /**
     * method that initializes the instance SeekBars and sets the proper listeners
     */
    public void initializeSeekBars() {
        //creates a redSeekBarListener and assigns it to the appropriate SeekBar
        RedSeekBarListener redController = new RedSeekBarListener(affectedImage);
        redSeekBar = findViewById(R.id.redSeekBar);
        redSeekBar.setOnSeekBarChangeListener(redController);

        //creates a greenSeekBarListener and assigns it to the appropriate SeekBar
        GreenSeekBarListener greenController= new GreenSeekBarListener(affectedImage);
        greenSeekBar = findViewById(R.id.greenSeekBar);
        greenSeekBar.setOnSeekBarChangeListener(greenController);

        //creates a blueSeekBarListener and assigns it to the appropriate SeekBar
        BlueSeekBarListener blueController = new BlueSeekBarListener(affectedImage);
        blueSeekBar = findViewById(R.id.blueSeekBar);
        blueSeekBar.setOnSeekBarChangeListener(blueController);
    }

    /**
     * method that sets listeners for all of the radio buttons
     */
    public void createRadioButtons() {
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
    }

    /**
     * method that creates a listener for the randomizeButton
     */
    public void createRandomizeButtonListener() {
        //attaches the randomizeButton controller to the appropriate button
        RandomizeButtonListener faceRandomizer =
                new RandomizeButtonListener(affectedImage, redSeekBar, greenSeekBar, blueSeekBar);
        Button randomizeButton = (Button)findViewById(R.id.randomizeButton);
        randomizeButton.setOnClickListener(faceRandomizer);
    }

}
