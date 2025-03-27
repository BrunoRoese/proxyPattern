package com.functionize.client;

import com.functionize.model.PokemonListResponse;
import feign.QueryMap;
import feign.RequestLine;

import java.util.Map;

public interface PokeDexClient {
    @RequestLine("GET /pokemon/")
    PokemonListResponse getPokemonList(@QueryMap Map<String, Object> queryMap);
}
