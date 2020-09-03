package com.javarush.task.task18.task1812;

/* 
Расширяем AmigoOutputStream
*/



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuestionFileOutputStream implements AmigoOutputStream {
    private AmigoOutputStream decorator;

    public QuestionFileOutputStream(AmigoOutputStream decorator) {
        this.decorator = decorator;
    }

    @Override
    public void flush() throws IOException {
        decorator.flush();
    }

    @Override
    public void write(int b) throws IOException {
        decorator.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        decorator.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        decorator.write(b, off, len);
    }

    @Override
    public void close() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        String strReader;

        if ((strReader = reader.readLine()) != null) {
            if (strReader.equals("Д")) {
                decorator.close();
            } else {
            }
        }
        reader.close();
    }
}

