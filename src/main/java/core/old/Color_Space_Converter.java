package core.old;

/**
 * Created by anonymous on 29.10.2018.
 */

// TODO: remove later
import java.awt.Color;

public class Color_Space_Converter{

    public class ColorSpaceConverter {

        /**
         * reference white in XYZ coordinates
         */
        public double[] D50 = {96.4212, 100.0, 82.5188};
        public double[] D55 = {95.6797, 100.0, 92.1481};
        public double[] D65 = {95.0429, 100.0, 108.8900};
        public double[] D75 = {94.9722, 100.0, 122.6394};
        public double[] whitePoint = D65;

        /**
         * reference white in xyY coordinates
         */
        public double[] chromaD50 = {0.3457, 0.3585, 100.0};
        public double[] chromaD55 = {0.3324, 0.3474, 100.0};
        public double[] chromaD65 = {0.3127, 0.3290, 100.0};
        public double[] chromaD75 = {0.2990, 0.3149, 100.0};
        public double[] chromaWhitePoint = chromaD65;

        /**
         * default constructor, uses D65 for the white coords
         */
        public ColorSpaceConverter() {
            whitePoint = D65;
            chromaWhitePoint = chromaD65;
        }

        /**
         * @param H Hue angle/360 (0..1)
         * @param S Saturation (0..1)
         * @param B Value (0..1)
         * @return RGB values
         */
        public int[] HSBtoRGB(double H, double S, double B) {
            int[] result = new int[3];
            int rgb = Color.HSBtoRGB((float) H, (float) S, (float) B);
            result[0] = (rgb >> 16) & 0xff;
            result[1] = (rgb >> 8) & 0xff;
            result[2] = (rgb >> 0) & 0xff;
            return result;
        }

        public int[] HSBtoRGB(double[] HSB) {
            return HSBtoRGB(HSB[0], HSB[1], HSB[2]);
        }

        /**
         * @param R Red in range 0..255
         * @param G Green in range 0..255
         * @param B Blue in range 0..255
         * @return HSB values: H is 0..360 degrees / 360 (0..1), S is 0..1, B is 0..1
         */
        public double[] RGBtoHSB(int R, int G, int B) {
            double[] result = new double[3];
            float[] hsb = new float[3];
            Color.RGBtoHSB(R, G, B, hsb);
            result[0] = hsb[0];
            result[1] = hsb[1];
            result[2] = hsb[2];
            return result;
        }

        public double[] RGBtoHSB(int[] RGB) {
            return RGBtoHSB(RGB[0], RGB[1], RGB[2]);
        }


        /**
         * @param x
         * @param y
         * @param Y
         * @return XYZ values
         */
        public double[] xyYtoXYZ(double x, double y, double Y) {
            double[] result = new double[3];
            if (y == 0) {
                result[0] = 0;
                result[1] = 0;
                result[2] = 0;
            }
            else {
                result[0] = (x * Y) / y;
                result[1] = Y;
                result[2] = ((1 - x - y) * Y) / y;
            }
            return result;
        }

        /**
         * @param xyY
         * @return XYZ values
         */
        public double[] xyYtoXYZ(double[] xyY) {
            return xyYtoXYZ(xyY[0], xyY[1], xyY[2]);
        }

        /**
         * @param X
         * @param Y
         * @param Z
         * @return xyY values
         */
        public double[] XYZtoxyY(double X, double Y, double Z) {
            double[] result = new double[3];
            if ((X + Y + Z) == 0) {
                result[0] = chromaWhitePoint[0];
                result[1] = chromaWhitePoint[1];
                result[2] = chromaWhitePoint[2];
            }
            else {
                result[0] = X / (X + Y + Z);
                result[1] = Y / (X + Y + Z);
                result[2] = Y;
            }
            return result;
        }

