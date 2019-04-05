package core.application.view.components.WorkFlowFX;

import core.application.workflow.workflow.Connection;
import javafx.beans.binding.DoubleBinding;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.effect.Bloom;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

import java.util.Optional;

/**
 * Created by anonymous on 25.03.2019.
 */
public class ConnectionFX extends Line implements IConnectionFX{
    private Connection connection;

    private OutputFX start = null;
    private InputFX end = null;
    private Circle end1 = null;
    private WorkflowFX workflowFX = null;

    private StartXBinding sX = null;
    private StartYBinding sY = null;
    private EndXBinding eX = null;
    private EndYBinding eY = null;
    private EndX1Binding eX1 = null;
    private EndY1Binding eY1 = null;

    public class StartXBinding extends DoubleBinding{
        public StartXBinding() {
            super.bind(start.getParent().getParent().layoutXProperty(),
                    start.getParent().layoutXProperty(),
                    start.layoutXProperty(),
                    start.getCircle().layoutXProperty(),
                    start.getCircle().translateXProperty(),
                    start.getCircle().centerXProperty());
        }

        @Override
        protected double computeValue() {
            return start.getParent().getParent().layoutXProperty().get() +
                    start.getParent().layoutXProperty().get() +
                    start.layoutXProperty().get() +
                    start.getCircle().layoutXProperty().get() +
                    start.getCircle().translateXProperty().get() +
                    start.getCircle().centerXProperty().get();
        }
    }

    public class StartYBinding extends DoubleBinding{
        public StartYBinding() {
            super.bind(start.getParent().getParent().layoutYProperty(),
                    start.getParent().layoutYProperty(),
                    start.layoutYProperty(),
                    start.getCircle().layoutYProperty(),
                    start.getCircle().translateYProperty(),
                    start.getCircle().centerYProperty());
        }

        @Override
        protected double computeValue() {
            return start.getParent().getParent().layoutYProperty().get() +
                    start.getParent().layoutYProperty().get() +
                    start.layoutYProperty().get() +
                    start.getCircle().layoutYProperty().get() +
                    start.getCircle().translateYProperty().get() +
                    start.getCircle().centerYProperty().get();
        }
    }

    public class EndXBinding extends DoubleBinding{
        public EndXBinding() {
            super.bind(end.getParent().getParent().layoutXProperty(),
                    end.getParent().layoutXProperty(),
                    end.layoutXProperty(),
                    end.getCircle().layoutXProperty(),
                    end.getCircle().translateXProperty(),
                    end.getCircle().centerXProperty());
        }

        @Override
        protected double computeValue() {
            return end.getParent().getParent().layoutXProperty().get() +
                    end.getParent().layoutXProperty().get() +
                    end.layoutXProperty().get() +
                    end.getCircle().layoutXProperty().get() +
                    end.getCircle().translateXProperty().get() +
                    end.getCircle().centerXProperty().get();
        }
    }

    public class EndYBinding extends DoubleBinding {
        public EndYBinding() {
            super.bind(end.getParent().getParent().layoutYProperty(),
                    end.getParent().layoutYProperty(),
                    end.layoutYProperty(),
                    end.getCircle().layoutYProperty(),
                    end.getCircle().translateYProperty(),
                    end.getCircle().centerYProperty());
        }

        @Override
        protected double computeValue() {
            return end.getParent().getParent().layoutYProperty().get() +
                    end.getParent().layoutYProperty().get() +
                    end.layoutYProperty().get() +
                    end.getCircle().layoutYProperty().get() +
                    end.getCircle().translateYProperty().get() +
                    end.getCircle().centerYProperty().get();
        }
    }

    public class EndX1Binding extends DoubleBinding{
        public EndX1Binding() { super.bind(end1.layoutXProperty(), end1.translateXProperty(), end1.centerXProperty());}

        @Override
        protected double computeValue() {
            return end1.layoutXProperty().get() + end1.translateXProperty().get() + end1.centerXProperty().get();
        }
    }

    public class EndY1Binding extends DoubleBinding {
        public EndY1Binding() { super.bind(end1.layoutYProperty(), end1.translateYProperty(), end1.centerYProperty()); }

        @Override
        protected double computeValue() {
            return end1.layoutYProperty().get() + end1.translateYProperty().get() + end1.centerYProperty().get();
        }
    }

