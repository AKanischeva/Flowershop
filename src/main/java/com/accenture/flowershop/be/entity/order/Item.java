package com.accenture.flowershop.be.entity.order;

import com.accenture.flowershop.be.entity.flower.Flower;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;
    @ManyToOne
    @JoinColumn(name = "ORDERID")
    @Getter
    @Setter
    private Order order;
    @ManyToOne
    @JoinColumn(name = "FLOWERID")
    @Getter
    @Setter
    private Flower flower;
    @Getter
    @Setter
    private Integer amount;
    @Getter
    @Setter
    private BigDecimal cost;

    public Item(Flower flower, Integer amount) {
        this.flower = flower;
        this.amount = amount;
        cost = flower.getPrice().multiply(new BigDecimal(this.amount));
        BigDecimal a = cost;
    }

    public Item() {
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", order=" + order +
                ", flower=" + flower +
                ", amount=" + amount +
                '}';
    }
}
