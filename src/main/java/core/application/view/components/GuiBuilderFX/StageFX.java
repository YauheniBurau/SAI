package core.application.view.components.GuiBuilderFX;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Created by anonymous on 28.03.2019.
 */
public class StageFX extends Stage implements IStageFX{

    /**
     * empty, implement for creating
     */
    @Override
    public void init(){
    }

    public StageFX withTitle(String title){
        this.setTitle(title);
        return this;
    }

    public StageFX withInitStyle(StageStyle stageStyle){
        if(this.getStyle()==null) {
            this.initStyle(stageStyle);
        }
        return this;
    }

    public StageFX withAlwaysOnTop(boolean value){
        this.setAlwaysOnTop(value);
        return this;
    }

    public StageFX withScene(Parent root, double width, double height){
        if(root == null){
            this.setScene( new Scene(new Pane(), width, height) );
        }else{
            this.setScene( new Scene(root, width, height) );
        }
        return this;
    }

    public StageFX withModality(Modality initModality){
        this.initModality(initModality);
        return this;
    }

    public StageFX withOwner(Stage owner){
        this.initOwner(owner);
        return this;
    }
}
