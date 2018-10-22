package com.accenture.flowershop.be.entity.order;

import com.accenture.flowershop.be.entity.flower.Flower;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cust")
    @SequenceGenerator(name = "seq_cust", sequenceName = "seq_cust", allocationSize = 1)
    @Getter
    @Setter
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ORDERID")
    @Getter
    @Setter
    private Order order;    //private Long orderId;

    @ManyToOne
    @JoinColumn(name = "FLOWERID")
    @Getter
    @Setter
    private Flower flower;  //private Long flowerId;

    @Getter
    @Setter
    private int amount;

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
