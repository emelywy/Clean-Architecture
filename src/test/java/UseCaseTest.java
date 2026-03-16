import org.example.domain.entities.Order;
import org.example.infrastructure.InMemoryOrder;
import org.example.infrastructure.InMemoryProduct;
import org.example.usecase.CreateOrderUseCase;
import org.junit.Test;

import static org.junit.Assert.*;

public class UseCaseTest {

    @Test
    public void shouldCreateOrderSuccessfully() {

        InMemoryProduct productRepo = new InMemoryProduct();
        InMemoryOrder orderRepo = new InMemoryOrder();
        CreateOrderUseCase useCase = new CreateOrderUseCase(productRepo, orderRepo);
        Order order = useCase.createOrder(1,2);

        assertNotNull(order);
        assertEquals("Created", order.getStatus());
        assertEquals(2000.0, order.getTotalPrice(),0.001);

    }

    @Test
    public void shouldThrowExceptionWhenNotEnoughStock() {

        InMemoryProduct productRepo = new InMemoryProduct();
        InMemoryOrder orderRepo = new InMemoryOrder();
        CreateOrderUseCase useCase = new CreateOrderUseCase(productRepo, orderRepo);

        assertThrows(RuntimeException.class, () -> {

            useCase.createOrder(1,100);

        });
    }
    @Test
    public void shouldThrowExceptionWhenProductNotFound() {

        InMemoryProduct productRepo = new InMemoryProduct();
        InMemoryOrder orderRepo = new InMemoryOrder();
        CreateOrderUseCase useCase = new CreateOrderUseCase(productRepo, orderRepo);

        assertThrows(RuntimeException.class, () -> {

            useCase.createOrder(99,1);

        });
    }
}
