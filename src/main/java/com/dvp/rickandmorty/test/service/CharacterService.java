package com.dvp.rickandmorty.test.service;

import com.dvp.rickandmorty.test.Entity.Character;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CharacterService {

    List<Character> fetchCharactersFromApi();
    boolean isCharacterExistsInApi(String name);
    boolean isCharacterExistsInDatabase(String name);

}
