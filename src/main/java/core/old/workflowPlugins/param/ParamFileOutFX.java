package core.old.workflowPlugins.param;

/**
 * Created by anonymous on 31.03.2019.
 */
//public class ParamFileOutFX  extends AbstractParamFX<Param<AFile>> {
//    private StringProperty textProperty = null;
//
//    public ParamFileOutFX(Param<AFile> paramFileOut) {
//        // 1. init
//        super(paramFileOut);
//        HBox hBox = new HBox();
//        Label label = new Label(this.getParam().getName());
//        TextField field = new TextField();
//        field.editableProperty().set(false);
//        ButtonFxBuilder btn = new ButtonFxBuilder().withText("...").withOnAction(hBtn);
//        hBox.getChildren().addAll(label, field, btn);
//        this.getChildren().add(hBox);
//        if(this.getParam().getValue()!=null) field.setText( this.getParam().getValue().getFile().getAbsolutePath() );
//        this.textProperty = field.textProperty();
//    }
//
//    /**
//     * EventHandler for btn.setOnAction - open dialog for choose save file
//     */
//    EventHandler<ActionEvent> hBtn = (e) -> {
//        AFile fileOut = this.getParam().getValue();
//        FileChooser fileChooser = HelperFX.createFileChooser(
//                fileOut.getFileChooserTitle(),
//                fileOut.getFileChooserInitialDirectory(),
//                fileOut.getFileChooserComment(),
//                fileOut.getExtensions());
//        File file = fileChooser.showSaveDialog(null);
//        if (file != null) this.getParam().getValue().setFile(file);
//        this.updateFromModel();
//    };
//
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
