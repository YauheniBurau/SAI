package core.application.gui.view.builder;

import core.application.gui.eventHandler.ControllerHandler;
import core.application.gui.view.View;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class StageFxBuilder extends AbstractBaseFxBuilder<Stage> {

    public StageFxBuilder(View ofx, String id) {
        this.view = ofx;
        this.value = new Stage();
        this.id = id;
        ofx.add(this.id, this.value);
    }

    public StageFxBuilder(View ofx, String id, Stage stg) {
        this.view = ofx;
        this.id = id;
        this.value = stg;
        ofx.add(this.id, this.value);
    }

    public StageFxBuilder withTitle(String title){
        this.value.setTitle(title);
        return this;
    }

    public StageFxBuilder withInitStyle(StageStyle stageStyle){
        if(this.value.getStyle()==null) {
            this.value.initStyle(stageStyle);
        }
        return this;
    }

    public StageFxBuilder withAlwaysOnTop(boolean value){
        this.value.setAlwaysOnTop(value);
        return this;
    }

    public StageFxBuilder withScene(SceneFxBuilder scene){
        this.value.setScene(scene.toScene());
        // this.getScene().getStylesheets().add(getClass().getResource("AI_Application.css").getFile() );
        // this.getScene().getStylesheets().add(getClass().getResource("AI_Application.css").toExternalForm());
        return this;
    }

    public StageFxBuilder withScene(Parent root, double width, double height){
        if(root == null){
            this.value.setScene( new Scene(new Pane(), width, height) );
        }else{
            this.value.setScene( new Scene(root, width, height) );
        }
        // this.getScene().getStylesheets().add(getClass().getResource("AI_Application.css").getFile() );
        // this.getScene().getStylesheets().add(getClass().getResource("AI_Application.css").toExternalForm());
        return this;
    }

    public StageFxBuilder withModality(Modality initModality){
        this.value.initModality(initModality);
        return this;
    }

    public StageFxBuilder withOwner(Stage owner){
        this.value.initOwner(owner);
        return this;
    }

    public StageFxBuilder withOnCloseRequest(ControllerHandler handler){
        this.value.setOnCloseRequest(handler);
        return this;
    }

    public StageFxBuilder setX(double value){
        this.value.setX(value);
        return this;
    }

    public StageFxBuilder setY(double value){
        this.value.setY(value);
        return this;
    }

    public void show(){
        this.value.show();
    }

}
