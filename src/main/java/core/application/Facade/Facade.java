package core.application.Facade;

import core.application.model.Model;
import core.application.view.View;
import core.transformer.Transformation;
import core.transformer.Transformer;


/**
 * Created by anonymous on 08.10.2018.
 */
public class Facade {
    public Model model = new Model();
    public View view = new View();

    /**
     * folder
     * @param transformation
     */
    public void transform(Transformation transformation) {
        Transformer.transform(this.model, transformation);
    }

}
