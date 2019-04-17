package core.application.workflowView;

import core.application.workflowController.WorkflowController;
import core.application.workflowModel.IConnection;
import javafx.beans.binding.DoubleBinding;
import javafx.event.EventHandler;
import javafx.scene.effect.Bloom;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

/**
 * Created by anonymous on 25.03.2019.
 */
public class ConnectionFX extends Line implements IConnectionFX{
    private IConnection connection = null;
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
        this.setOnMouseEntered(hOnMouseEntered);
        this.setOnMouseExited(hOnMouseExited);
        this.setOnMousePressed(hOnMousePressed);
        this.setOnDragDone(hOnDragDone);
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

    public OutputFX getStart() {
        return start;
    }

    public ConnectionFX setStart(OutputFX start) {
        this.start = start;
        start.addConnectionFX(this);
        this.sX = new StartXBinding();
        this.sY = new StartYBinding();
        this.startXProperty().bind(this.sX);
        this.startYProperty().bind(this.sY);
        return this;
    }

    public InputFX getEnd() {
        return end;
    }

    public ConnectionFX setEnd(InputFX end) {
        this.end = end;
        end.setConnectionFX(this);
        this.eX = new EndXBinding();
        this.eY = new EndYBinding();
        this.endXProperty().bind(this.eX);
        this.endYProperty().bind(this.eY);
        if( this.end1!=null){ this.end1.setVisible(false); }
        return this;
    }

    public Circle getEnd1() {
        return end1;
    }

    public ConnectionFX setEnd1(Circle end1) {
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
        return this;
    }

    public IConnection getConnection() {
        return connection;
    }

    public void setConnection(IConnection connection) {
        this.connection = connection;
    }

    // TODO: refactor and move into WorkflowController
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
        WorkflowController.showRemoveConnectionDialog(this.workflowFX.getStage(), this);
    };

    /**
     * finish connectionFX for OutputFX and inputFX.
     * add ConnectionFX to WorkflowFX GUI
     * add Connection to Workflow Model
     */
    private EventHandler<DragEvent> hOnDragDone = (e) ->{
        WorkflowFX wfFX = this.getWorkflowFX();
        if(this.getEnd1()==null && this.getEnd()!=null){
            ConnectionFX conn = new ConnectionFX().setStart(start).setEnd(end);
            WorkflowController.addConnection(wfFX.getStage(), conn);
        }
        wfFX.removeTempConnectionFX();
        e.consume();
    };



}
