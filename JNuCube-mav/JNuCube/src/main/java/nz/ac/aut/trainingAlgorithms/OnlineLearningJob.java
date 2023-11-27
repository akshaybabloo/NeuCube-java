/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.ac.aut.trainingAlgorithms;

import java.util.Date;
import nz.ac.aut.data.DataSample;
import static nz.ac.aut.data.OnlineDataReaderJob.KEY_SPATIO_TEMPORAL_DATA;
import nz.ac.aut.data.SpatioTemporalData;
import nz.ac.aut.encodingAlgorithms.EncodingAlgorithm;
import nz.ac.aut.network.Network;
import nz.ac.aut.util.Matrix;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import static nz.ac.aut.log.Log.LOGGER;

/**
 *
 * @author em9403
 */
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class OnlineLearningJob implements Job {

    public static final String KEY_LEARNING_ALGORITHM = "KEY_LEARNING_ALGORITHM";
    public static final String KEY_ENCODING_ALGORITHM = "KEY_ENCODING_ALGORITHM";
    public static final String KEY_NETWORK = "KEY_NETWORK";
    public static final String KEY_FLAG = "KEY_FLAG";
    public static final String KEY_ELAPSED_TIME = "KEY_ELAPSED_TIME";

    //Logger LOGGER = LoggerFactory.getLogger(OnlineLearningJob.class);

    public OnlineLearningJob() {

    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDataMap map = context.getJobDetail().getJobDataMap();
        Network network = (Network) map.get(KEY_NETWORK);
        SpatioTemporalData std = (SpatioTemporalData) map.get(KEY_SPATIO_TEMPORAL_DATA);
        LearningAlgorithm learningAlgorithm = (LearningAlgorithm) map.get(KEY_LEARNING_ALGORITHM);
        EncodingAlgorithm encodingAlgorithm = (EncodingAlgorithm) map.get(KEY_ENCODING_ALGORITHM);
        boolean flag = map.getBoolean(KEY_FLAG);
        int elapsedTime = 0;

        if (std.getTrainingData().size() > 0 && flag == true) {
            LOGGER.info("---" + context.getJobDetail().getKey() + " executing.[" + new Date() + "] BUFFER SIZE " + std.getTrainingData().size() + " FLAG " + flag);
            flag = false;
            map.put(KEY_FLAG, flag);
            if (map.containsKey(KEY_ELAPSED_TIME)) {
                elapsedTime = map.getInt(KEY_ELAPSED_TIME);
            }
            LOGGER.debug("  -Encoding data ");
            DataSample sample = std.getTrainingData().get(0);
            Matrix matrix = new Matrix();
            double spikeData[][] = new double[sample.getNumRecords()][];
            for (int i = 0; i < sample.getNumRecords(); i++) {
                spikeData[i] = encodingAlgorithm.encode(sample.getData().getVecRow(i));
            }
            matrix.setData(spikeData);
            sample.setSpikeData(matrix);

            learningAlgorithm.setTrainingTime(elapsedTime);
            learningAlgorithm.train(network, std.getTrainingData());
            elapsedTime = learningAlgorithm.getTrainingTime();
            flag = true;
            map.put(KEY_FLAG, flag);
            map.put(KEY_ELAPSED_TIME, elapsedTime);
            LOGGER.info("  -" + context.getJobDetail().getKey() + " complete (" + elapsedTime + "). BUFFER SIZE " + std.getTrainingData().size());
        }

        
    }

}
