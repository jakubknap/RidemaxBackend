package pl.knap.shop.order.service.mapper;

import org.apache.commons.lang3.RandomStringUtils;
import pl.knap.shop.common.model.Cart;
import pl.knap.shop.common.model.CartItem;
import pl.knap.shop.order.model.Order;
import pl.knap.shop.order.model.OrderRow;
import pl.knap.shop.order.model.Payment;
import pl.knap.shop.order.model.Shipment;
import pl.knap.shop.order.model.dto.OrderDto;
import pl.knap.shop.order.model.dto.OrderSummary;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static java.math.BigDecimal.ZERO;
import static pl.knap.shop.common.model.OrderStatus.NEW;

public class OrderMapper {

    public static Order createNewOrder(OrderDto orderDto, Cart cart, Shipment shipment, Payment payment, Long userId) {
        return Order.builder()
                .firstname(orderDto.getFirstname())
                .lastname(orderDto.getLastname())
                .street(orderDto.getStreet())
                .zipcode(orderDto.getZipcode())
                .city(orderDto.getCity())
                .email(orderDto.getEmail())
                .phone(orderDto.getPhone())
                .placeDate(LocalDateTime.now())
                .orderStatus(NEW)
                .grossValue(calculateGrossValue(cart.getItems(), shipment))
                .payment(payment)
                .userId(userId)
                .orderHash(RandomStringUtils.randomAlphabetic(12))
                .build();
    }

    public static OrderSummary createOrderSummary(Payment payment, Order newOrder, String redirectUrl) {
        return OrderSummary.builder()
                .id(newOrder.getId())
                .placeDate(newOrder.getPlaceDate())
                .status(newOrder.getOrderStatus())
                .grossValue(newOrder.getGrossValue())
                .payment(payment)
                .redirectUrl(redirectUrl)
                .build();
    }

    public static OrderRow mapToOrderRowWithQuantity(Long orderId, CartItem cartItem) {
        return OrderRow.builder()
                .quantity(cartItem.getQuantity())
                .productId(cartItem.getProduct()
                        .getId())
                .price(cartItem.getProduct()
                        .getEndPrice())
                .orderId(orderId)
                .build();
    }

    public static OrderRow mapToOrderRow(Long orderId, Shipment shipment) {
        return OrderRow.builder()
                .quantity(1)
                .price(shipment.getPrice())
                .shipmentId(shipment.getId())
                .orderId(orderId)
                .build();
    }

    private static BigDecimal calculateGrossValue(List<CartItem> items, Shipment shipment) {
        return items.stream()
                .map(cartItem -> (cartItem.getProduct()
                        .getEndPrice())
                        .multiply(BigDecimal.valueOf(cartItem.getQuantity())))
                .reduce(BigDecimal::add)
                .orElse(ZERO)
                .add(shipment.getPrice());
    }
}