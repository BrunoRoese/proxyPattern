package com.functionize;

import com.functionize.client.PokeDexClient;
import com.functionize.model.PokemonListResponse;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        PokeDexClient client = Feign.builder()
                .decoder(new JacksonDecoder())
                .encoder(new JacksonEncoder())
                .target(PokeDexClient.class, "https://pokeapi.co/api/v2");

        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("limit", 10);
        queryParams.put("offset", 0);

        PokemonListResponse response = client.getPokemonList(queryParams);

        response.results().forEach(pokemon ->
                System.out.println(pokemon.name() + " -> " + pokemon.url())
        );
    }
}
