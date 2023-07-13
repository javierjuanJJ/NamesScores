package org.example;

import org.example.NamesScores.NamesScores;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        try {
            System.out.println(NamesScores.namesScores("names.txt"));
        }
        catch (FileNotFoundException e) {
            System.err.println(FileNotFoundException.class.getName() + " " + e.getMessage());
        }
        catch (IOException e) {
            System.err.println(IOException.class.getName() + " " + e.getMessage());
        }
        catch (Exception e) {
            System.err.println(Exception.class.getName() + " " + e.getMessage());
        }
    }
}