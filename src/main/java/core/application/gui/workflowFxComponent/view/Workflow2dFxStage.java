package core.application.gui.workflowFxComponent.view;

import core.application.controller.StageController;
import core.application.gui.workflowFxComponent.binding.WorkflowFacade;
import core.application.gui.workflowFxComponent.io.WorkflowIO;
import core.application.gui.workflowFxComponent.model.*;
import core.application.view.builder.SceneFxBuilder;
import core.application.view.builder.StageFxBuilder;
import core.application.gui.zoomDrugScrollFxComponent.ZoomDrugScrollFx;
import core.application.view.factory.ContextMenuFxFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by anonymous on 03.04.2019
 * refactored to new version 30.06.2020
 */
public class Workflow2dFxStage extends Stage {
    private WorkflowFacade workflowFacade = null;

    public Workflow2dFxStage(Stage owner, WorkflowIO workflowIO) {
        this.workflowFacade = new WorkflowFacade(workflowIO);
        ZoomDrugScrollFx scrollPane = new ZoomDrugScrollFx(this.workflowFacade.getWorkflow2dFx());
        StageFxBuilder stg = new StageFxBuilder(this);
        SceneFxBuilder scene = new SceneFxBuilder().withRootAndSize(scrollPane, 1024, 640);
        stg.withScene(scene.build()).withTitle("Workflow")
                .withInitStyle(StageStyle.UNIFIED).withAlwaysOnTop(false)
                .withOwner(owner)
                .withModality(Modality.WINDOW_MODAL)
                .withOnCloseRequest( (e)-> StageController.hideStage(stg.build()) );
        stg.build().setOnShowing(e -> initialize());
    }

    public void initialize(){
        System.out.println("setOnShowing");
        this.workflowFacade.setCanvasSize(2000, 1500);
        Class<?> testClass = Workflow2dFxStage.class;
        Method method = null;
        try {
            method = testClass.getMethod("testMethod", String.class, int.class, double.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        WorkflowVertex wfv1 = WorkflowVertexFactory.vertexFromClassStaticMethod(200, 100, method);
        this.workflowFacade.addVertex(wfv1);
        WorkflowVertex wfv2 = WorkflowVertexFactory.vertexFromClassStaticMethod(400, 150, method);
        this.workflowFacade.addVertex(wfv2);
        WorkflowVertex wfv3 = WorkflowVertexFactory.vertexFromClassStaticMethod(600, 50, method);
        this.workflowFacade.addVertex(wfv3);

        WorkflowEdge wfe12 = new WorkflowEdge(
                wfv1.selectVertexConnects().iterator().next(),
                wfv2.selectVertexConnects().iterator().next());
        this.workflowFacade.addEdge(wfe12);
        WorkflowEdge wfe23 = new WorkflowEdge(
                wfv2.selectVertexConnects().iterator().next(),
                wfv3.selectVertexConnects().iterator().next());
        this.workflowFacade.addEdge(wfe23);
        WorkflowEdge wfe31 = new WorkflowEdge(
                wfv3.selectVertexConnects().iterator().next(),
                wfv1.selectVertexConnects().iterator().next());
        this.workflowFacade.addEdge(wfe31);

        // SET INPUTS CONNECTS VALUES
        VertexConnect[] connects = wfv1.selectVertexConnects(VertexConnectTypeEnum.IN);
        connects[0].setValue("hello");
        connects[1].setValue(24);
        connects[2].setValue(25.0);

        Object[] args = new Object[3];
        args[0] = connects[0].getValue();
        args[1] = connects[1].getValue();
        args[2] = connects[2].getValue();
        // EXECUTE VERTEX
        // SET OUTPUT CONNECT VALUE FROM EXECUTED METHOD
        VertexConnect outConnect = wfv1.selectVertexConnect(0, VertexConnectTypeEnum.OUT);

        try {
            outConnect.setValue( wfv1.getMethod().invoke(null, args) );
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        // S.OUT OUTPUT CONNECT VALUE
        System.out.println( outConnect.getValue() );

        System.out.println();
        // this.workflowFacade.saveAs(new File("D:\\temp\\scheme.wfm"));
        // this.workflowFacade.load(new File("D:\\temp\\scheme.wfm"));
    }

    public WorkflowFacade getWorkflowFacade() {
        return workflowFacade;
    }


    public static String testMethod(String val1, int val2, double val3){
        return val1.toString() + Integer.toString(val2) + Double.toString(val3);
    }

}

// TODO: remove later

//        .withTitle(file.getAbsolutePath())
//        .withInitStyle(StageStyle.UNIFIED);
//        this.setMinWidth(640);
//        this.setMinHeight(480);
//        this.toFront();
//        this.setIconified(false);
//        this.focusedProperty().addListener( e->app.setActiveWorkflowStageFX(this) );
