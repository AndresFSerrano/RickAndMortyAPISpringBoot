package com.dvp.rickandmorty.test.service;

import com.dvp.rickandmorty.test.Entity.ApiResponse;
import com.dvp.rickandmorty.test.Entity.Character;
import com.dvp.rickandmorty.test.Entity.CharacterApiResponse;
import com.dvp.rickandmorty.test.Entity.repository.CharacterRepository;
import com.dvp.rickandmorty.test.controller.exceptions.CharacterNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CharacterServiceImpl implements CharacterService{

    private final CharacterRepository characterRepository;
    private final RestTemplate restTemplate;

    @Value("${api.urlBase}")
    private String apiUrlBase;

    public CharacterServiceImpl(CharacterRepository characterRepository, RestTemplate restTemplate) {
        this.characterRepository = characterRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Character> fetchCharactersFromApi() {
        List<Character> characterList = new ArrayList<>();

        int pages = restTemplate.getForObject(apiUrlBase,ApiResponse.class).getInfo().getPages();
        int page = 1;

        while(page<pages){
            ApiResponse response = restTemplate.getForObject(apiUrlBase+"?page="+page, ApiResponse.class);
            page += 1;
            for (CharacterApiResponse apiData : response.getResults()) {
                Character character = new Character();
                character.setName(apiData.getName());
                character.setStatus(apiData.getStatus());
                character.setGender(apiData.getGender());
                character.setImage(apiData.getImage());
                character.setId(apiData.getId());
                characterList.add(character);
            }
           characterRepository.saveAll(characterList);
        }
        return characterRepository.findAll();
    }

    @Override
    public List<Character> getCharacterByName(String name) {
        return characterRepository.findByName(name);
    }

    @Override
    public Character saveCharacter(Character character)  {
        Character characterFound = characterRepository.findCharacterByName(character.getName());
        if(characterFound != null){
            throw new CharacterNotFoundException("Se encontró este personaje en la base de datos, no se puede agregar");
        }
        return characterRepository.save(character);
    }
}
