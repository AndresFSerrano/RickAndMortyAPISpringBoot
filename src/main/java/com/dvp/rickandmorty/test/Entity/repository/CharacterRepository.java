package com.dvp.rickandmorty.test.Entity.repository;

import com.dvp.rickandmorty.test.Entity.Character;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<Character,Long> {


}
