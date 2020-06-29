package core.old.workflowView;

/**
 * Created by anonymous on 21.03.2019.
 */
//public class ParamFileInFX extends AbstractParamFX<Param<AFile>> {
//    private StringProperty textProperty = null;
//
//    public ParamFileInFX(Param<AFile> paramFileIn) {
////        // 1. init
////        super(paramFileIn);
////        HBox hBox = new HBox();
////        Label label = new Label(this.getParam().getName());
////        TextField field = new TextField();
////        field.editableProperty().set(false);
////        ButtonFxBuilder btn = new ButtonFxBuilder().withText("...").withOnAction(hBtn);
////        hBox.getChildren().addAll(label, field, btn);
////        this.getChildren().add(hBox);
////        if(this.getParam().getValue()!=null) field.setText( this.getParam().getValue().getFile().getAbsolutePath() );
////        this.textProperty = field.textProperty();
//    }
//
//    /**
//     * EventHandler for btn.setOnAction - open dialog for choose load file
//     */
//    EventHandler<ActionEvent> hBtn = (e) -> {
////        AFile fileIn = this.getParam().getValue();
////            FileChooser fileChooser = HelperFX.createFileChooser(
////                    "Select file: " + fileIn.getExtensions(),
////                    fileIn.getFileChooserInitialDirectory(),
////                    fileIn.getFileChooserComment(),
////                    fileIn.getExtensions());
////        File file = fileChooser.showOpenDialog(null);
////        if (file != null) this.getParam().getValue().setFile(file);
////        this.updateFromModel();
//    };
//
//    @Override
//    public void updateToModel() {
//        this.getParam().getValue().setFile( new File(this.textProperty.getValue()) );
//    }
//
//    @Override
//    public void updateFromModel() {
//        this.textProperty.setValue( this.getParam().getValue().getFile().getAbsolutePath() );
//    }
//
//}
