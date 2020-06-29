package core.application.gui.graphFxComponent.view;

import com.orientechnologies.orient.core.record.OVertex;
import core.application.controller.StageController;
import core.application.gui.graphFxComponent.binding.GraphFacade;
import core.application.gui.graphFxComponent.model.GraphModel;
import core.application.gui.graphFxComponent.odb.GraphDb;
import core.application.gui.graphFxComponent.view.Graph2dFx;
import core.application.view.builder.BorderPaneFxBuilder;
import core.application.view.builder.SceneFxBuilder;
import core.application.view.builder.StageFxBuilder;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.apache.commons.lang.RandomStringUtils;

public class Graph2dFxStage extends Stage {
    private GraphFacade graphFacade = null;

    public Graph2dFxStage(Stage owner, GraphDb graphDb) {
        Graph2dFx graph2dFx = new Graph2dFx();
        GraphModel graphModel = new GraphModel();
        this.graphFacade = new GraphFacade(graph2dFx, graphModel, graphDb);
        StageFxBuilder stg = new StageFxBuilder(this);
        BorderPaneFxBuilder root = new BorderPaneFxBuilder("ViewRootPane"+ RandomStringUtils.random(1000));
        SceneFxBuilder scene = new SceneFxBuilder().withRootAndSize(root.build(), 1024, 640);
        stg.withScene(scene.build()).withTitle("Utility1 instruments")
                .withInitStyle(StageStyle.UNIFIED).withAlwaysOnTop(true)
                .withOwner(owner)
                .withOnCloseRequest( (e)-> StageController.hideStage(stg.build()) );
        root.build().getChildren().add(graph2dFx);
        graph2dFx.setTranslateX(520);
        graph2dFx.setTranslateY(340);
        stg.build().setOnShowing(e -> initialize());
        stg.build().setOnShown(e -> System.out.println("Set on shown"));
        stg.build().setOnHiding(e -> System.out.println("Set on hiding"));
        stg.build().setOnHidden(e -> System.out.println("Set on hidden"));
        stg.build().setOnCloseRequest(e -> System.out.println("Set on CloseReuest"));
    }

    public void initialize(){
        System.out.println("setOnShowing");
        //==============================================================================================================
//        String str = "dogs and cats live together.______________________________________________________________________" +
//                "jjdvnjs dsjvjn ssadjv sdvjsdv dakjsvnd vsdjvnv ajkj djv sdjnjkj4853 fhf adsv sdajv v jsdv jsnvjsdn vjnv" +
//                "jv djfnds jdjvfs vsdjvnjd valiewaf viae viejivj zxk iedij iwc zxc ;ovvj sjwe vsdjfoas;c wej jv sivj eij" +
//                "cjsdkv kekfjvd lvjsdlkjvievwvsdjv ewjv dsclzjiefj vfr4893 5694 g9df 9302 g00d ffvxclv vi03945034 r09 gf" +
//                "jjdvnjs dsjvjn ssadjv sdvjsdv dakjsvnd vsdjvnv ajkj djv sdjnjkj4853 fhf adsv sdajv v jsdv jsnvjsdn vjnv" +
//                "jv djfnds jdjvfs vsdjvnjd valiewaf viae viejivj zxk iedij iwc zxc ;ovvj sjwe vsdjfoas;c wej jv sivj eij" +
//                "cjsdkv kekfjvd lvjsdlkjvievwvsdjv ewjv dsclzjiefj vfr4893 5694 g9df 9302 g00d ffvxclv vi03945034 r09 gf" +
//                "jjdvnjs dsjvjn ssadjv sdvjsdv dakjsvnd vsdjvnv ajkj djv sdjnjkj4853 fhf adsv sdajv v jsdv jsnvjsdn vjnv" +
//                "jv djfnds jdjvfs vsdjvnjd valiewaf viae viejivj zxk iedij iwc zxc ;ovvj sjwe vsdjfoas;c wej jv sivj eij" +
//                "cjsdkv kekfjvd lvjsdlkjvievwvsdjv ewjv dsclzjiefj vfr4893 5694 g9df 9302 g00d ffvxclv vi03945034 r09 gf";
        String str = "dogs and cats live together.____";
        OVertex v = graphFacade.db_strToGraphDb(str);
        GraphModel gM = graphFacade.db_selectAllChildrenWithParent(v);
        graphFacade.m_merge(gM);
        graphFacade.fx_mapGraphModelIntoGraph2dFx();
        graphFacade.fx_orderVertexes2dFxInSphere(400);
        //==============================================================================================================
    }

}
