package core.application.gui.workflowFxComponent.model;

import core.application.gui.workflowFxComponent.classLoader.ClassLoader;
import core.application.gui.workflowFxComponent.reflection.Reflections;
import javafx.scene.paint.Color;
import org.xeustechnologies.jcl.JarClassLoader;
import org.xeustechnologies.jcl.context.JclContext;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashSet;

public class WorkflowVertex implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name = "";
    private double nameRelativeX = 0.0;
    private double nameRelativeY = 0.0;

    private String algorithmName = "";
    private String algorithmDescription = "";
    private String fullClassName;
    private transient Method staticMethod;
    private SerializableMethod sStaticMethod;

    private transient Color backgroundColor = Color.BLACK;
    private SerializableColor sBackgroundColor;
    private ShapeSvgPathEnum shapeSvgPathEnum;
    private String shapeSvgPath = "";
    private double sizeX = 0;
    private double sizeY = 0;
    private double minSizeX = 0;
    private double minSizeY = 0;
    private double layoutX = 0;
    private double layoutY = 0;

    private HashSet<VertexConnect> connects = new HashSet<>();

    public WorkflowVertex() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getNameRelativeX() {
        return nameRelativeX;
    }

    public void setNameRelativeX(double nameRelativeX) {
        this.nameRelativeX = nameRelativeX;
    }

    public double getNameRelativeY() {
        return nameRelativeY;
    }

    public void setNameRelativeY(double nameRelativeY) {
        this.nameRelativeY = nameRelativeY;
    }

    public String getAlgorithmName() {
        return algorithmName;
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }

    public String getAlgorithmDescription() {
        return algorithmDescription;
    }

    public void setAlgorithmDescription(String algorithmDescription) {
        this.algorithmDescription = algorithmDescription;
    }

    public String getFullClassName() {
        return fullClassName;
    }

    public void setFullClassName(String fullClassName) {
        if(this.fullClassName != fullClassName && ClassLoader.isFoundClass(fullClassName)){
            this.fullClassName = fullClassName;
            this.setStaticMethod(fullClassName);
        }
    }

    public Method getStaticMethod() {
        if(this.staticMethod==null && this.sStaticMethod!=null){ this.staticMethod = this.sStaticMethod.getMethod();}
        return this.staticMethod;
    }

    public void setStaticMethod(Method method) {
        this.sStaticMethod = new SerializableMethod(method);
        this.staticMethod = method;
        // also from List<VertexConnect> from method and add all input and output params of method
        this.updateVertexConnects();
    }

    public void setStaticMethod(String fullClassName) {
        // also update StaticMethod
        Class<?> clazz = ClassLoader.loadClass(fullClassName);
        Collection<Method> sM = Reflections.getClassStaticMethods(clazz);
        if(sM.size()>0) {
            this.setStaticMethod(sM.iterator().next());
        }
    }

    public Color getBackgroundColor() {
        if(this.backgroundColor==null){ this.backgroundColor = this.sBackgroundColor.getColor();}
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        this.sBackgroundColor = new SerializableColor(backgroundColor);
    }

    public ShapeSvgPathEnum getShapeSvgPathEnum() {
        return shapeSvgPathEnum;
    }

    public void setShapeSvgPathEnum(ShapeSvgPathEnum shapeSvgPathEnum) {
        this.shapeSvgPathEnum = shapeSvgPathEnum;
        if(shapeSvgPathEnum!=ShapeSvgPathEnum.CUSTOM){
            this.setShapeSvgPath(shapeSvgPathEnum.value());
        }
    }

    public String getShapeSvgPath() {
        return shapeSvgPath;
    }

    public void setShapeSvgPath(String shapeSvgPath) {
        this.shapeSvgPath = shapeSvgPath;
    }

    public double getMinSizeX() {
        return minSizeX;
    }

    public void setMinSizeX(double minSizeX) {
        this.minSizeX = minSizeX;
    }

    public double getMinSizeY() {
        return minSizeY;
    }

    public void setMinSizeY(double minSizeY) {
        this.minSizeY = minSizeY;
    }

    public double getSizeX() {
        return sizeX;
    }

    public void setSizeX(double sizeX) {
        if(sizeX>=this.minSizeX) {
            this.sizeX = sizeX;
        }else{
            this.sizeX = this.minSizeX;
        }
    }

    public double getSizeY() {
        return sizeY;
    }

    public void setSizeY(double sizeY) {
        if(sizeY>=this.minSizeY) {
            this.sizeY = sizeY;
        }else{
            this.sizeY = this.minSizeY;
        }
    }

    public double getLayoutX() {
        return layoutX;
    }

    public void setLayoutX(double layoutX) {
        this.layoutX = layoutX;
    }

    public double getLayoutY() {
        return layoutY;
    }

    public void setLayoutY(double layoutY) {
        this.layoutY = layoutY;
    }

    public void setLayoutXY(double layoutX, double layoutY) {
        this.layoutX = layoutX;
        this.layoutY = layoutY;
    }

    public HashSet<VertexConnect> selectVertexConnects() {
        return connects;
    }

    public VertexConnect[] selectVertexConnects(VertexConnectTypeEnum type) {
        int size = this.countVertexConnects(type);
        VertexConnect[] connects = new VertexConnect[size];
        for (int i = 0; i<size; i++){
            connects[i] = this.selectVertexConnect(i, VertexConnectTypeEnum.IN);
        }
        return connects;
    }

    public void addVertexConnect(VertexConnect connect) {
        this.connects.add(connect);
        connect.setVertex(this);
    }

    /**
     * update all VertexConnects from vertex staticMethod
     */
    public void updateVertexConnects() {
        this.connects = new HashSet<>();
        if(this.getStaticMethod()!=null) {
            Class<?>[] parameterTypes = this.getStaticMethod().getParameterTypes();
            int size = parameterTypes.length;
            int n = 0;
            for (Class<?> paramType : parameterTypes) {
                this.addVertexConnect(VertexConnectFactory.newDefault(-1, -1 + (2 / (double) (size + 1)) * (n + 1), VertexConnectTypeEnum.IN, n, paramType, null));
                n += 1;
            }
            // OUTPUT CONNECT
            Class<?> retType = this.staticMethod.getReturnType();
            this.addVertexConnect(VertexConnectFactory.newDefault(+1, 0, VertexConnectTypeEnum.OUT, 0, retType, null));
        }
    }

    public VertexConnect selectVertexConnect(int number, VertexConnectTypeEnum type){
        VertexConnect vc = null;
        for (VertexConnect c: this.selectVertexConnects()) {
            if(c.getParamNumber()==number && c.getType()==type){
                vc = c;
                break;
            }
        }
        return vc;
    }

    private int countVertexConnects(VertexConnectTypeEnum type){
        int n = 0;
        for (VertexConnect c: this.selectVertexConnects()) {
            if(c.getType()==type){
                n+=1;
            }
        }
        return n;
    }
}

