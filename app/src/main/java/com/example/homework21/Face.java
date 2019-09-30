/**
 * class that manages the face surface view
 *
 * @author John Haas
 */
package com.example.homework21;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceView;
import android.widget.RadioButton;
import android.widget.SeekBar;

public class Face extends SurfaceView {
    //instance variables
    private FaceModel programFaceModel=new FaceModel();

    SeekBar red;
    SeekBar blue;
    SeekBar green;

    RadioButton defaultCheckedButton;

    //paints
    private Paint facePaint = new Paint();
    private Paint hairPaint = new Paint();
    private Paint eyeWhitePaint = new Paint();
    private Paint irisPaint = new Paint();
    private Paint pupilPaint = new Paint();
    private Paint mouthPaint = new Paint();
    private Paint tonguePaint = new Paint();

    /**
     * constructor for objects of a face class
     *
     * @param context environment of the application
     * @param attr attributes of the desired XML file
     */
    public Face(Context context, AttributeSet attr) {
        super(context, attr);
        this.setWillNotDraw(false); //allows surface view to draw
        setBackgroundColor(Color.BLUE);

        this.initializePaints();

        //randomizes face model's value
        this.randomize();

    }

    /**
     * helper method to set all the paints to predetermined values
     */
    public void initializePaints() {
        //sets face Paint to a skin-like color
        facePaint.setColor(programFaceModel.skinColor);
        facePaint.setStyle(Paint.Style.FILL);

        //sets the paint for the hair equal to the FaceModel hairColor;
        hairPaint.setColor(programFaceModel.hairColor);
        hairPaint.setStyle(Paint.Style.FILL);

        //sets the eye white paint equal to white
        eyeWhitePaint.setColor(Color.WHITE);
        eyeWhitePaint.setStyle(Paint.Style.FILL);

        //sets the iris paint equal to the FaceModel eyeColor
        irisPaint.setColor(programFaceModel.eyeColor);
        irisPaint.setStyle(Paint.Style.FILL);

        //sets the pupil paint equal to black
        pupilPaint.setColor(Color.BLACK);
        pupilPaint.setStyle(Paint.Style.FILL);

        //sets the color of the mouth paint to black
        mouthPaint.setColor(Color.BLACK);
        mouthPaint.setStyle(Paint.Style.FILL);

        //sets the color of the tongue to red
        tonguePaint.setColor(Color.RED);
        tonguePaint.setStyle(Paint.Style.FILL);
    }

    /**
     * accessor for the FaceModel object
     *
     * @return the FaceModel object used in this program
     */
    public FaceModel getFaceModel() {
        return this.programFaceModel;
    }

    /**
     * method that draws the face onto the surfaceView
     *
     * @param canvas canvas the method draws on
     */
    @Override
    public void onDraw(Canvas canvas){

        //updates the hairColor
        hairPaint.setColor(programFaceModel.hairColor);
        irisPaint.setColor(programFaceModel.eyeColor);
        facePaint.setColor(programFaceModel.skinColor);

        //draws the hair
        drawHair(canvas);

        //draws face
        canvas.drawOval(400,150,800,650, facePaint);

        //draws a goatee if JesusStyle is selected
        if(programFaceModel.hairStyle == 2) {
            drawJesusGoatee(canvas);
        }

        //draws the eyes
        drawEyes(canvas, 500, 700, 350, 50);

        //draws the mouth
        drawMouth(canvas);
    }

    /**
     * method that draws the hair for the face
     *
     * @param canvas the canvas that will be drawn on
     */
    public void drawHair(Canvas canvas){
        //chooses which hair will be picked based on hairStyle values
        switch(programFaceModel.hairStyle) {
            case 0: //mohawk
                drawMohawk(canvas);
                break;
            case 1: //afro
                drawAfro(canvas);
                break;
            case 2: //Jesus haircut
                drawJesus(canvas);
                break;
        }
    }

    /**
     * method that draws a mohawk
     *
     * @param canvas canvas that the mohawk will be drawn on
     */
    public void drawMohawk(Canvas canvas) {
        //draws a small layer of hair above the head
        canvas.drawOval(430, 140, 770, 500, hairPaint);

        /**
         * External Citation
         * Problem: I did not know how to draw a triangle in android studio
         *
         * Resource: https://stackoverflow.com/questions/20544668/
         * how-to-draw-filled-triangle-on-android-canvas/22690364
         * Solution: I used the code found in this resource
         */
        //three points of the triangle
        Point pointA = new Point(580, 150);
        Point pointB = new Point(600, 50);
        Point pointC = new Point(620, 150);

        //draws a path between all three points
        Path mohawkPath = new Path();
        mohawkPath.setFillType(Path.FillType.EVEN_ODD);
        mohawkPath.lineTo(pointA.x, pointA.y);
        mohawkPath.lineTo(pointB.x, pointB.y);
        mohawkPath.lineTo(pointC.x, pointC.y);
        mohawkPath.lineTo(pointA.x, pointA.y);
        mohawkPath.close();

        //fills the triangle with paint
        canvas.drawPath(mohawkPath, hairPaint);
    }

