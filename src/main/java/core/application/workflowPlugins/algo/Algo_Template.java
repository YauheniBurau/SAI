package core.application.workflowPlugins.algo;

import core.application.workflowModel.*;
import core.application.workflowPlugins.data.DataTemplateFX;
import core.application.workflowPlugins.param.ParamTemplateFX;
import core.application.workflowPlugins.param.Template;
import java.io.Serializable;

/**
 * Algo Template
 * Created by anonymous on 30.03.2019.
 */
@Algo(name = "Algo name",
      description = "algo description",
      group = "template")
public class Algo_Template extends AbstractAlgorithm implements Serializable {

    @AlgoParam
    private Param<Template> paramTemplate1 = new Param<>("paramTemplate", new Template(), ParamTemplateFX.class);

    @AlgoDataIn
    private Data<Template> dataIn1 = new Data<>("TemplateIn", new Template(), this, DataTemplateFX.class);

    @AlgoDataOut
    private Data<Template> dataOut1 = new Data<>("TemplateOut", new Template(), this, DataTemplateFX.class);

    @Override
    public Boolean onProcess() {
        Boolean result = true;
        // get value for input. link to data from output Algo Previous -> input Algo Current
        Template in = dataIn1.getConnections().get(0).getStart().getValue();
        dataIn1.setValue(in);
        // count value for output
        Template out = new Template(in.value + paramTemplate1.getValue().value);
        dataOut1.setValue(out);
        return result;
    }

}
