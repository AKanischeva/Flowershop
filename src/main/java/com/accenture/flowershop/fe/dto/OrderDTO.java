package com.accenture.flowershop.fe.dto;

import com.accenture.flowershop.be.entity.order.Item;
import com.accenture.flowershop.fe.enums.order.Status;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class OrderDTO {
    private int id;
    private int orderNum;
    private BigDecimal orderSubtotal;
    private List<Item> items;
    private Date orderDate;
    private Date orderCloseDate;
    private Status orderStatus;
}
