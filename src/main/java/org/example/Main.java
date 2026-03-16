package org.example;

import org.example.infrastructure.InMemoryOrder;
import org.example.infrastructure.InMemoryProduct;
import org.example.ui.ConsoleController;
import org.example.usecase.CreateOrderUseCase;

public class Main {
    public static void main(String[] args) {

        System.out.println("Online Store");

        InMemoryProduct productRepository = new InMemoryProduct();
        InMemoryOrder orderRepository = new InMemoryOrder();
        CreateOrderUseCase useCase = new CreateOrderUseCase(productRepository, orderRepository);
        ConsoleController controller = new ConsoleController(useCase);
        controller.start();

        System.out.println("Finished!!");
    }

    }
