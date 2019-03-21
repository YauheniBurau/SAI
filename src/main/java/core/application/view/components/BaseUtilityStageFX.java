package core.application.view.components;

import javafx.stage.Stage;

/**
 * Created by anonymous on 22.03.2019.
 */
public class BaseUtilityStageFX extends Stage implements IUtilityStageFX {

    @Override
    public void showUtilityStage() {
        if(!this.isShowing()) this.show();
    }

    @Override
    public void hideUtilityStage() {
        if(this.isShowing()) this.hide();
    }

}
