package com.dvp.rickandmorty.test.controller.exceptions;

public class CharacterNotFoundException extends NullPointerException{

    public CharacterNotFoundException(String message){
        super(message);
    }
}
