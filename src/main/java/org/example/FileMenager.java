package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileMenager {

    private static final Scanner fileScanner= new Scanner(System.in);
    public static void inputFile() {
        String filePath = null;

        filePath = askUserForFilePath(filePath);
        readAnswer(fileScanner);

        try {
            checkIsFileExist(filePath);
        }catch (FileNotFoundException exception){
            System.out.println("Taki plik nie istnieje");
        }
    }

    public static void readAnswer(Scanner fileScanner) {
    }

    public static String askUserForFilePath(String filePath) {
        System.out.println("Podaj scieżkę pliku");

        return filePath;
    }

    public static Boolean checkIsFileExist(String filePath) throws FileNotFoundException{
        File inputFile = new File(filePath);
        boolean result = inputFile.exists();
        if (!result){
            throw new FileNotFoundException("File is don't exist");
        }

        return result;
    }
}
