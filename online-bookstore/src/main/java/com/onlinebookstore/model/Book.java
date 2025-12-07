package com.onlinebookstore.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@Entity
@Table(name = "books")
@SQLDelete(sql = "UPDATE books SET is_deleted = true WHERE id = ?")
@SQLRestriction("is_deleted = false")
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;

    @Column(nullable = false)
    private String slug;

    @Column(nullable = false)
    private String title;

    @ManyToMany
    @JoinTable(
            name = "books_authors",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private Set<Author> authors = new HashSet<>();

    @Column(name = "full_price", nullable = false)
    private BigDecimal fullPrice;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private BigDecimal rate;

    @Column(nullable = false)
    private String age;

    @ManyToMany
    @JoinTable(
            name = "books_genres",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private Set<Genre> genres = new HashSet<>();

    @Column(nullable = false)
    private int year;

    @Column(nullable = false)
    private String image;

    @Column(unique = true,nullable = false)
    private String isbn;

    @Column(name = "internal_code", unique = true, nullable = false)
    private String internalCode;

    @ManyToOne
    @JoinColumn(name = "publisher_id", nullable = false)
    private Publisher publisher;

    @Column(nullable = false)
    private String series;

    @Column(nullable = false)
    private String language;

    @Column(name = "cover_type", nullable = false)
    private String coverType;

    @Column(columnDefinition = "TINYINT")
    private boolean illustrations;

    @Column(nullable = false)
    private int pages;

    @Column(nullable = false)
    private String weight;

    @Column(name = "in_stock", nullable = false, columnDefinition = "TINYINT")
    private boolean inStock;

    private String description;

    @Column(name = "is_deleted", columnDefinition = "TINYINT", nullable = false)
    private boolean isDeleted = false;

    public enum Category {
        BOOK,
        EBOOK
    }
}