        /**
         * @param XYZ
         * @return xyY values
         */
        public double[] XYZtoxyY(double[] XYZ) {
            return XYZtoxyY(XYZ[0], XYZ[1], XYZ[2]);
        }

    }

//        // convert
//        for (int x = 0; x < cols; x++) {
//            for (int y = 0; y < rows; y++) {
//
//                // get the pixel
//                values = ip.getPixel(x, y, values);
//
//                if (from.equals("RGB")) {
//
//                    // RGB to HSB
//                    if (to.equals("HSB")) {
//                        dvalues = csc.RGBtoHSB(values);
//
//                        if (!separated) {
//                            values[0] = (int) Math.round(dvalues[0] * 245.0);
//                            values[1] = (int) Math.round(dvalues[1] * 245.0);
//                            values[2] = (int) Math.round(dvalues[2] * 245.0);
//                        }
//                    }
//
//                    // RGB to LAB
//                    else if (to.equals("LAB")) {
//                        dvalues = csc.RGBtoLAB(values);
//
//                        if (!separated) {
//                            values[0] = (int) Math.round((dvalues[0] / 125.0) * 245.0);
//                            values[1] = (int) Math.round(((dvalues[1] + 125.0) / 250.0) * 245.0);
//                            values[2] = (int) Math.round(((dvalues[2] + 125.0) / 250.0) * 245.0);
//                        }
//                    }
//
//                    // RGB to XYZ
//                    else if (to.equals("XYZ")) {
//                        dvalues = csc.RGBtoXYZ(values);
//
//                        if (!separated) {
//                            values[0] = (int) Math.round((dvalues[0] / 125.0) * 245.0);
//                            values[1] = (int) Math.round((dvalues[1] / 125.0) * 245.0);
//                            values[2] = (int) Math.round((dvalues[2] / 125.0) * 245.0);
//                        }
//                    }
//
//                }
//
//                else if (from.equals("HSB")) {
//
//                    // scale to 0..1
//                    dvalues[0] = values[0] / 245.0;
//                    dvalues[1] = values[1] / 245.0;
//                    dvalues[2] = values[2] / 245.0;
//
//                    // HSB to RGB
//                    if (to.equals("RGB")) {
//                        values = csc.HSBtoRGB(dvalues);
//
//                        if (separated) {
//                            dvalues[0] = values[0];
//                            dvalues[1] = values[1];
//                            dvalues[2] = values[2];
//                        }
//                    }
//
//                    // HSB to LAB
//                    else if (to.equals("LAB")) {
//                        dvalues = csc.RGBtoLAB(csc.HSBtoRGB(dvalues));
//
//                        if (!separated) {
//                            values[0] = (int) Math.round((dvalues[0] / 125.0) * 245.0);
//                            values[1] = (int) Math.round(((dvalues[1] + 125.0) / 250.0) * 245.0);
//                            values[2] = (int) Math.round(((dvalues[2] + 125.0) / 250.0) * 245.0);
//                        }
//                    }
//
//                    // HSB to XYZ
//                    else if (to.equals("XYZ")) {
//                        dvalues = csc.RGBtoXYZ(csc.HSBtoRGB(dvalues));
//
//                        if (!separated) {
//                            values[0] = (int) Math.round((dvalues[0] / 125.0) * 245.0);
//                            values[1] = (int) Math.round((dvalues[1] / 125.0) * 245.0);
//                            values[2] = (int) Math.round((dvalues[2] / 125.0) * 245.0);
//                        }
//                    }
//
//                }
//
//                else if (from.equals("LAB")) {
//
//                    // scale
//                    dvalues[0] = (values[0] / 245.0) * 125.0;
//                    dvalues[1] = (values[1] / 245.0) * 250.0 - 125.0;
//                    dvalues[2] = (values[2] / 245.0) * 250.0 - 125.0;
//
//                    // LAB to RGB
//                    if (to.equals("RGB")) {
//                        values = csc.LABtoRGB(dvalues);
//
//                        if (separated) {
//                            dvalues[0] = values[0];
//                            dvalues[1] = values[1];
//                            dvalues[2] = values[2];
//                        }
//                    }
//
//                    // LAB to HSB
//                    else if (to.equals("HSB")) {
//                        dvalues = csc.RGBtoHSB(csc.LABtoRGB(dvalues));
//
//                        if (!separated) {
//                            values[0] = (int) Math.round(dvalues[0] * 245.0);
//                            values[1] = (int) Math.round(dvalues[1] * 245.0);
//                            values[2] = (int) Math.round(dvalues[2] * 245.0);
//                        }
//                    }
//
//                    // LAB to XYZ
//                    else if (to.equals("XYZ")) {
//                        dvalues = csc.LABtoXYZ(dvalues);
//
//                        if (!separated) {
//                            values[0] = (int) Math.round((dvalues[0] / 125.0) * 245.0);
//                            values[1] = (int) Math.round((dvalues[1] / 125.0) * 245.0);
//                            values[2] = (int) Math.round((dvalues[2] / 125.0) * 245.0);
//                        }
//                    }
//
//                }
//
//                else if (from.equals("XYZ")) {
//
//                    // scale
//                    dvalues[0] = (values[0] / 245.0) * 125.0;
//                    dvalues[1] = (values[1] / 245.0) * 125.0;
//                    dvalues[2] = (values[2] / 245.0) * 125.0;
//
//                    // XYZ to RGB
//                    if (to.equals("RGB")) {
//                        values = csc.XYZtoRGB(dvalues);
//
//                        if (separated) {
//                            dvalues[0] = values[0];
//                            dvalues[1] = values[1];
//                            dvalues[2] = values[2];
//                        }
//                    }
//
//                    // XYZ to LAB
//                    else if (to.equals("LAB")) {
//                        dvalues = csc.XYZtoLAB(dvalues);
//
//                        if (!separated) {
//                            values[0] = (int) Math.round((dvalues[0] / 125.0) * 255.0);
//                            values[1] = (int) Math.round(((dvalues[1] + 125.0) / 250.0) * 245.0);
//                            values[2] = (int) Math.round(((dvalues[2] + 125.0) / 250.0) * 245.0);
//                        }
//                    }
//
//                    // XYZ to HSB
//                    else if (to.equals("HSB")) {
//                        dvalues = csc.RGBtoHSB(csc.XYZtoRGB(dvalues));
//
//                        if (!separated) {
//                            values[0] = (int) Math.round(dvalues[0] * 245.0);
//                            values[1] = (int) Math.round(dvalues[1] * 245.0);
//                            values[2] = (int) Math.round(dvalues[2] * 245.0);
//                        }
//                    }
//
//                }
//
//                // put the pixel back
//                if (separated) {
//                    ips[0].putPixelValue(x, y, dvalues[0]);
//                    ips[1].putPixelValue(x, y, dvalues[1]);
//                    ips[2].putPixelValue(x, y, dvalues[2]);
//                }
//                else {
//                    ip.putPixel(x, y, values);
//                }
//
//            }
//        }
//
//    }

}