package com.functionize.proxy;

import com.functionize.client.PokeDexClient;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PokeDexProxyTest {

    private final PokeDexClient pokeDexClient = new PokeDexProxy();
    private static final Map<String, Object> queryParams = new HashMap<>();

    @BeforeAll
    static void setUp() {
        queryParams.put("limit", 100);
        queryParams.put("offset", 0);
    }

    @Test
    void getNewPokemonList() {
        var response = pokeDexClient.getPokemonList(queryParams);

        assertNotNull(response);
        assertEquals(100, response.results().size());
    }

    @Test
    void getSamePokemonList() {
        var response = pokeDexClient.getPokemonList(queryParams);

        assertSame(response, pokeDexClient.getPokemonList(queryParams));
    }
}
