package com.dvp.rickandmorty.test.controller;

import com.dvp.rickandmorty.test.Entity.Character;
import com.dvp.rickandmorty.test.controller.exceptions.CharacterNotFoundException;
import com.dvp.rickandmorty.test.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<Character>> getAllCharactersFromApi() {
        return ResponseEntity.ok(characterService.fetchCharactersFromApi());
    }

    @PostMapping("/new")
    public ResponseEntity registrationService(@RequestBody Character character) {
        try {
            Character savedCharacter = characterService.saveCharacter(character);
            return ResponseEntity.ok(savedCharacter);
        } catch (CharacterNotFoundException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
    @GetMapping("/{name}")
    public ResponseEntity getCharacterByName(@PathVariable String name) {
        try{
            return ResponseEntity.ok(characterService.getCharacterByName(name));
        }catch (Exception e){
            return ResponseEntity.noContent().build();
        }
    }

}
