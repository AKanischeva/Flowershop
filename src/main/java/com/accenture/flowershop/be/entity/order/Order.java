package com.accenture.flowershop.be.entity.order;

import com.accenture.flowershop.be.entity.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cust")
    @SequenceGenerator(name = "seq_cust", sequenceName = "seq_cust", allocationSize = 1)
    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    private Date createDate;
    @Getter
    @Setter
    private Date completeDate;

    @ManyToOne
    @JoinColumn(name = "ID")
    @Getter
    @Setter
    private User user;    //private Long userId
    @Getter
    @Setter
    private BigDecimal subTotal;

    public Order() {
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", createDate=" + createDate +
                ", completeDate=" + completeDate +
                ", user=" + user +
                ", subTotal=" + subTotal +
                '}';
    }

    private enum status {
        NEW,
        PAID,
        CLOSED
    }
}
