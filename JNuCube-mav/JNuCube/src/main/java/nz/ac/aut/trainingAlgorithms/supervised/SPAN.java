/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nz.ac.aut.trainingAlgorithms.supervised;

import java.util.ArrayList;
import nz.ac.aut.data.DataSample;
import nz.ac.aut.data.SpatioTemporalData;
import nz.ac.aut.network.Network;
import nz.ac.aut.spikingNeurons.SpikingNeuron;
import nz.ac.aut.trainingAlgorithms.LearningAlgorithm;

/**
 *
 * @author Josafath Israel Espinosa Ramos
 */
public class SPAN extends LearningAlgorithm{

    @Override
    public void train(Network network, ArrayList<DataSample> trainingData) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateSynapticWeights(ArrayList<SpikingNeuron> firedNeurons, int elapsedTime) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void validate(Network network, SpatioTemporalData std) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void resetFieldsForTraining() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void resetFieldsForSample() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
