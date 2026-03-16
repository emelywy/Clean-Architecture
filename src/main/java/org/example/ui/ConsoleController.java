package org.example.ui;

import org.example.domain.entities.Order;
import org.example.usecase.CreateOrderUseCase;

import java.util.Scanner;

public class ConsoleController {

    private CreateOrderUseCase useCase;

    public ConsoleController(CreateOrderUseCase useCase) {
        this.useCase = useCase;
    }

    public void start() {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter product id: ");
            int productId = scanner.nextInt();

            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();

            Order order = useCase.createOrder(productId, quantity);

            System.out.println("\nOrder created!!!");
            System.out.println("Total price: " + order.getTotalPrice());
            System.out.println("Order status: " + order.getStatus());

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());

        }
    }
}
