package com.example.jpa_entity_test.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "tag")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "shareable")
    private Boolean shareable;

    @Column(name = "views")
    private Integer views;


    @OneToMany(mappedBy = "tag", orphanRemoval = true)
    private List<CardTag> cardTags = new ArrayList<>();

    @OneToMany(mappedBy = "tag", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ddabong> ddabongs = new ArrayList<>();


    @Builder
    private Tag(String name, Boolean shareable, Integer views) {
        this.name = name;
        this.shareable = shareable;
        this.views = views;
    }
}