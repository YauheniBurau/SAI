package com.yauheni.burau.sai;

import core.converter.Converter;
import core.matrix.Matrix2dArgb;
import core.matrix.Matrix2dBoolean;
import core.matrix.Matrix2dNeuron;
import org.junit.Test;

import static java.awt.image.BufferedImage.TYPE_BYTE_GRAY;

/**
 * Created by anonymous on 04.02.2018.
 */


public class NeuronsTests {

    String dirIn = "E:\\temp\\in\\";
    String dirOut = "E:\\temp\\out\\";
    //    String imageFile = "game.png";
//    String imageFile = "desktop.png";
//    String imageFile = "lcd.png";
    String imageFile = "anime.png";
//    String imageFile = "table.png";
//    String imageFile = "table.JPG";
//    String imageFile = "nature1.jpeg";
//    String imageFile = "stown.png";
//    String imageFile = "alphabet_colors.png";
//    String imageFile = "ъ.png";
//    String imageFile = "table1.jpg";
//    String imageFile = "google.png";
//    String imageFile = "flower.jpg";
//    String imageFile = "fractal_rainbow_swirl.jpg";
//    String imageFile = "Alesya.png";
//    String imageFile = "apple.jpg";
//    String imageFile = "line45.png";
//    String imageFile = "Lara_Stown.jpg";
//    String imageFile = "graph.png";
//    String imageFile = "A.png";
//    String imageFile = "round.png";

    @Test
    public void detectContour() {
        Matrix2dArgb m2d = Matrix2dArgb.load(dirIn + imageFile);
        Matrix2dBoolean edge = m2d.edgeByColorDistance(32)
                .replacePoints(true, 0, 1, -1,-1)
                .replacePoints(false, 6, 8, -1,-1)
                .replace3x3(263, 262)
                .replace3x3(29, 28)
                .replace3x3(113, 112)
                .replace3x3(449, 448)
                .edge()
                .save(dirOut + imageFile + "_edge.png", "png", TYPE_BYTE_GRAY);
        System.out.println("n=" + edge.countPoints() );
        Matrix2dNeuron m2dN = Converter.booleanToNeurons(edge);
        Matrix2dBoolean m2dB = Converter.neuronToBoolean(m2dN);
        m2dB.save(dirOut + imageFile + "_point2dNeurons.png", "png", TYPE_BYTE_GRAY);
    }

}
