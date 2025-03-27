package com.functionize;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "pokedex-client", url = "https://pokeapi.co/api/v2")
public interface PokeDexClient {
    @GetMapping("/pokemon/")
    Map<String, Object> getPokemonList(@RequestParam("limit") int limit, @RequestParam("offset") int offset);
}
