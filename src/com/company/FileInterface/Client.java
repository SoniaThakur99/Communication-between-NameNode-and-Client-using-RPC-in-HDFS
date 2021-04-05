package com.company.FileInterface;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.io.*;
public class Client {
    public static void main(String[] args) throws IOException{
        int cont =1;
        String fileName="";
        String content="";
        String path = "C:/Users/Dell_/Desktop/DCMINI/";
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        while(cont == 1 ) {
                System.out.println("Enter operation : 1 for create,\n 2 for read,\n 3 for write,\n 4 for delete ");
                int operation = Integer.parseInt(sc.readLine());
                System.out.println("Enter filename : ");
                fileName = sc.readLine();
                try {
                    Registry reg = LocateRegistry.getRegistry("localhost",3000);
                    switch(operation) {
                        case 1: {
                            File_Interface obj_create = (File_Interface) reg.lookup("create");
                            obj_create.createFile(fileName);
                            System.out.println("your file has been created");
                            break;
                        }
                        case 2: {
                            File_Interface obj_read = (File_Interface) reg.lookup("read");
                            content = obj_read.readFile(fileName);
                            System.out.println("Content:" + content);
                            break;
                        }
                        case 3: {
                            File_Interface obj_write = (File_Interface) reg.lookup("write");
                            System.out.println("Enter Content:");
                            content = sc.readLine();
                            obj_write.writeFile(fileName, content);
                            System.out.println("Successfully written");
                            break;
                        }
                        case 4: {
                            File_Interface obj_delete = (File_Interface) reg.lookup("delete");
                            obj_delete.deleteFile(fileName);
                            System.out.println("File deleted Successfully");
                            break;
                        }
                        default: {break;}
                    }
                }
                    catch (Exception e) {
                    System.out.println(e);
                    }
                System.out.println("Do you want to continue: 1 or 0");
                cont = Integer.parseInt(sc.readLine());
                System.out.flush();
        }
    }
}
