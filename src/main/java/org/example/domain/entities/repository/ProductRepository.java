package org.example.domain.entities.repository;

import org.example.domain.entities.Product;

public interface ProductRepository {

    Product findById(int id);

}
