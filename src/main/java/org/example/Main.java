package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Main {
    public static final InputStream INPUT_STREAM = System.in;
    public static final Scanner INPUT_USER_READER = new Scanner(INPUT_STREAM);

    public static void main(String[] args) throws  IOException {
        String filePath;

        filePath = askUserForFilePath(INPUT_USER_READER);

        checkIfFileExist(filePath);
        printFileContent(INPUT_USER_READER, filePath);
    }

    public static String askUserForFilePath(Scanner fileScanner) {
        System.out.println("Podaj scieżkę pliku");
        return fileScanner.nextLine();
    }

    public static boolean checkIfFileExist(String filePath) {
        File inputFile = new File(filePath);
        boolean result = inputFile.exists();
        return result;
    }

    public static boolean printFileContent(Scanner fileScanner, String filePath) {
        try {
            fileScanner = new Scanner(filePath);
        } catch (FileNotFoundException e) {
            System.out.println("Podany plik nie istnieje nie istnieje");
            return false;
        }
        while (fileScanner.hasNext()) {
            System.out.println(fileScanner.nextLine());
        }

        return true;
    }

}