    public ConnectionFX() {
        // TODO: move to init()
        this.setOnMouseEntered(hOnMouseEntered);
        this.setOnMouseExited(hOnMouseExited);
        this.setOnMousePressed(hOnMousePressed);
        this.setOnDragDone(hOnDragDone);
        // style
        this.setStrokeWidth(2);
    }

    public ConnectionFX(OutputFX start, InputFX end) {
        this.start = start;
        this.end = end;

        this.sX = new StartXBinding();
        this.sY = new StartYBinding();
        this.eX = new EndXBinding();
        this.eY = new EndYBinding();

        this.startXProperty().bind(this.sX);
        this.startYProperty().bind(this.sY);
        this.endXProperty().bind(this.eX);
        this.endYProperty().bind(this.eY);

        // TODO: move to init()
        this.connection = new Connection(start.getValue(), end.getValue());
        // add handlers for select delete connection
        this.setOnMouseEntered(hOnMouseEntered);
        this.setOnMouseExited(hOnMouseExited);
        this.setOnMousePressed(hOnMousePressed);
        // style
        this.setStrokeWidth(2);
    }

    @Override
    public void setWorkflowFX(WorkflowFX workflowFX) {
        this.workflowFX = workflowFX;
    }

    @Override
    public WorkflowFX getWorkflowFX() {
        return this.workflowFX;
    }

    @Override
    public Connection getConnection() {
        return connection;
    }

    @Override
    public void setConnection(Connection value) {
        this.connection = value;
    }

    public OutputFX getStart() {
        return start;
    }

    public void setStart(OutputFX start) {
        this.start = start;
        this.sX = new StartXBinding();
        this.sY = new StartYBinding();
        this.startXProperty().bind(this.sX);
        this.startYProperty().bind(this.sY);
    }

    public InputFX getEnd() {
        return end;
    }

    public void setEnd(InputFX end) {
        this.end = end;
        this.eX = new EndXBinding();
        this.eY = new EndYBinding();
        this.endXProperty().bind(this.eX);
        this.endYProperty().bind(this.eY);
        if( this.end1!=null){ this.end1.setVisible(false); }
    }

    public Circle getEnd1() {
        return end1;
    }

    public void setEnd1(Circle end1) {
        if(end1==null){
            this.end1 = null;
            this.eX1 = null;
            this.eY1 = null;
        }else{
            this.end1 = end1;
            this.eX1 = new EndX1Binding();
            this.eY1 = new EndY1Binding();
            this.endXProperty().bind(this.eX1);
            this.endYProperty().bind(this.eY1);
        }
        if( this.end1!=null){ this.end1.setVisible(true); }
    }

    /**
     * change Connection color if mouse on it
     */
    private EventHandler<MouseEvent> hOnMouseEntered = (e) -> {
        if (!e.isPrimaryButtonDown()) {
            Bloom bloom = new Bloom();
            bloom.setThreshold(2.0);
            this.setEffect(bloom);
            this.setStroke(Color.BLUE);
        }
    };

    /**
     * change change Connection color if mouse not on it
     */
    private EventHandler<MouseEvent> hOnMouseExited = (e) -> {
        if (!e.isPrimaryButtonDown()) {
            this.setEffect(null);
            this.setStroke(Color.BLACK);
        }
    };

    /**
     * on click show alert to choose delete on leave connection
     */
    private EventHandler<MouseEvent> hOnMousePressed = (e) -> {
        e.consume();
        this.setEffect(null);
        this.setStroke(Color.BLACK);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete connection from workflow");
        alert.setHeaderText("It will remove connection from Workflow");
        alert.setContentText("You can't discard that changes. Are you sure?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            this.getWorkflowFX().deleteConnectionFX(this);
        } else {
            // ... user chose CANCEL or closed the dialog
        }
    };

    /**
     * finish connectionFX for OutputFX and inputFX.
     * add ConnectionFX to WorkflowFX GUI
     * add Connection to Workflow Model
     */
    private EventHandler<DragEvent> hOnDragDone = (e) ->{
        WorkflowFX wfFX = this.getWorkflowFX();
        if(this.getEnd1()==null && this.getEnd()!=null){
            Connection conn = new Connection(start.getValue(), end.getValue());
            this.setConnection( conn );
            wfFX.getChildren().remove(this);
            wfFX.addConnectionFX(this);
            wfFX.getWorkflow().addConnection(conn);
        }else{
            wfFX.getChildren().remove(this.end1);
            wfFX.deleteConnectionFX( this );
        }
        wfFX.setTempConnectionFX(null);
        e.consume();
    };

}
