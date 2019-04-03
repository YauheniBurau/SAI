package com.yauheni.burau.sai;

import core.application.workflow.algo.Reflection;
import core.application.workflow.algo.AlgoTest;
import core.application.workflow.workflow.IAlgorithm;
import core.application.workflow.workflow.Data;
import core.old.VertexValue.color.ARGB;
import core.old.VertexValue.file.PngFile;
import core.old.VertexValue.input.InputDataSensor;
import core.old.VertexValue.matrix.Matrix2d;
import core.old.VertexValue.matrix.Matrix2dByte;
import core.old.process.FileToMatrix.PngFileToM2dArgb;
import core.old.process.MatrixToFile.M2dDecart2dIntLinksToPngFile;
import core.old.process.MatrixToMatrix.M2dArgbToM2dByte256Colors;
import org.json.simple.JSONObject;
import org.junit.Test;

import java.io.*;

/**
 * Created by anonymous on 08.10.2016.
 */
public class AI_Test {

    String dirIn = "E:\\temp\\in\\";
    String dirOut = "E:\\temp\\out\\";
    String imageFile = "star3.png";

    @Test
    public void Png_Contour() {
        PngFile pngFileIn = new PngFile(dirIn + imageFile);
        Matrix2d<ARGB> m2dArgb = PngFileToM2dArgb.transform(pngFileIn);
        Matrix2dByte m2dByte = M2dArgbToM2dByte256Colors.transform(m2dArgb);
        InputDataSensor inputDataSensor = new InputDataSensor();
        inputDataSensor.setInputM2d(m2dByte);
        inputDataSensor.countContourM2d(400, 250);
        PngFile pngFileOut = new PngFile(dirOut + "C_" + imageFile);
        M2dDecart2dIntLinksToPngFile.transform(inputDataSensor.contourM2d, pngFileOut);
    }

    @Test
    public void refl() {
            Class[] algoClasses = Reflection.getAlgoClasses();
            for (Class cl: algoClasses) { System.out.println(cl.toString()); }
    }

    @Test
    public void serialize() {
//        AbstractData data = new AbstractData<String>("string version", "value");
//        AbstractData.getUniqueId().set(34);
//        FileOutputStream fos = null;
//        try {
//            fos = new FileOutputStream(dirOut + "test.json");
//            ObjectOutputStream oos = new ObjectOutputStream(fos);
//            // Method for serialization of B's class object
//            oos.writeObject(data);
//            // closing streams
//            oos.close();
//            fos.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //read
        Data data1 = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(dirOut + "test.json");
            ObjectInputStream ois = new ObjectInputStream(fis);
            // Method for de-serialization of B's class object
            data1 = (Data)ois.readObject();
            // closing streams
            ois.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void objToJson() {
        IAlgorithm algo = new AlgoTest();

        JSONObject object = new JSONObject();
        String value = algo.getClass().getPackage().getName();
        object.put("packege", value);
        FileWriter writer = null;
        try{
            writer = new FileWriter(dirOut + "test.json");

            writer.write(object.toJSONString());
            writer.flush();
            writer.close();
        }catch(IOException ex) {

        }
    }


}