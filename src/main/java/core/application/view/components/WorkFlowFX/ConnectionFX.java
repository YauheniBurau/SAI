package core.application.view.components.WorkFlowFX;

import core.application.workflow.connection.Connection;
import javafx.beans.binding.DoubleBinding;
import javafx.scene.shape.Line;

/**
 * Created by anonymous on 25.03.2019.
 */
public class ConnectionFX extends Line implements IConnectionFX{
    private Connection connection;

    private OutputFX start = null;
    private InputFX end = null;
    private WorkflowPaneFX workflowPaneFX;

    private StartXBinding sX;
    private StartYBinding sY;
    private EndXBinding eX;
    private EndYBinding eY;

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

    public class EndYBinding extends DoubleBinding{
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

//    public ConnectionFX(Connection connection) {
//        this.init(connection);
//    }
//
//    private void init(Connection connection){
//        // TODO:
//
//    }

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
    }

    @Override
    public void setWorkflowPaneFX(WorkflowPaneFX workflowPaneFX) {
        this.workflowPaneFX = workflowPaneFX;
    }

    @Override
    public WorkflowPaneFX getWorkflowPaneFX() {
        return this.workflowPaneFX;
    }



}
