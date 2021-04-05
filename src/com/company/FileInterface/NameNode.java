package com.company.FileInterface;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class NameNode {
    public static void main(String[] args) throws Exception{
        try{
            HDFSFileSystem obj_create, obj_delete, obj_read,obj_write;
            Registry reg = LocateRegistry.createRegistry(3000);
            obj_create = new HDFSFileSystem();
            reg.rebind("create", obj_create);

            obj_read = new HDFSFileSystem();
            reg.rebind("read", obj_read);

            obj_write = new HDFSFileSystem();
            reg.rebind("write", obj_write);

            obj_delete = new HDFSFileSystem();
            reg.rebind("delete", obj_delete);

        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
