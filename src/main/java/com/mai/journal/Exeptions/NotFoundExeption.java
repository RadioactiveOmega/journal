package com.mai.journal.Exeptions;

public class NotFoundExeption extends RuntimeException{
    public  NotFoundExeption(String message){
        super(message);
    }
}