    /**
     * method that draws an afro
     *
     * @param canvas canvas that the afro will be drawn on
     */
    public void drawAfro(Canvas canvas) {
        //it draws a giant afro of the desired color
        canvas.drawOval(300, 0, 900, 500, hairPaint);
    }

    /**
     * method that grows Jesus styled hair
     *
     * @param canvas canvas that the Jesus hair will be drawn on
     */
    public void drawJesus(Canvas canvas) {
        //draws the Jesus' hair
        canvas.drawOval(390, 120, 810, 500, hairPaint);
        canvas.drawRect(390, 300, 810, 700, hairPaint);
    }

    /**
     * method that draws Jesus goatee
     *
     * @param canvas canvas that Jesus goatee will be drawn on
     */
    public void drawJesusGoatee(Canvas canvas) {
        //draws Jesus' Goatee
        canvas.drawRect(560, 575, 640, 625, hairPaint);
        canvas.drawOval(560, 615, 640, 640, hairPaint);
    }

    /**
     * method that draws eyes
     *
     * @param canvas canvas that the eyes will be drawn on
     * @param cx1 center point of the left eye on the horizontal plane
     * @param cx2 center point of the right eye on the horizontal plane
     * @param cy center point of the eyes on the vertical plane
     * @param r radius of the eyes
     */
    public void drawEyes(Canvas canvas, int cx1, int cx2, int cy, int r) {
        //draws the eye whites
        canvas.drawCircle(cx1, cy, r, eyeWhitePaint);
        canvas.drawCircle(cx2, cy, r, eyeWhitePaint);

        //draws the irises of the eye
        canvas.drawCircle(cx1, cy, r * 3 / 5, irisPaint);
        canvas.drawCircle(cx2, cy, r * 3 / 5, irisPaint);

        //draws the pupils of the eyes
        canvas.drawCircle(cx1, cy, r * 1 / 5, pupilPaint);
        canvas.drawCircle(cx2, cy, r * 1 / 5, pupilPaint);
    }

    /**
     * method that draws a mouth
     *
     * @param canvas canvas that the mouth will be drawn on
     */
    public void drawMouth(Canvas canvas) {
        //draws the mouth then the tongue
        canvas.drawRect(570, 560, 630, 580, mouthPaint);
        canvas.drawOval(570, 570, 630, 590, tonguePaint);
    }

    /**
     * method that randomizes face models values
     */
    public void randomize() {
        //sets random hairstyle
        programFaceModel.hairStyle=(int)(Math.random() * 3);

        //sets random hair color
        programFaceModel.hairRed=(int)(Math.random() * 256);
        programFaceModel.hairGreen=(int)(Math.random() * 256);
        programFaceModel.hairBlue=(int)(Math.random() * 256);
        programFaceModel.reevaluateHairColor();

        //sets random eye color
        programFaceModel.eyeRed=(int)(Math.random() * 256);
        programFaceModel.eyeGreen=(int)(Math.random() * 256);
        programFaceModel.eyeRed=(int)(Math.random() * 256);
        programFaceModel.reevaluateEyeColor();

        //sets random skin color
        programFaceModel.skinRed=(int)(Math.random() * 256);
        programFaceModel.skinGreen=(int)(Math.random() * 256);
        programFaceModel.skinBlue=(int)(Math.random() * 256);
        programFaceModel.reevaluateSkinColor();

        //redraws
        this.invalidate();
    }

    /**
     * External Citation
     * Problem: I have to create a Face class before the SeekBars
     * in MainActivity but it needs to use SeekBars
     *
     * Resource: Professor Tribelhorn's office hours
     * Solution: use a mutator to pass the SeekBars in latter
     */

    /**
     * mutator for the SeekBars of this class' objects
     *
     * @param r the redSeekBar being passed in
     * @param g the greenSeekBar being passed in
     * @param b the blueSeekBar being passed in
     */
    public void setSeekBars(SeekBar r, SeekBar g, SeekBar b) {
        //initializes the seekBars
        red=r;
        green=g;
        blue=b;

        //updates the progress bars of the passed in seekBars accordingly
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
