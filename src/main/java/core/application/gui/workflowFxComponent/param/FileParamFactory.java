package core.application.gui.workflowFxComponent.param;

import java.io.File;

public class FileParamFactory {

    /**
     *
     * @return WFS - workflow scheme *.wfs
      */
    public static FileParam fileWFS(){
        return new FileParam()
                .setFile( new File(System.getProperty("user.home") + "\\file.wfs") )
                .setFileChooserTitle( "Select file *.wfs" )
                .setFileChooserInitialDirectory( new File(System.getProperty("user.home")) )
                .setFileChooserComment("select *.wfs")
                .setExtensions( new String[]{"*.wfs"} );
    }

    /**
     *
     * @return WFV - workflow scheme *.wfv
     */
    public static FileParam fileWFV(){
        return new FileParam()
                .setFile( new File(System.getProperty("user.home") + "\\file.wfv") )
                .setFileChooserTitle( "Select file *.wfv" )
                .setFileChooserInitialDirectory( new File(System.getProperty("user.home")) )
                .setFileChooserComment("select *.wfv")
                .setExtensions( new String[]{"*.wfv"} );
    }

    /**
     *
     * @return file - *.png *.bmp *.jpg
     */
    public static FileParam filePngBmpJpg(){
        return new FileParam()
            .setFile( new File(System.getProperty("user.home") + "\\Image.jpg") )
            .setFileChooserTitle( "Select file *.png *.bmp *.jpg" )
            .setFileChooserInitialDirectory( new File(System.getProperty("user.home")) )
            .setFileChooserComment("select *.png *.bmp *.jpg")
            .setExtensions( new String[]{"*.png", "*.bmp", "*.jpg"} );
    }

    /**
     *
     * @return file directory
     */
    public static FileParam fileDirectory(){
        return new FileParam()
                .setFile( new File(System.getProperty("user.home")) )
                .setFileChooserTitle( "Select Directory" )
                .setFileChooserInitialDirectory( new File(System.getProperty("user.home")) )
                .setFileChooserComment( "select Directory" )
                .setExtensions( new String[]{"."} );
    }

    /**
     *
     * @return file *.class java
     */
    public static FileParam fileClass(){
        return new FileParam()
                .setFile( new File(System.getProperty("user.home")) )
                .setFileChooserTitle( "Select file *.class" )
                .setFileChooserInitialDirectory( new File(System.getProperty("user.home")) )
                .setFileChooserComment( "Select file *.class" )
                .setExtensions( new String[]{"*.class"} );
    }

}
