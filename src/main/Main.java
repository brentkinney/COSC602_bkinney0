/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

//import collection.*;
import java.io.FileNotFoundException;
import project.*;
/**
 *
 * @author Bkinney0
 * @version 10/18/19
 */
public class Main {
    public static void main(String [] args) throws FileNotFoundException
    {
        try
        {
        Project3.test();
        }
        catch(FileNotFoundException exception){
            throw exception;
        }
    }
}
