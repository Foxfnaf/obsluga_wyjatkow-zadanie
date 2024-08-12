package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.stream.Stream;

public class FileManager {

    public static final InputStream INPUT_STREAM = System.in;
    public static final Scanner fileScanner= new Scanner(INPUT_STREAM);
    public static void inputFile() {
        String filePath = "";

        filePath = askUserForFilePath(filePath, fileScanner);

        try {
            checkIfFileExist(filePath);
        }catch (FileNotFoundException exception){
            System.out.println("Taki plik nie istnieje");
        }
        printfileContent(fileScanner, filePath);
    }


    public static String askUserForFilePath(String filePath, Scanner fileScanner) {

        System.out.println("Podaj scieżkę pliku");
        filePath = fileScanner.nextLine();
        return filePath;
    }

    public static boolean checkIfFileExist(String filePath) throws FileNotFoundException{
        File inputFile = new File(filePath);
        boolean result = inputFile.exists();
        if (!result){
            throw new FileNotFoundException("File is don't exist");
        }
       return result;
    }

    public static boolean printfileContent(Scanner fileScanner, String filePath) {
        fileScanner = new Scanner(filePath);

        System.out.println(fileScanner.nextLine());
        while (fileScanner.hasNext()) {
            System.out.println(fileScanner.nextLine());
        }

        return true;
    }
}
