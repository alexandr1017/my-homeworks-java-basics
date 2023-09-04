package ru.alexandr1017.model;

import lombok.Data;
import lombok.Generated;

import javax.persistence.*;
import javax.validation.Valid;

@Entity
@Data
@Table(name = "library")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Valid
    @Column(name = "title")
    private String title;

    @Valid
    @Column(name = "author")
    private String author;

    @Column(name = "count_pages")
    private Integer countOfPages;

    @Column(name = "public_year")
    private Integer publicationYear;

    @Column(name = "price")
    private Double price;

    @Column(name = "code_vendor")
    private String codeVendor;
}
