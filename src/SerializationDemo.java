import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;

public class SerializationDemo {


    public static void main(String[] args) {

        Course course = new Course("Java Programming", "Oracle", "JP", 60);

        Path path = Paths.get("C:/Users/TRAIN/Downloads/Clayton Oracle Java programs/Java Programming 2019 Learner/details.ser");

        System.out.println(course);

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

    public static Course deSerializableData(Path path){

        try(FileInputStream fileIn = new FileInputStream(path.toString());
            ObjectInputStream objectIn = new ObjectInputStream(fileIn))
        {

            Course course = (Course) objectIn.readObject();
            return course;

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

        System.out.println("Deserialized Course Details...");
        System.out.println("Name     : " + course.getName());
        System.out.println("Type     : " + course.getType());
        System.out.println("Code     : " + course.getCourseCode());
        System.out.println("Pass Score     : " + course.getPassingScore());


    }//end displayData

}//end class
