package org.example.infrastructure;

import org.example.domain.entities.Product;
import org.example.domain.entities.repository.ProductRepository;

import java.util.HashMap;
import java.util.Map;

public class InMemoryProduct implements ProductRepository {

    private Map<Integer, Product> products = new HashMap<>();

    public InMemoryProduct() {

        products.put(1, new Product(1,"Laptop",1000,5));
        products.put(2, new Product(2,"Mouse",20,50));
        products.put(3, new Product(3,"Tablet",40,20));
        products.put(4, new Product(4,"Display",200,12));
        products.put(5, new Product(5,"Charger",10,200));
        products.put(6, new Product(6,"Phone",400,21));

    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

}
