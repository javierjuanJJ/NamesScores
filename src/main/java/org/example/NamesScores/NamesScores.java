package org.example.NamesScores;

import java.io.*;

public class NamesScores {

    private static String readFile(File file) throws IOException {
        StringBuilder content = new StringBuilder();
        String lineFile = "";
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        while ((lineFile = bufferedReader.readLine()) != null){
            content.append(lineFile);
            content.append(System.lineSeparator());
        }


        return content.toString();
    }

    private static String[] sortArray(String[] array) {
        int lengthArray = array.length;
        int counterArray1 = 0;
        int counterArray2 = 0;

        String[] sortedArray = new String[lengthArray];


        for(counterArray1 = 0; counterArray1 < lengthArray; counterArray1++)
        {
            sortedArray[counterArray1] = array[counterArray1];
        }

        for(counterArray1 = 0; counterArray1 < lengthArray - 1; counterArray1++)
        {
            for (counterArray2 = counterArray1 + 1; counterArray2 < lengthArray; counterArray2++)
            {

                if(sortedArray[counterArray1].compareTo(sortedArray[counterArray2])>0)
                {

                    String temp = sortedArray[counterArray1];
                    sortedArray[counterArray1] = sortedArray[counterArray2];
                    sortedArray[counterArray2] = temp;
                }
            }
        }

        return sortedArray;


    }

    public static int namesScores(String filePath) throws IOException {
        int sum = 0;
        File file = new File(filePath);

        if (!file.exists()){
            throw new FileNotFoundException("File " + file.getAbsolutePath() + " not exists");
        }

        String[] namesArray = readFile(file).replace("\"", "").split(",");
        namesArray = sortArray(namesArray);


        for (int counter = 0; counter < namesArray.length; counter++) {
            sum += alphabetSumDigits((counter+1), namesArray[counter]);
        }

        return sum;
    }

    private static int alphabetSumDigits(int positionArray, String name) {
        int sum = 0;

        char[] charArray = name.toLowerCase().toCharArray();

        for (int counter = 0; counter < charArray.length; counter++) {
            sum += alphabetPosition(charArray[counter]);
        }

        sum *= positionArray;
        System.out.println("Name: " + name + " their sum is: " + sum);
        return sum;
    }

    private static int alphabetPosition(char letter) {
        char c;
        boolean isFound = false;
        int counter = 0;

        for(c = 'a'; c <= 'z' && !isFound; ++c){
            isFound = letter == c;
            counter++;
        }

        return counter;
    }


}
