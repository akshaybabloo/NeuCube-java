package nz.ac.aut;

import nz.ac.aut.cube.NeuCubeController;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import nz.ac.aut.log.Log;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static {
        System.setProperty("log4j.configurationFile", String.valueOf(Objects.requireNonNull(Main.class.getResource("/log4j-configFile.xml"))));
    }

    public static void main(String[] args) {
        int argCount = args.length;

        Log.LOGGER.info("JNeuCube started");
        
        if (argCount == 3) {
            String dir = args[0];   // directory where the data set, mapping coordinates and input coordintes are located
            String propFileName = args[1];  // properties file that contains the configuration of the NeuCube
            int step = Integer.parseInt(args[2]);   // The step to be executed
            NeuCubeController project = new NeuCubeController();
            try {
                File file =new File(dir);
                if(file.isDirectory()){
                    project.createProject(dir);
                    if(project.configureNeuCube(propFileName)){
                        project.run(step);
                    }
                }
            } catch (IOException ex) {
                System.out.println("error");
            }
        } else {
            System.out.println("The number of arguments must be 3");
        }
    }
}