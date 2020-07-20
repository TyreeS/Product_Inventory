/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tsmith
 */
public class InvalidNumberException extends Exception{
    
    public InvalidNumberException(){
        super("There are no items in the Inventory!");
    }
    
    public InvalidNumberException(String message){
        super(message);
    }
}
