/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.ac.aut.network.reservoirBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import nz.ac.aut.network.NetworkController;
import nz.ac.aut.spikingNeurons.SpikingNeuron;
import nz.ac.aut.util.Matrix;

/**
 * This interface is utilised for the algorithms that create the reservoir neurons. 
 * @author em9403
 */
public interface ReservoirBuilder {
    
    public static final MixReservoir MIX_RESERVOIR = new MixReservoir();
    public static final NeuCubeReservoir NEUCUBE_RESERVOIR = new NeuCubeReservoir();    
    public static final ArrayList<ReservoirBuilder> RESERVOIR_BUILDERS__LIST = new ArrayList<>(Arrays.asList(MIX_RESERVOIR, NEUCUBE_RESERVOIR));
      
    public ArrayList<SpikingNeuron> getReservoirNeurons(NetworkController networkController, Matrix reservoirCoordinates) throws CloneNotSupportedException;
}
