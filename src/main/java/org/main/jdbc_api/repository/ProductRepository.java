package org.main.jdbc_api.repository;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {
    private final String scriptFileName = read("select.sql");
    private final NamedParameterJdbcTemplate template;
    private final ConcurrentHashMap<String, List<String>> products;

    public ProductRepository(NamedParameterJdbcTemplate template) {
        this.template = template;
        products = new ConcurrentHashMap<String, List<String>>();
    }

    public String getProductName(String name) {
        String n = name.toLowerCase();
        List<String> listOfThatPerson = new ArrayList<String>();
        if (products.keySet().contains(n)) {
            listOfThatPerson = products.get(n);
        } else {
            listOfThatPerson = template.queryForList(scriptFileName, Map.of("Name", n), String.class);
            products.put(n, listOfThatPerson);
        }
        return listOfThatPerson.toString();
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
