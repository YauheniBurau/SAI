package core.application.gui.workflowFxComponent.model;

import java.util.HashSet;

public class WorkflowVertex {
    public static String SHAPE_SVG_PATH_RECTANGLE = "'M 0 1 L 8 1 L 8 5 L 0 5 L 0 1'";
    public static String SHAPE_SVG_PATH_ANGLE_DIAGONAL_RECTANGLE = "'M 0 2 L 1 1 L 7 1 L 8 2 L 8 4 L 7 5 L 1 5 L 0 4 L 0 2'";
    public static String SHAPE_SVG_PATH_ANGLE_ROUNDED_RECTANGLE = "'M 0 2 Q 0 1 1 1 L 7 1 Q 8 1 8 2 L 8 4 Q 8 5 7 5 L 1 5 Q 0 5 0 4 L 0 2'";
    public static String SHAPE_SVG_PATH_ROMBIC_RECTANGLE = "'M 0 3 L 1 1 L 7 1 L 8 3 L 7 5 L 1 5 L 0 3'";
    public static String SHAPE_SVG_PATH_ROUNDED_RECTANGLE = "'M 20 10 L 60 10 A 5 5 0 1 1 60 50 L 20 50 A 5 5 0 1 1 20 10'";
    public static String SHAPE_SVG_PATH_OVAL = "'M 4 1 Q 6 1 6 3 Q 6 5 4 5 Q 2 5 2 3 Q 2 1 4 1'";
    public static String SHAPE_SVG_PATH_ROMB = "'M 4 1 L 8 3 L 4 5 L 0 3 L 4 1'";

    private String name;
    private String algorithmName;
    private String algorithmDescription;

    private HashSet<WorkflowVertexConnect> connects = new HashSet<>();


}

// TODO: remove later

//    private transient AlgorithmStateEnum state = AlgorithmStateEnum.NOT_PROCESSED; // for storing state of algo node during processing all workflowModel
//
//    /**
//     * get that "description" value from annotation @Algo
//     * @return
//     */
//    public String getName() {
//        Algo a = this.getClass().getAnnotation(Algo.class);
//        return a.name();
//    }
//
//    /**
//     * get that "description" value from annotation @Algo
//     * @return
//     */
//    public String getDescription() {
//        Algo a = this.getClass().getAnnotation(Algo.class);
//        return a.description();
//    }
//
//    /**
//     * get that "group" value from annotation @Algo
//     * @return
//     */
//    public String getGroup() {
//        Algo a = this.getClass().getAnnotation(Algo.class);
//        return a.group();
//    }
//
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
