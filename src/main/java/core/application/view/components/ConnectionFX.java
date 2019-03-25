package core.application.view.components;

import javafx.beans.binding.DoubleBinding;
import javafx.scene.shape.Line;

/**
 * Created by anonymous on 25.03.2019.
 */
public class ConnectionFX extends Line {
    private OutputFX start = null;
    private InputFX end = null;

    private StartXBinding startX;
    private StartYBinding startY;
    private EndXBinding endX;
    private EndYBinding endY;

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


    public ConnectionFX(OutputFX start, InputFX end) {
        this.start = start;
        this.end = end;

        this.startX = new StartXBinding();
        this.startY = new StartYBinding();
        this.endX = new EndXBinding();
        this.endY = new EndYBinding();

        this.startXProperty().bind(this.startX);
        this.startYProperty().bind(this.startY);
        this.endXProperty().bind(this.endX);
        this.endYProperty().bind(this.endY);
    }

}
