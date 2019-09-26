import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.util.Collections;

public class SerializationDemo {

    public static void main(String[] args) {

        Course course = new Course("Java Programming", "Oracle", "JP", 60);

    }//end main

    public static void serializeData(Course course, Path path){

        try( FileOutputStream fileOut = new FileOutputStream(path.toString());
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {

            objectOut.writeObject(course);
            System.out.println("Serialized data is saved in " + path.toString());

        }//end try

        catch(IOException ioe){

            ioe.printStackTrace();

        }//end catch

    }//end serializableData

    public static deSerializableData(Path path){

        try(){


        }//end try

        catch (ClassNotFoundException cnfe){

            System.out.println("Course class not found");
            return null;

        }//end ClassNotFoundException catch

        catch (IOException ioe){

            ioe.printStackTrace();
            return null;

        }//end IOException catch


    }//end deSerializable

    public static void displayData(Course course){



    }//end displayData

}//end class
