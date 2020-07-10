package core.application.gui.workflowFxComponent.model;

import javafx.scene.paint.Color;

import java.lang.reflect.Method;
import java.util.HashSet;


public class WorkflowVertex {
    private String name = "";
    private double nameRelativeX = 0;
    private double nameRelativeY = 0;

    private String algorithmName = "";
    private String algorithmDescription = "";
    private Method method;

    private Color backgroundColor = Color.BLACK;
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

    //==================================================================================================================
    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public String getSimpleClassName() {
        return method.getDeclaringClass().getSimpleName();
    }

    public String getStaticMethodName() {
        return this.method.getName();
    }

    public Class<?>[] _getParameterTypes() {
        return this.method.getParameterTypes();
    }

    public Class<?> getReturnType() {
        return this.method.getReturnType();
    }
    //==================================================================================================================

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
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
