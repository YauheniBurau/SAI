package core.application.gui.workflowFxComponent.model;

import java.util.HashSet;

public class WorkflowModel {
    private HashSet<WorkflowVertex> vertexes = new HashSet<>();
    private HashSet<WorkflowEdge> edges = new HashSet<>();

    private int sizeX; // size X of canvas of workflow
    private int sizeY; // size Y of canvas of workflow

    public WorkflowModel() {

    }

    public int getSizeX() {
        return sizeX;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    public HashSet<WorkflowVertex> getVertexes() {
        return this.vertexes;
    }

    public HashSet<WorkflowEdge> getEdges() {
        return this.edges;
    }

    public void addVertex(WorkflowVertex v){
        this.vertexes.add(v);
    }

    public void addEdge(WorkflowEdge e){
        this.edges.add(e);
    }

    public void removeVertex(WorkflowVertex v){
        this.vertexes.remove(v);
    }

    public void removeEdge(WorkflowEdge e){
        this.edges.remove(e);
    }

    /**
     * merge all edges and vertexes from gModel into this graph
     * all loaded, new and deleted
     * @param gModel
     */
    public void merge(WorkflowModel gModel){
        this.vertexes.addAll(gModel.getVertexes());
        this.edges.addAll(gModel.getEdges());
    }

    public void clear(){
        this.edges.clear();
        this.vertexes.clear();
    }

}
