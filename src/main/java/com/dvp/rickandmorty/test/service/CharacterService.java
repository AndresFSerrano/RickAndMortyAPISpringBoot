package com.dvp.rickandmorty.test.service;
import com.dvp.rickandmorty.test.Entity.Character;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public interface CharacterService {

    //First requirement
    List<Character> fetchCharactersFromApi();

    //Second requirement
    Character saveCharacter(Character character) ;

    List<Character> getCharacterByName(String name);

    // Sorting by name
    List<Character> sortByStatus(String status, String sortingType);

    List<Character> sortByGender(String gender,String sortingType);

    List<Character> sortByName(String name,String sortingType);

}
