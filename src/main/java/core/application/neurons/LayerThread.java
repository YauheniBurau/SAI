package core.application.neurons;

// TODO: remove later
/**
 * Created by anonymous on 14.02.2019.
 * the goal of thread is processing and recounting neurons in layer
 * accordingly signals
 */
public class LayerThread extends Thread {
    private ILayer layer;

    public LayerThread(ILayer layer) {
        this.layer = layer;
    }

    @Override
    public void run() {
        try{
            do {
                // get layer state. check layerState. run refreshing all neurons
                if(false){
                    // process all neuron in layer
                    // send signals to sub layers
                }else {
                    this.wait(1000);
                    System.out.println("layer:" + currentThread().getId());
                }
            }while(true); // untill get signal stop layer activity
        }catch(InterruptedException e){

        }

    }


}
