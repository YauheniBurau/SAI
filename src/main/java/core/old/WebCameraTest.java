package core.old;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.github.sarxos.webcam.WebcamUtils;
import com.github.sarxos.webcam.util.ImageUtils;
import org.junit.Test;

import javax.swing.*;

/**
 * Created by anonymous on 25.09.2016.
 */
public class WebCameraTest {

    public static void main(String[] args) throws InterruptedException {
        new WebCameraTest().windowWithCamData();
    }

    @Test
    public void saveCurrent(){
        Webcam webcam = Webcam.getDefault();
        webcam.open();
        // creates test1.bmp
        WebcamUtils.capture(webcam, "test1", ImageUtils.FORMAT_BMP);
        // creates test1.gif
        WebcamUtils.capture(webcam, "test1", ImageUtils.FORMAT_GIF);
        // creates test1.jpg
        WebcamUtils.capture(webcam, "test1", ImageUtils.FORMAT_JPG);
        // creates test1.png
        WebcamUtils.capture(webcam, "test1", ImageUtils.FORMAT_PNG);
        // creates test1.wbmp
        WebcamUtils.capture(webcam, "test1", ImageUtils.FORMAT_WBMP);
    }

    @Test
    public void windowWithCamData(){
        Webcam webcam = Webcam.getDefault();
        webcam.setViewSize(WebcamResolution.VGA.getSize());

        WebcamPanel panel = new WebcamPanel(webcam);
        panel.setFPSDisplayed(true);
        panel.setDisplayDebugInfo(true);
        panel.setImageSizeDisplayed(true);
        panel.setMirrored(true);

        JFrame window = new JFrame("Test webcam panel");
        window.add(panel);
        window.setResizable(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.pack();
        window.setVisible(true);
    }

}