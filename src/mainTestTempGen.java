import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class mainTestTempGen {
    public static void main(String[] args) {

        ArrayList<String> methodsList = new ArrayList<>();
        String testFileName;

        if (args.length == 0) {
            String fileNameUser;
            System.out.println("Enter the filename of file to process: ");
            Scanner input = new Scanner(System.in);
            fileNameUser = input.nextLine();
            testFileName = fileNameUser.substring(0, fileNameUser.indexOf('.')) + "Test.java";
            methodsList = readFile(fileNameUser);
            writeFile(testFileName, methodsList);
        } else {
            for (String fileName : args) {
                testFileName = fileName.substring(0, fileName.indexOf('.')) + "Test.java";
                methodsList = readFile(fileName);
                writeFile(testFileName, methodsList);
            }
        }
    }

    static ArrayList<String> readFile(String fileName) {
        ArrayList<String> methodNames = new ArrayList<>();
        int i = 0;
        try {
            File myFile = new File(fileName);
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                methodNames.add(myReader.nextLine());
            }
            System.out.printf("Method names successfully read from file %s.\n", myFile.getName());
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return methodNames;
    }

    static boolean createFile(String fileName) {

        try {
            File myFile = new File(fileName);
            if (myFile.createNewFile()) {
                System.out.printf("File %s successfully created.\n", myFile.getName());

            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return true;
    }

    static void writeFile(String fileName, ArrayList<String> methodNames) {
        String template = "import org.junit.jupiter.api.Test;\n"
                + "import static org.junit.jupiter.api.Assertions.*;\n\n"
                + "public class ";
        String className = fileName.substring(0, fileName.indexOf('.'));

        try {
            File newDir = new File("processing");
            boolean dirCreated = newDir.mkdir();
            fileName = "processing/" + fileName;
            FileWriter myFile = new FileWriter(fileName);
            myFile.write(template + className + "() {\n\n");
            for (String methodName : methodNames) {
                myFile.write("\t@Test\n\tvoid " + methodName + "() {\n\n\t}\n");
            }
            myFile.close();
            System.out.printf("Template %s successfully created.\n", fileName);
        } catch (IOException e) {
            System.out.printf("An error occurred.");
            e.printStackTrace();
        }
    }
}
