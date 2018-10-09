package core.old;

//import core.element.ElementImage;

/**
 * Created by anonymous on 03.03.2018.
 */
public class ImagesTest {
    String dirIn = "E:\\temp\\in\\";
    String dirOut = "E:\\temp\\out\\";
//    String imageFile = "alphabet_colors.png";
//    String imageFile = "A.png";
    String imageFile = "stown.png";

//    @Test
//    public void compareTextures() {
//        Matrix2dArgb in1 = Matrix2dArgb.load(dirIn + "stown.png");
//        Matrix2dArgb in2 = Matrix2dArgb.load(dirIn + "stown1.png");
//        Matrix2dArgb in3 = Matrix2dArgb.load(dirIn + "stown2.png");
//
//        Matrix2dHsv hsv1 = MatrixConverter.matrix2dArgbToMatrix2dHsv(in1);
//        Matrix2dHsv hsv2 = MatrixConverter.matrix2dArgbToMatrix2dHsv(in2);
//        Matrix2dHsv hsv3 = MatrixConverter.matrix2dArgbToMatrix2dHsv(in3);
//
//        Matrix2dByte b1 = MatrixConverter.matrix2dHsvToMatrix2dByteByValue(hsv1);
//        Matrix2dByte b2 = MatrixConverter.matrix2dHsvToMatrix2dByteByValue(hsv2);
//        Matrix2dByte b3 = MatrixConverter.matrix2dHsvToMatrix2dByteByValue(hsv3);
//
//        ElementImage img1 =  MatrixConverter.matrix2dByteToImage(b1);
//        ElementImage img2 =  MatrixConverter.matrix2dByteToImage(b2);
//        ElementImage img3 =  MatrixConverter.matrix2dByteToImage(b3);
//
//        double result1 = Comparator.compareImages(img1, img2, 10, 10);
//        double result2 = Comparator.compareImages(img1, img3, 10, 10);
//
//        System.out.println("img1 and img2 : " + result1);
//        System.out.println("img1 and img3 : " + result2);
//    }
//
//    @Test
//    public void findAllImagesAndSave() {
//        Matrix2dArgb in = Matrix2dArgb.load(dirIn + imageFile);
//        Matrix2dBoolean edge = in.edgeByColorDistance(16)
//                .save(dirOut + imageFile + "_edge.png", "png", TYPE_BYTE_GRAY);
//        ArrayList<ElementImage> images = edge.findAllShapeImages();
//
//        Matrix2dBoolean m2d;
//        int n = 0;
//        for(ElementImage img: images){
//            ++n;
//            m2d = MatrixConverter.imageToMatrix2dBoolean(img);
//            m2d.save(dirOut + imageFile + "_img" + n + ".png", "png", TYPE_BYTE_GRAY);
//        }
//    }


//    @Test
//    public void texture() {
//        Matrix2dArgb in = Matrix2dArgb.load(dirIn + imageFile);
//        Matrix2dBoolean edge = in.edgeByColorDistance(16).edge()
//                .save(dirOut + imageFile + "_edge.png", "png", TYPE_BYTE_GRAY);
//    }

//    @Test
//    public void saveTextureBooleanAsData() {
//        Matrix2dArgb in = Matrix2dArgb.load(dirIn + imageFile);
//        Matrix2dBoolean edge = in.edgeByColorDistance(16).edge()
//                .save(dirOut + imageFile + "_edge.png", "png", TYPE_BYTE_GRAY);
//
//        Point2d p = edge.countCenterOfSymmetry();
//        System.out.println("center symmetry: " + p.x + ", " + p.y );
//        int a = edge.countAngleAxisOfSymmetry(p);
//        System.out.println("a of axis of symmetry: " + a );
//
//        ElementImage image = MatrixConverter.matrix2dBooleanToImage(edge);
//        String id = "saveTextureBooleanAsData";
//        image.save(dirOut, id);
//
//        ElementImage loadedImage = image.load(dirOut, id);
//        Matrix2dBoolean m2d1 = MatrixConverter.imageToMatrix2dBoolean(loadedImage);
//        m2d1.save(dirOut + imageFile + "_img1.png", "png", TYPE_BYTE_GRAY);
//    }
//
//
//
//    @Test
//    public void findImageAndSaveAsData() {
//        Matrix2dArgb in = Matrix2dArgb.load(dirIn + "A.png");
//        Matrix2dBoolean edge = in.edgeByColorDistance(16)
//                .save(dirOut + imageFile + "_edge.png", "png", TYPE_BYTE_GRAY);
//
//        ElementImage image = edge.findShapeImage(60, 20);
//        Matrix2dBoolean m2d = MatrixConverter.imageToMatrix2dBoolean(image);
//        m2d.save(dirOut + imageFile + "_img1.png", "png", TYPE_BYTE_GRAY);
//
//        String id = "zxc43ed2";
//        image.save(dirOut, id);
//
//        ElementImage loadedImage = image.load(dirOut, id);
//        Matrix2dBoolean m2d1 = MatrixConverter.imageToMatrix2dBoolean(loadedImage);
//        m2d1.save(dirOut + imageFile + "_img2.png", "png", TYPE_BYTE_GRAY);
//    }
//
//
//    @Test
//    public void findImageAndSave() {
//        Matrix2dArgb in = Matrix2dArgb.load(dirIn + imageFile);
//        Matrix2dBoolean edge = in.edgeByColorDistance(16)
//                .save(dirOut + imageFile + "_edge.png", "png", TYPE_BYTE_GRAY);
//        ElementImage image = edge.findShapeImage(60, 20);
//        Matrix2dBoolean m2d = MatrixConverter.imageToMatrix2dBoolean(image);
//        m2d.save(dirOut + imageFile + "_img1.png", "png", TYPE_BYTE_GRAY);
//
//        ElementImage image1 = edge.findShapeImage(100, 20);
//        Matrix2dBoolean m2d1 = MatrixConverter.imageToMatrix2dBoolean(image1);
//        m2d1.save(dirOut + imageFile + "_img2.png", "png", TYPE_BYTE_GRAY);
//    }
//
//    @Test
//    public void findMostRelevantImageFromImages() {
//        Matrix2dArgb db = Matrix2dArgb.load(dirIn + imageFile);
//        Matrix2dBoolean edge = db.edgeByColorDistance(16)
//                .save(dirOut + imageFile + "_edgeDB.png", "png", TYPE_BYTE_GRAY);
//        ArrayList<ElementImage> images = edge.findAllShapeImages();
//
//        Matrix2dArgb m2d = Matrix2dArgb.load(dirIn + "A20.png");
//        edge = m2d.edgeByColorDistance(16)
//                .save(dirOut + imageFile + "_edgeIn.png", "png", TYPE_BYTE_GRAY);
//
//        ElementImage in = MatrixConverter.matrix2dBooleanToImage(edge);
//
//        double diff;
//        for(ElementImage img: images){
//            diff = Comparator.compareImages(img, in);
//            MatrixConverter.imageToMatrix2dBoolean(img)
//                .save(dirOut + imageFile + "_diff_" + diff + ".png", "png", TYPE_BYTE_GRAY);
//        }
//    }

//    @Test
//    public void findMostRelevantImageFromImagesByEpsilon() {
//        byte epsilon = 16;
//        Matrix2dArgb db = Matrix2dArgb.load(dirIn + imageFile);
//        Matrix2dBoolean edge = db.edgeByColorDistance(16)
//                .save(dirOut + imageFile + "_edgeDB.png", "png", TYPE_BYTE_GRAY);
//        ArrayList<ElementImage> images = edge.findAllShapeImages();
//
//        Matrix2dArgb m2d = Matrix2dArgb.load(dirIn + "y.png");
//        edge = m2d.edgeByColorDistance(16)
//                .save(dirOut + imageFile + "_edgeIn.png", "png", TYPE_BYTE_GRAY);
//
//        ElementImage in = MatrixConverter.matrix2dBooleanToImage(edge);
//
//        double diff;
//        for(ElementImage img: images){
//            diff = Comparator.compareImages(img, in, epsilon);
//            MatrixConverter.imageToMatrix2dBoolean(img)
//                    .save(dirOut + imageFile + "_diff_" + diff + ".png", "png", TYPE_BYTE_GRAY);
//        }
//    }
//


}
