package com.csv.api;

import java.io.*;

public class CustomFileWriter {
    String name;
    String path;
    String type;
    public FileWriter fileWriter;
    public BufferedReader fileReader;
    File file;


    public CustomFileWriter(String name, String path, String type) {
        this.name = name;
        this.path = path;
        this.type = type;
        file = new File(getFullPath());
    }

    public FileWriter getFileWriter() {

        if(fileWriter == null) {
            try {
                fileWriter = new FileWriter( getFullPath(),true); // FileWriter
            } catch (IOException e) {
                throw  new RuntimeException(e);
            }
        }

        return fileWriter;
    }

    public BufferedReader getFileReader(){
        if(fileReader == null) {
            try {
                fileReader = new BufferedReader(new FileReader(getFullPath())); // FileWriter
            } catch (IOException e) {
                throw  new RuntimeException(e);
            }
        }
        return fileReader;
    }

    public String readLine(){
        try {
            return getFileReader().readLine();
        } catch (IOException e) {
            throw  new RuntimeException(e);
        }
    }

    public boolean isFileExists(){
        return file.exists();
    }

    public void flushWriter(){
        try {
            getFileWriter().flush();
        } catch (IOException e) {
            throw  new RuntimeException(e);
        }

    }

    public  void  append(String row){
        try {
            getFileWriter().append(row);
            flushWriter();
        } catch (IOException e) {
            throw  new RuntimeException(e);
        }
    }
//    public File file;

//    File getFile(){
//        if(file == null)
//            file = new File(getFullPath());
//
//        return file;
//    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setType(String type) {
        this.type = type;
    }



    public String getFullPath(){

        return path+name+"."+type;
    }
}
