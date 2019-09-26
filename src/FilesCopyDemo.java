import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class FilesCopyDemo {

    public static void main(String[] args) {

        Path p = Paths.get("C:/Users/TRAIN/Downloads/Clayton Oracle Java programs/Java Programming 2019 Learner/gameData");
        Path p1 = Paths.get("scores");
        Path p2 = Paths.get("backup");
        Path p3 = Paths.get("Highscores.txt");

        //create path for the working directory
        Path woD = p.resolve(p1);
        //create path for the working file
        Path woF = p.resolve(p.resolve(p3));
        //create path for the backup directory
        Path buD = p.resolve(p2);
        //create path for the backup file
        Path buF = p.resolve(p2.resolve(p3));

        try {

            if (Files.exists(woF)) {

                if (Files.notExists((buD))) {

                    Files.createDirectories(buD);

                }//end create backup directory

                Files.copy(woF, buF, StandardCopyOption.REPLACE_EXISTING,
                        StandardCopyOption.COPY_ATTRIBUTES);

            }//end working files exists if

            if (Files.notExists(woD)) {

                Files.createDirectories(woD);

            }//end if

            if (Files.notExists(woF)) {

                Files.createFile(woF);

            }//end if

        }//end try

        catch (IOException ioe) {

            System.err.println(ioe);

        }//end catch

    }//end main

}//end class
