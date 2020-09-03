package com.javarush.task.task16.task1630;

import java.io.*;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут
    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException, IOException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        //add your code here - добавьте код тут
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent() throws IOException;

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут
    public static class ReadFileThread extends Thread implements ReadFileInterface{
        String filename;
        StringBuilder stringBuilder = new StringBuilder();
        String strCurrentLine;
        public String output = "";
        BufferedReader inputReader;

        @Override
        public void setFileName(String fullFileName) {
            filename = fullFileName;
        }

        @Override
        public String getFileContent() throws IOException {
            return output;
        }

        @Override
        public synchronized void start() {
            super.start();
        }

        @Override
        public void run() {
            try {
                inputReader = new BufferedReader(new FileReader(filename));
                while ((strCurrentLine = inputReader.readLine()) != null){
                    stringBuilder.append(strCurrentLine + " ");
                }
                inputReader.close();
                output = stringBuilder.toString();

                //System.out.println(output);
            } catch (IOException e) {
                System.out.println("ошибка");
            }
        }
    }
}
