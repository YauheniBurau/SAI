package core.application.view.components.GuiBuilderFX;

/**
 * Created by anonymous on 28.03.2019.
 */
public interface IStageFX {
    /**
     * rebuild view of stage accordingly actual state of model data
     */
    void init();

    /**
     * use when you click button close and want send JavaFX values to bind Model bean objects
     */
    void send();
}
