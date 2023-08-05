package com.dvp.rickandmorty.test.Entity;

import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
public class CharacterApiResponse {

    private Long id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private Location origin;
    private Location location;
    private String image;
    private List<String> episode;
    private String url;
    private String created;

    @Data
    public static class Location {
        private String name;
        private String url;


    }
}
