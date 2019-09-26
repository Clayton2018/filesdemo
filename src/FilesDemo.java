import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.EmptyStackException;

public class FilesDemo {

    public static void main(String[] args) throws IOException {

        Path dirPath = Paths.get("C:/Users/TRAIN/Downloads/Clayton Oracle Java programs/Java Programming 2019 Learner/gameData");
        Path usersfilePath = Paths.get("Highscores.txt");
        Path settingsfilePath = Paths.get("Settings.txt");

        Path users, settings;
        users = checkFiles(dirPath, usersfilePath);
        settings = checkFiles(dirPath, settingsfilePath);

        if(users!=null) {

            displayFileStatus(users, settings);

        }//end if

        deleteFile(settings);

    }//end main

    public static Path checkFiles(Path dirPath, Path filePath){

        Path absPath = dirPath.resolve(filePath);

        try{

            if (Files.notExists(dirPath)) {
                Files.createDirectories(dirPath);
            }//end if

            if (Files.notExists(absPath)){
                Files.createFile(absPath);
            }//end if


        }//end try

        catch (IOException x){

            System.err.println(x);
            return null;

        }//end catch


        return absPath;

    }//end of check files

    public static void displayFileStatus(Path users, Path settings) throws IOException{

        System.out.println("Readable   :" + Files.isReadable(users));
        System.out.println("Writable   :" + Files.isWritable(users));
        System.out.println("Executable :" + Files.isExecutable(users));
        System.out.println("Hidden     :" + Files.isHidden(users));
        System.out.println("Same Files :" + Files.isSameFile(users, settings));


    }//end of displayFileStatus

    public static void deleteFile(Path filePath) {

        try{

            if(Files.exists(filePath)){

                Files.delete(filePath);
                System.out.println(filePath.toString() + " deleted!");

            }//end if

            else{

                System.out.println(filePath.toString()+ " not found!");

            }//end else

        }//end try

        catch (DirectoryNotEmptyException dne){

            System.err.println(dne);

        }//end DirectoryNotEmptyException

        catch (IOException ioe){

            System.err.println(ioe);

        }//end IOException




    }//end deleteFile

}//end of FilesDemo class
