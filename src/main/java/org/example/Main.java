package org.example;

public class Main {
    public static void main(String[] args) {

        try{
            FileManager.inputFile();
        }catch (NullPointerException exception){
            FileManager.inputFile();
        }
    }
}