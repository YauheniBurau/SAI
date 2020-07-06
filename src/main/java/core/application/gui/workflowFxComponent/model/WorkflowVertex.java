package core.application.gui.workflowFxComponent.model;

import java.util.HashSet;

public class WorkflowVertex {
    private String name = "";
    private double nameRelativeX = 0;
    private double nameRelativeY = 0;

    private String algorithmName = "";

    private String algorithmDescription = "";

    private String classPath = "";

    private String backgroundColor = "";
    private String shape_svg_path = "";
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

    public String getClassPath() {
        return classPath;
    }

    public void setClassPath(String classPath) {
        this.classPath = classPath;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getShape_svg_path() {
        return shape_svg_path;
    }

    public void setShape_svg_path(String shape_svg_path) {
        this.shape_svg_path = shape_svg_path;
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

    public HashSet<VertexConnect> getConnects() {
        return connects;
    }

    public void addConnect(VertexConnect connect) {
        this.connects.add(connect);
        connect.setVertex(this);
    }

}



// TODO: remove later

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
