package core.old;

import core.application.algorithms.IAlgorithm;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.lang.reflect.Field;
import java.util.HashMap;

/**
 * Created by anonymous on 10.11.2018.
 */
public class ProcessFX extends GridPane {
    private Label labelType;
    private Label labelParams;
    private Label labelSubAlgo;
    private IAlgorithm algorithm;
    private ListView steps;
    private Field[] fields;
    private HashMap<Field, Label> textFieldLabels;
    private HashMap<Field, TextField> textFields;

    public ProcessFX(IAlgorithm algorithm) {
        // 1. define parameters and base values of UI component
        this.labelType = new Label(algorithm.getClass().getCanonicalName());
        this.labelType.setFont(Font.font(null, FontWeight.BOLD, 16));
        this.labelParams = new Label("Params");
        this.labelParams.setFont(Font.font(null, FontWeight.BOLD, 14));
        this.labelSubAlgo = new Label("SubAlgo");
        this.labelSubAlgo.setFont(Font.font(null, FontWeight.BOLD, 14));

        this.algorithm = algorithm;
        this.steps = new ListView();
        this.fields = algorithm.getClass().getDeclaredFields();
        this.textFieldLabels = new HashMap<>();
        this.textFields = new HashMap<>();

        // 2. Fill listVew this.steps
        // TODO:
        // fill ListView "steps"
//        try {
//            Field list = this.algorithm.getClass().getDeclaredField("algorithms");
//            (LinkedList<IAlgorithm>)list.get();
//        } catch (NoSuchFieldException e) {
//            // there is not class Algorithm extends BaseAlgorithm {
//            // public LinkedList<IAlgorithm>
//            // no need to fill "ListView steps"
//        }

        // 3. fill this.TextFields with  this.textFieldLabels for algorithm parameters
        Label l;
        TextField tf;
        int length = this.fields.length;
        for(int i =0;i<length; i++){
            l = new Label(fields[i].getName());
            tf = new TextField("TODO: getValue");
            this.textFieldLabels.put(this.fields[i], l);
            this.textFields.put(this.fields[i], tf);
        }

        // 4. put uiComponents to layout
        int iRow = 1;
        this.add(this.labelType, 0, iRow,2, 1);
        iRow+=1;
        this.add(this.labelParams, 0, iRow,2, 1);
        iRow+=1;

        for(int i=0;i<length; i++){
            l = this.textFieldLabels.get(this.fields[i]);
            tf = this.textFields.get(this.fields[i]);
            this.add(l, 0, iRow);
            this.add(tf, 1, iRow);
            iRow+=1;
        }
        this.add(this.labelSubAlgo, 0, iRow,2, 1); iRow+=1;
        // TODO: fill subAlgo

        // other visual settings
        this.setBorder( new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, new CornerRadii(1), BorderWidths.FULL)) );

        makeDraggable(this);
    }



    private void makeDraggable(Node node) {
        final Delta dragDelta = new Delta();

        node.setOnMouseEntered(me -> {
            if (!me.isPrimaryButtonDown()) {
                node.getScene().setCursor(Cursor.HAND);
            }
        });
        node.setOnMouseExited(me -> {
            if (!me.isPrimaryButtonDown()) {
                node.getScene().setCursor(Cursor.DEFAULT);
            }
        });
        node.setOnMousePressed(me -> {
            if (me.isPrimaryButtonDown()) {
                node.getScene().setCursor(Cursor.DEFAULT);
            }
            dragDelta.x = me.getX();
            dragDelta.y = me.getY();
            node.getScene().setCursor(Cursor.MOVE);
        });
        node.setOnMouseReleased(me -> {
            if (!me.isPrimaryButtonDown()) {
                node.getScene().setCursor(Cursor.DEFAULT);
            }
        });
        node.setOnMouseDragged(me -> {
            node.setLayoutX(node.getLayoutX() + me.getX() - dragDelta.x);
            node.setLayoutY(node.getLayoutY() + me.getY() - dragDelta.y);
        });
    }

    private class Delta {
        public double x;
        public double y;
    }

}
