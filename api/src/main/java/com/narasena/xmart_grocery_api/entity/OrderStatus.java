package com.narasena.xmart_grocery_api.entity;

import com.narasena.xmart_grocery_api.enums.OrderStatusType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;


@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "order_status")
@Data
public class OrderStatus extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @Enumerated(EnumType.STRING)
    private OrderStatusType status;

}