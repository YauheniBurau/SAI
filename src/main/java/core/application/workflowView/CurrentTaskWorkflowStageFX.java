package core.application.workflowView;

import core.application.view.components.GuiBuilderFX.ButtonFX;
import core.application.view.components.GuiBuilderFX.StageFX;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

import java.util.Date;
import java.util.logging.*;

public class CurrentTaskWorkflowStageFX extends StageFX {
    private WorkflowFX workflowFX;
    private Logger logger;
    private TextArea textArea;

    public CurrentTaskWorkflowStageFX(WorkflowFX workflowFX /*, Logger logger */) {
        this.workflowFX = workflowFX;
        this.logger = Logger.getLogger("test");
        this.logger.addHandler(new Handler() {
            Formatter formatter = new Formatter() {
                @Override
                public String format(LogRecord record) {
                    Date dat = new Date();
                    dat.setTime(record.getMillis());
                    String source = record.getLoggerName();
                    String message = formatMessage(record);
                    return new StringBuilder().append(dat).append(source).append(message).toString();
                }
            };

            @Override
            public void publish(LogRecord record) {
                Platform.runLater(() -> textArea.appendText(formatter.format(record)));
            }

            @Override
            public void flush() {}

            @Override
            public void close() {}
        });
        this.workflowFX.getWorkflow().setLogger(this.logger);
        init();
    }

    @Override
    public void init(){
        // control buttons
        ButtonFX btnStop = new ButtonFX()
                .withText("Stop")
                .withTooltip("interrupt all threads of processing current workflowModel")
                .withOnAction(hBtnStop);
        ButtonFX btnClose = new ButtonFX()
                .withText("Close")
                .withTooltip("interrupt all threads of processing current workflowModel and close window")
                .withOnAction(hBtnClose);
        HBox btnsBox = new HBox(btnStop, btnClose);
        btnsBox.setSpacing(5);
        btnsBox.setPadding(new Insets(10));
        // scrollPane + textArea for showing log of threadTask of workflowModel
        this.textArea = new TextArea();
        this.textArea.setPrefWidth(640);
        this.textArea.setPrefHeight(480);
        this.textArea.setEditable(false);
        // first pane
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10));
        root.setBottom(btnsBox);
        root.setCenter(textArea);
        // scene init
        this.withScene(root, 640, 480).withTitle("Processing log")
                .withInitStyle(StageStyle.DECORATED);
        // .withOwner(workflowFX.get) TODO: make on top
        this.setOnCloseRequest(hWindowClose);
    }

    /**
     * eventHandler for btnStop.setOnAction
     */
    private EventHandler<ActionEvent> hBtnStop = (e) -> {
        if(this.workflowFX.getCurrentTaskThreadWorkflowFX().isAlive()){
            this.workflowFX.getCurrentTaskThreadWorkflowFX().interrupt();
            this.logger.warning("Workflow process is interrupted by user\n");
        }else{
            this.logger.warning("Workflow process is already finished. No need for interruption by user\n");
        }
    };

    /**
     * eventHandler for btnClose.setOnAction
     */
    private EventHandler<ActionEvent> hBtnClose = (e) -> {
        if(this.workflowFX.getCurrentTaskThreadWorkflowFX().isAlive()){
            this.workflowFX.getCurrentTaskThreadWorkflowFX().interrupt();
            this.logger.warning("Workflow process is interrupted by user\n");
        }else{
            this.logger.warning("Workflow process is already finished. No need for interruption by user\n");
        }
        this.workflowFX.getWorkflow().setLogger(null);
        this.hide();
    };

    /**
     * eventHandler for btnClose.setOnAction
     */
    private EventHandler<WindowEvent> hWindowClose = (e) -> {
        if(this.workflowFX.getCurrentTaskThreadWorkflowFX().isAlive()){
            this.workflowFX.getCurrentTaskThreadWorkflowFX().interrupt();
        }else{
            this.logger.warning("Workflow process is already finished. No need for interruption by user\n");
        }
        this.workflowFX.getWorkflow().setLogger(null);
        //this.hide();
    };

}
