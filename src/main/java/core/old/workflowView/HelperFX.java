package core.old.workflowView;


/**
 * Created by anonymous on 08.10.2018.
 */
public class HelperFX {
    // TODO: remove later or implement

//    /**
//     * create TextField JavaFX with TextFormatter only "double" values
//     * @return
//     */
//    public static TextField createDoubleTextField(){
//        TextField textField = new TextField();
//        Pattern validDoubleText = Pattern.compile("-?((\\d*)|(\\d+\\.\\d*))");
//        TextFormatter<Double> textFormatter = new TextFormatter<>(new DoubleStringConverter(), 0.0,
//                change -> {
//                    String newText = change.getControlNewText() ;
//                    if (validDoubleText.matcher(newText).matches()) {
//                        return change ;
//                    } else return null ;
//                });
//        textField.setTextFormatter(textFormatter);
//        return textField;
//        textFormatter.valueProperty().addListener((obs, oldValue, newValue) -> {
//            System.out.println("New double value "+newValue);
//        });
//
//    }

//    // TODO: make nodeFX draggable that way via dragboard
//    public static void makeNodeFxDraggable(WorkflowPaneFX workflowPaneFX, NodeFX nodeFX, javafx.scene.Node source) {
//
//        source.setOnDragDetected(new EventHandler<MouseEvent>() {
//            public void handle(MouseEvent event) {
//                /* drag was detected, start drag-and-drop gesture*/
//                System.out.println("onDragDetected");
//
//                /* allow any transfer mode */
//                Dragboard db = nodeFX.startDragAndDrop(TransferMode.ANY);
//
//                /* put a string on dragboard */
//                ClipboardContent content = new ClipboardContent();
//                //content.put(source.getText());
//                //db.setContent(content);
//                event.consume();
//            }
//        });

//        workflowPaneFX.setOnDragOver(new EventHandler<DragEvent>() {
//            public void handle(DragEvent event) {
//                /* data is dragged over the target */
//                System.out.println("onDragOver");

//                /* accept it only if it is  not dragged from the same node
//                 * and if it has a string data */
//                if (event.getGestureSource() != target &&
//                        event.getDragboard().hasString()) {
//                    /* allow for both copying and moving, whatever user chooses */
//                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
//                }
//                event.consume();
//            }
//        });

//        workflowPaneFX.setOnDragDropped(new EventHandler<DragEvent>() {
//            public void handle(DragEvent event) {
//                /* data dropped */
//                System.out.println("onDragDropped");
////                /* if there is a string data on dragboard, read it and use it */
////                Dragboard db = event.getDragboard();
//                boolean success = true;
////                if (db.hasString()) {
////                    target.setText(db.getString());
////                    success = true;
////                }
////                /* let the source know whether the string was successfully
////                 * transferred and used */
//                event.setDropCompleted(success);
//                event.consume();
//            }
//        });

//        nodeFX.setOnDragDone(new EventHandler<DragEvent>() {
//            public void handle(DragEvent event) {
//                /* the drag-and-drop gesture ended */
//                System.out.println("onDragDone");
//                /* if the data was successfully moved, clear it */
//                if (event.getTransferMode() == TransferMode.MOVE) {
//                    //source.setText("");
//                }
//                event.consume();
//            }
//        });
//    }
}

