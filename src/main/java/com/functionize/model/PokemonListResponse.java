package com.functionize.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record PokemonListResponse(
        int count,
        String next,
        String previous,
        List<PokemonResponse> results
        ) {
}
