package com.company.FileInterface;

// package FileInterface;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
public class HDFSFileSystem extends UnicastRemoteObject implements File_Interface{
    HDFSFileSystem() throws RemoteException{
        super();
    }

    public String path = "C:/Users/Dell_/Desktop/DCMINI/";
    @Override
    public String createFile(String fileName) throws RemoteException {
        try {
            File myObj = new File(path+fileName);
            System.out.println(path+fileName);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return ("File created at :" + path+ " " +fileName);
    }

    @Override
    public String readFile(String fileName) throws RemoteException {
        String content = "";
        try {
            File myObj = new File(path+fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                content+=data;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return "ddsdfsf";
        }
        return content;
    }

    @Override
    public void deleteFile(String fileName) throws RemoteException {
        File myObj = new File(path+fileName);
        if (myObj.delete()) {
            System.out.println("File deleted: " + myObj.getName());
        } else {
            System.out.println("File doesn't exists.");
        }
    }

    @Override
    public void writeFile(String fileName, String content) throws RemoteException {
        createFile(path+fileName);
        try {
            FileWriter myWriter = new FileWriter(path+fileName);
            myWriter.write(content);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
