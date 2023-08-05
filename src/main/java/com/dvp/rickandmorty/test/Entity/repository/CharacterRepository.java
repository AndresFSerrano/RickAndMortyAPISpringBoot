package com.dvp.rickandmorty.test.Entity.repository;

import com.dvp.rickandmorty.test.Entity.Character;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CharacterRepository extends JpaRepository<Character,Long> {
    List<Character> findByName(String name);
    Character findCharacterByName(String name);

    @Query(value = "SELECT * FROM CHARACTER WHERE NAME = :name ORDER BY NAME /*#sort*/", nativeQuery = true)
    List<Character> readByNameAndSort(@Param("name") String name, @Param("sort") String sort);
    @Query(value = "SELECT * FROM CHARACTER WHERE GENDER = :gender ORDER BY GENDER /*#sort*/",nativeQuery = true)
    List<Character> findByGender(@Param("gender") String gender,@Param("sort") String sort);
    @Query(value = "SELECT * FROM CHARACTER WHERE STATUS = :status ORDER BY STATUS /*#sort*/",nativeQuery = true)
    List<Character> findByStatus(@Param("status") String status,@Param("sort") String sort);
}
