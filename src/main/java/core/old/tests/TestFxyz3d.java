package core.old.tests;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CullFace;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.fxyz3d.shapes.primitives.SpringMesh;
import org.fxyz3d.utils.CameraTransformer;

public class TestFxyz3d  extends Application {
    double x = 0, y = 0, z = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {
        PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.setNearClip(0.1);
        camera.setFarClip(10000.0);
        camera.setTranslateX(10);
        camera.setTranslateZ(-100);
        camera.setFieldOfView(20);

        CameraTransformer cameraTransform = new CameraTransformer();
        cameraTransform.getChildren().add(camera);
        cameraTransform.ry.setAngle(-30.0);
        cameraTransform.rx.setAngle(-15.0);

        SpringMesh spring = new SpringMesh(10, 2, 2, 8 * 2 * Math.PI, 200, 100, 0, 0);
        spring.setCullFace(CullFace.NONE);
        spring.setTextureModeVertices3D(1530, p -> p.f);

        Group group = new Group(cameraTransform, spring);
        Circle c = new Circle();
        c.setTranslateX(100);
        c.setTranslateY(100);
        c.setTranslateZ(500);
        c.setRadius(20);
        Text txt = new Text("hello");
        txt.setTranslateX(100);
        txt.setTranslateY(100);
        txt.setTranslateZ(500);
        Line l = new Line();

        group.getChildren().add( txt );

        Scene scene = new Scene(group, 600, 400, true, SceneAntialiasing.BALANCED);
        scene.setFill(Color.BISQUE);
        scene.setCamera(camera);

        primaryStage.setScene(scene);
        primaryStage.setTitle("FXyz3D Sample");
        this.addKeysToStage(primaryStage, cameraTransform);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void addKeysToStage(Stage stg, CameraTransformer cmr){
    // events
        stg.addEventFilter(KeyEvent.KEY_PRESSED, event ->{
        switch(event.getCode()) {
            case A:
                y-=10;
                break;
            case D:
                y+=10;
                break;
            case W:
                x-=10;
                break;
            case S:
                x+=10;
                break;
            case Q:
                z-=10;
                break;
            case E:
                z+=10;
                break;
        }
        cmr.setRotate(x, y, z);
        });
    }

}


//            case A: cmr.setRotate(-10, 0, 0); break;
//            case D: cmr.setRotate(+10, 0, 0); break;
//
//            case W: cmr.setRotate(0, +10, 0); break;
//            case S: cmr.setRotate(0, -10, 0); break;
//
//            case Q: cmr.setRotate(0, 0, +10); break;
//            case E: cmr.setRotate(0, 0, -10); break;

//            case F: this.translateCamera(-10, 0, 0); break;
//            case H: this.translateCamera(+10, 0, 0); break;
//
//            case T: this.translateCamera(0, +10, 0); break;
//            case G: this.translateCamera(0, -10, 0); break;
//
//            case R: this.translateCamera(0, 0, -10); break;
//            case Y: this.translateCamera(0, 0, +10); break;
//        }
