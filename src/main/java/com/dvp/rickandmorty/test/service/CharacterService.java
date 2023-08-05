package com.dvp.rickandmorty.test.service;

import com.dvp.rickandmorty.test.Entity.Character;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CharacterService {

    List<Character> fetchCharactersFromApi();

    List<Character> getCharacterByName(String name);

    Character saveCharacter(Character character) ;

}
