package com.functionize;

import com.functionize.client.PokeDexClient;
import com.functionize.proxy.PokeDexProxy;

import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main( String[] args ) {
        PokeDexClient client = new PokeDexProxy();

        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("limit", 100);
        queryParams.put("offset", 0);

        client.getPokemonList(queryParams);
        var response = client.getPokemonList(queryParams);

        response.results()
                .forEach(System.out::println);
    }
}
