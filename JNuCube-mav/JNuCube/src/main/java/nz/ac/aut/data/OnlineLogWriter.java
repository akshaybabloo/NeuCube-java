/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.ac.aut.data;

import static nz.ac.aut.log.Log.LOGGER;

/**
 *
 * @author Josafath Israel Espinosa Ramos
 */
public class OnlineLogWriter extends OnlineWriter {


    @Override
    public void setData(double value) {
        LOGGER.info("  -Writing to the online log output: "+value);   
    }

}
