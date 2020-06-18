package core.old;

//import com.github.sarxos.webcam.Webcam;
//import com.github.sarxos.webcam.WebcamPanel;
//import com.github.sarxos.webcam.WebcamResolution;
//import com.github.sarxos.webcam.WebcamUtils;
//import com.github.sarxos.webcam.util.ImageUtils;
import core.old.ftpStorage.FtpStorageClient;
//import org.apache.commons.cli.*;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.ftpserver.ftplet.FtpException;
import org.junit.Test;

/**
 * Created by anonymous on 08.10.2016.
 */
public class AI_Test {
    String dirIn = "D:\\temp\\in\\";
    String dirOut = "D:\\temp\\out\\";
    String imageFile = "star3.png";
    String edgesFile = "edges.edg";
    String vertexesFile = "vertexes.edg";
    String asciiFile = "ascii.txt";

//    char[] ascii = new String("Кластер (англ. cluster — скопление, кисть, рой) — объединение нескольких однородных элементов, которое может рассматриваться как самостоятельная единица, обладающая определёнными свойствами.\n" +
//            "\n" +
//            "В информационных технологиях:\n" +
//            "\n" +
//            "Кластер как подмножество результатов поиска, связанных единством темы;\n" +
//            "Кластер — единица хранения данных на гибких и жёстких дисках компьютеров;\n" +
//            "Кластер — группа компьютеров, объединённых высокоскоростными каналами связи и представляющая с точки зрения пользователя единый аппаратный ресурс;\n" +
//            "также — группа серверов, объединённых логически, способных обрабатывать идентичные запросы и использующихся как единый ресурс;\n" +
//            "Кластер — объект, обеспечивающий физически объединённое хранение данных из различных таблиц для ускорения выполнения сложных запросов, используемый в Oracle Database.\n" +
//            "В математике:\n" +
//            "\n" +
//            "Кластер — класс родственных элементов статистической совокупности.\n" +
//            "В астрономии:\n" +
//            "\n" +
//            "Звёздный кластер (звёздное скопление) — группа звёзд, связанных друг с другом силами гравитации;\n" +
//            "Галактический кластер — суперструктура, состоящая из нескольких галактик.").toCharArray();

    char[] ascii = new String("Кластер (англ. cluster").toCharArray();



    @Test
    public void ftpGetFileList() throws FtpException {
        String hostname = "localhost";
        int port = 2221;
        String user = "admin";
        String pass = "adminpass";
        FtpStorageClient client = new FtpStorageClient(hostname, port, user, pass);

        client.connect();

        FTPFile[] dirFiles = client.getFiles();
        for (FTPFile f: dirFiles) { System.out.println(f.getName()); }

        client.disconnect();
    }

//    @Test
//    public void externalize_graph_Edge(){
//        // prepare test data
//        Edge edge1 = new Edge<Integer>(24).seteId(1).setuId(2).setvId(3);
//        Edge edge2 = new Edge<String>("test").seteId(4).setuId(5).setvId(6);
//        Edge edge3 = new Edge<Double>(26.0).seteId(7).setuId(8).setvId(9);
//        // write
//        FileOutputStream fos = null;
//        ObjectOutputStream oos = null;
//        try {
//            // for writing or saving binary data
//            fos = new FileOutputStream(dirOut + edgesFile);
//            oos = new ObjectOutputStream(fos);
//            // writing or saving customer object's value to stream
//            oos.writeObject(edge1);
//            oos.writeObject(edge2);
//            oos.writeObject(edge3);
//            oos.flush();
//            oos.close();
//        }catch (IOException e) {
//            e.printStackTrace();
//        }
//        // read
//        FileInputStream fis = null;
//        ObjectInputStream ois = null;
//        try {
//            fis = new FileInputStream(dirOut + edgesFile);
//            ois = new ObjectInputStream(fis);
//            edge1 = (Edge) ois.readObject();
//            edge2 = (Edge) ois.readObject();
//            edge3 = (Edge) ois.readObject();
//            ois.close();
//        }catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        System.out.println(edge1 + "\n" + edge2 + "\n" + edge3);
//    }

//    @Test
//    public void externalize_graph_Vertex(){
//        // prepare test data
//        Vertex v1 = new Vertex<Integer>(24).setvId(1);
//        Vertex v2 = new Vertex<String>("test").setvId(2);
//        Vertex v3 = new Vertex<Double>(26.0).setvId(3);
//        // write
//        FileOutputStream fos = null;
//        ObjectOutputStream oos = null;
//        try {
//            // for writing or saving binary data
//            fos = new FileOutputStream(dirOut + vertexesFile);
//            oos = new ObjectOutputStream(fos);
//            // writing or saving customer object's value to stream
//            oos.writeObject(v1);
//            oos.writeObject(v2);
//            oos.writeObject(v3);
//            oos.flush();
//            oos.close();
//        }catch (IOException e) {
//            e.printStackTrace();
//        }
//        // read
//        FileInputStream fis = null;
//        ObjectInputStream ois = null;
//        try {
//            fis = new FileInputStream(dirOut + edgesFile);
//            ois = new ObjectInputStream(fis);
//            v1 = (Vertex) ois.readObject();
//            v2 = (Vertex) ois.readObject();
//            v3 = (Vertex) ois.readObject();
//            ois.close();
//        }catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        System.out.println(v1 + "\n" + v2 + "\n" + v3);
//    }

//    @Test
//    public void neo4j_RW(){
//        // run neo4j
//        GraphDatabaseService graphDb = startNeo4j( new File("pathtoConfig.cng"), new File("E:\\temp\\in\\") );
//        registerShutdownHook( graphDb );
//
//
//    }
//
//
//    private static void addVertex(GraphDatabaseService graphDb){
//        try ( Transaction tx = graphDb.beginTx() )
//        {
//            firstNode = graphDb.createNode();
//            firstNode.setProperty( "message", "Hello, " );
//            secondNode = graphDb.createNode();
//            secondNode.setProperty( "message", "World!" );
//
//            relationship = firstNode.createRelationshipTo( secondNode, RelTypes.KNOWS );
//            relationship.setProperty( "message", "brave Neo4j " );
//            // Database operations go here
//            tx.success();
//        }
//    }