// TODO: remove later

//    private FileParam fileParam = FileParamFactory.fileDirectory();
//    public FileParam getFileParam() {
//        return fileParam;
//    }
//    public void setFileParam(FileParam fileParam) {
//        this.fileParam = fileParam;
//    }

//        this.propertySheet.setSearchBoxVisible(false);
//        this.propertySheet.setModeSwitcherVisible(false);

//    private transient AlgorithmStateEnum state = AlgorithmStateEnum.NOT_PROCESSED; // for storing state of algo node during processing all workflowModel
//    /**
//     * returb state of algo
//     * @return
//     */
//    public AlgorithmStateEnum getState() {
//        return state;
//    }
//
//    /**
//     * set state to algo node and for every output
//     * @param state
//     */
//    public void setState(AlgorithmStateEnum state) {
//        this.state = state;
//        for (Data output: this.getOutputs()) {
//            output.setState(state);
//        }
//    }
//
//    /**
//     * must be overriden, and have to contain main logic of processing inputs and what to send to outputs
//     * @return
//     */
//    public abstract Boolean onProcess();
//
//    /**
//     * check all inputs, and if at least one of them not has status "SUCCESS" - then result - false, algo is not ready
//     * @return
//     */
//    public boolean isReadyToProcess(){
//        boolean isReady = true;
//        for (Data input: this.getInputs()) {
//            if(input.getState()!=AlgorithmStateEnum.SUCCESS){
//                isReady = false;
//                break;
//            }
//        }
//        return isReady;
//    }

//    public void signalCountPrevious(){
//        for (Data input: this.inputs) {
//            if(input.getState()!=AlgorithmStateEnum.SUCCESS){
//                new RunProcess(input.getConnection(0).getStart().getAlgorithm()).run();
//            }
//        }
//    }
//
//    public void signalCountNext(){
//        for (Data output: this.outputs) {
//            ArrayList<IConnection> conns = output.getConnections();//. e.getEnd().getAlgorithm().runProcess();
//            for (int i = 0; i < conns.size() ; i++) {
//                new RunProcess(conns.get(i).getStart().getAlgorithm()).run();
//            }
//        }
//    }
//
//    public void runProcess(){
//        boolean result;
//        if( isReadyToProcess() == true ){
//            result = this.onProcess();
//            if(result == true){ // send to outputs signal that node is processed
//                this.setState(AlgorithmStateEnum.SUCCESS);
//                signalCountNext();
//            }
//        }else{ // send signals to all inputs connected nodes
//            signalCountPrevious();
//        }
//    }
