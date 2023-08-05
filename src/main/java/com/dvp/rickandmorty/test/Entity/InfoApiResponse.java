package com.dvp.rickandmorty.test.Entity;

import lombok.Data;

@Data
public class InfoApiResponse {
    private Integer count;
    private Integer pages;
    private String next;
    private String prev;
}
