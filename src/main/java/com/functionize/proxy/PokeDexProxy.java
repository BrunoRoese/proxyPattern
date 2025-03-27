package com.functionize.proxy;

import com.functionize.client.PokeDexClient;
import com.functionize.model.PokemonListResponse;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

import java.util.Map;

public class PokeDexProxy implements PokeDexClient {

    private final PokeDexClient pokeDexClient;
    private PokemonListResponse pokemonListResponseCache;

    public PokeDexProxy() {
        this.pokeDexClient = Feign.builder()
                .decoder(new JacksonDecoder())
                .encoder(new JacksonEncoder())
                .target(PokeDexClient.class, "https://pokeapi.co/api/v2");
    }


    @Override
    public PokemonListResponse getPokemonList(Map<String, Object> queryMap) {
        if (pokemonListResponseCache == null) {
            System.out.println("Batendo na API para pegar os pokemons.");
            pokemonListResponseCache = pokeDexClient.getPokemonList(queryMap);
        } else {
            System.out.println("Pegando os pokemons cacheados.");
        }

        return pokemonListResponseCache;
    }
}
