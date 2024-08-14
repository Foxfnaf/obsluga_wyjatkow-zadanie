package org.example;

import java.io.File;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static final InputStream INPUT_STREAM = System.in;

    private static final Scanner INPUT_SCANNER = new Scanner(INPUT_STREAM);

    public static void main(final String[] args) throws IOException {
        String inputFileName;
        do {
            inputFileName = askUserForFileName(INPUT_SCANNER);
        } while (!checkIsFileExist(inputFileName));

        printFileContent(inputFileName);

        String additionalText = askUserForAdditionalText();

        String outputFileName = inputFileName;
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(outputFileName, true);
            fileWriter.write(additionalText);
        }finally {
            if(fileWriter != null) {
                fileWriter.close();
            }
        }
        printFileContent(outputFileName);
    }
    private static boolean checkIsFileExist(final String fileName){
        File inputFile = new File(fileName);
        boolean result = inputFile.exists();
        if(!result) {
            System.out.println("Podany plik ["+ inputFile +"] nie istnieje");
        }
        return result;
    }

    private static String askUserFor(final String question){
        System.out.println(question);

        return INPUT_SCANNER.nextLine();
    }

    private static String askUserForAdditionalText(){
        return askUserFor("Podaj tekst który chcesz wpisać(usunie to całą zawartość pliku)");
    }

    private static String askUserForFileName(final Scanner scanner){
        return askUserFor("Podaj ścieżkę pliku");
    }

    private static Boolean printFileContent(final String inputFileName){
        File inputFile = new File(inputFileName);
        Scanner fileScanner = null;

        try {
            fileScanner = new Scanner(inputFile);
        }catch (FileNotFoundException  | NullPointerException exception){
            System.out.println("Podany plik ["+ inputFile +"] nie istnieje");
            return false;
        }
        while (fileScanner.hasNext()){
            System.out.println(fileScanner.nextLine());
        }

        return true;
    }
}