    //    @Test
//    public void Png_Contour() {
//        PngFile pngFileIn = new PngFile(dirIn + imageFile);
//        Matrix2d<ARGB> m2dArgb = PngFileToM2dArgb.transform(pngFileIn);
//        Matrix2dByte m2dByte = M2dArgbToM2dByte256Colors.transform(m2dArgb);
//        InputDataSensor inputDataSensor = new InputDataSensor();
//        inputDataSensor.setInputM2d(m2dByte);
//        inputDataSensor.countContourM2d(400, 250);
//        PngFile pngFileOut = new PngFile(dirOut + "C_" + imageFile);
//        M2dDecart2dIntLinksToPngFile.transform(inputDataSensor.contourM2d, pngFileOut);
//    }

//    @Test
//    public void saveCurrent(){
//        Webcam webcam = Webcam.getDefault();
//        webcam.open();
//        // creates test1.bmp
//        WebcamUtils.capture(webcam, "test1", ImageUtils.FORMAT_BMP);
//        // creates test1.gif
//        WebcamUtils.capture(webcam, "test1", ImageUtils.FORMAT_GIF);
//        // creates test1.jpg
//        WebcamUtils.capture(webcam, "test1", ImageUtils.FORMAT_JPG);
//        // creates test1.png
//        WebcamUtils.capture(webcam, "test1", ImageUtils.FORMAT_PNG);
//        // creates test1.wbmp
//        WebcamUtils.capture(webcam, "test1", ImageUtils.FORMAT_WBMP);
//    }

//    @Test
//    public void windowWithCamData(){
//        Webcam webcam = Webcam.getDefault();
//        webcam.setViewSize(WebcamResolution.VGA.getSize());
//
//        WebcamPanel panel = new WebcamPanel(webcam);
//        panel.setFPSDisplayed(true);
//        panel.setDisplayDebugInfo(true);
//        panel.setImageSizeDisplayed(true);
//        panel.setMirrored(true);
//
//        JFrame window = new JFrame("Test webcam panel");
//        window.add(panel);
//        window.setResizable(true);
//        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        window.pack();
//        window.setVisible(true);
////    public static void main(String[] args) throws InterruptedException {
////        new WebCameraTest().windowWithCamData();
////    }
//    }

    public static void main ( String [] arguments ) {
//        // parse input parameters
//        Options options = new Options();
//        options.addRequiredOption("i", "in", true, "source in");
//        options.addRequiredOption("o", "out", true, "source out");
//        options.addRequiredOption("t", "transformPoints", true, "algorithm");
//        options.addOption("p1", true, "algorithm parameter1");
//        options.addOption("p2", true, "algorithm parameter2");
//        options.addOption("p3", true, "algorithm parameter3");
//        options.addOption("p4", true, "algorithm parameter4");
//        options.addOption("p5", true, "algorithm parameter5");
//        CommandLine commandLine;
//        CommandLineParser parser = new DefaultParser();
//        try {
//            commandLine = parser.parse(options, arguments);
//        } catch (ParseException e) {
//            throw new RuntimeException("Can't parse command line correctly", e);
//        }
//        String in = commandLine.getOptionValue("in");
//        String out = commandLine.getOptionValue("out");
//        String transform = commandLine.getOptionValue("transformPoints");
//        String p1 = commandLine.getOptionValue("p1");
//        String p2 = commandLine.getOptionValue("p2");
//        String p3 = commandLine.getOptionValue("p3");
//        String p4 = commandLine.getOptionValue("p4");
//        String p5 = commandLine.getOptionValue("p5");
    }

}