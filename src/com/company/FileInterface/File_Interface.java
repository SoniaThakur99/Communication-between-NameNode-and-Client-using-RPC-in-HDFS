package com.company.FileInterface;

import java.rmi.Remote;
import java.rmi.RemoteException;
public interface File_Interface extends Remote{
    public String createFile(String fileName) throws RemoteException;
    public String readFile(String fileName) throws RemoteException;
    public void writeFile(String fileName, String content) throws RemoteException;
    public void deleteFile(String fileName) throws RemoteException;
}
