package com.dvp.rickandmorty.test.controller;

import com.dvp.rickandmorty.test.Entity.Character;
import com.dvp.rickandmorty.test.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/characters")
public class CharacterController {

    private final CharacterService characterService;

    @Autowired
    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }


    @GetMapping("/")
    public List<Character> getAllCharactersFromApi() {
        return characterService.fetchCharactersFromApi();
    }


}
