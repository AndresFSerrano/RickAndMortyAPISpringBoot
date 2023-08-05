package com.dvp.rickandmorty.test.Entity.repository;

import com.dvp.rickandmorty.test.Entity.Character;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CharacterRepository extends JpaRepository<Character,Long> {
    List<Character> findByName(String name);
    Character findCharacterByName(String name);

}
