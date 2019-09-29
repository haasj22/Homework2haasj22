/**
 * class that contains data about a single face
 *
 * @author John Haas
 */

package com.example.homework21;

import android.graphics.Color;

public class FaceModel {
    /**
     * External Citation
     * Problem: My Problem would crash whenever I tried to set a paint
     * equal to an int or long variable
     *
     * Resource: https://stackoverflow.com/questions/5248583/how-to-get-a-color
     * -from-hexadecimal-color-string
     * Solution: I used the parseColor method shown here
     */
    //public data that will be able to be accessed by a FaceModel instance.

    //defaults used to indicate that startup randomization did not work
    public int skinColor=Color.parseColor("#F1CFB4");
    public int eyeColor=Color.parseColor("#AAAAAA");
    public int hairColor=Color.parseColor("#FFFFFF");
    public int hairStyle=0;
    public int radioChoice=0;

    //eye values to be changed by the seekBars
    public int eyeRed=0;
    public int eyeGreen=0;
    public int eyeBlue=0;

    //eye values to be changed by the seekBars
    public int hairRed=0;
    public int hairGreen=0;
    public int hairBlue=0;

    //eye values to be changed by the seekBars
    public int skinRed=0;
    public int skinGreen=0;
    public int skinBlue=0;

    /**
     * External Citation
     * Problem: I was having difficulties combining 3 rgb values into 1 hex value
     *
     * Resource: https://stackoverflow.com/questions/3607858/
     * convert-a-rgb-color-value-to-a-hexadecimal-string/18194652
     * Solution: i used the line of code found here
     */

    /**
     * method that combines the 3 rgb hair values into one hex value
     */
    public void reevaluateHairColor() {
        String hexHair = String.format("#%02x%02x%02x", hairRed, hairGreen, hairBlue);
        hairColor = Color.parseColor(hexHair);
    }

    /**
     * method that combines the 3 rgb eye values into one hex value
     */
    public void reevaluateEyeColor() {
        String hexEye = String.format("#%02x%02x%02x", eyeRed, eyeGreen, eyeBlue);
        eyeColor = Color.parseColor(hexEye);
    }

    /**
     * method that combines the 3 rgb skin values into one hex value
     */
    public void reevaluateSkinColor() {
        String hexSkin = String.format("#%02x%02x%02x", skinRed, skinGreen, skinBlue);
        skinColor = Color.parseColor(hexSkin);
    }
}

