package com.accenture.flowershop.be.entity.user;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    @NotEmpty
    private String username;
    @Getter
    @Setter
    @NotEmpty
    private String password;
    @Getter
    @Setter
    private String fullName;
    @Getter
    @Setter
    private String phone;
    @Getter
    @Setter
    private String address;
    @Getter
    @Setter
    private BigDecimal balance = new BigDecimal(2000);
    @Getter
    @Setter
    private Integer discount = 3;
    @Getter
    @Setter
    private boolean isAdmin;

    public User() {
    }

    public User(@NotEmpty String username, @NotEmpty String password, String fullName, String phone, String address) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.phone = phone;
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", phone=" + phone +
                ", address='" + address + '\'' +
                ", balance=" + balance +
                ", discount=" + discount +
                ", isAdmin=" + isAdmin +
                '}';
    }
}