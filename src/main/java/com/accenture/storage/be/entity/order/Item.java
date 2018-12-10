package com.accenture.storage.be.entity.order;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String student;
    private String theme;
    private String director;
    private String year1;
    private String faculty;
    private String description;
    private byte[ ] upload;
    private String filename;

    public Item() {
    }

    public Item(String student, String theme, String director, String year1, String faculty, String description, byte[ ] upload, String filename) {
        this.student = student;
        this.theme = theme;
        this.director = director;
        this.year1 = year1;
        this.faculty = faculty;
        this.description = description;
        this.upload = upload;
        this.filename = filename;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", student=" + student +
                ", theme=" + theme +
                ", director=" + director +
                ", year1=" + year1 +
                ", faculty=" + faculty +
                ", description=" + description +
                '}';
    }
}
