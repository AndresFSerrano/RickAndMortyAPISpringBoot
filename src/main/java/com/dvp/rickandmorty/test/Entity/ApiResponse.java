package com.dvp.rickandmorty.test.Entity;

import lombok.Data;

import java.util.List;

@Data
public class ApiResponse {

    private InfoApiResponse info;

    private List<CharacterApiResponse> results;
}
