package com.example.jpa_entity_test.entity;

import lombok.*;

import javax.persistence.*;
import java.util.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "folder")
public class Folder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "folder_id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    ////********************연관 관게  ***************************/////

    // ***** 1 : N *****

    @OneToMany(mappedBy = "parent", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<Folder> children = new ArrayList<>();

    @OneToMany(mappedBy = "folder", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Card> cards = new ArrayList<>();

    // 해당 엔티티 기준으로 영속화시 연관관계 설정되어 있으면 전파함.
    // 또 영속화 할 필요가 없음
    // ***** N : 1 *****
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "parent_folder_id")
    private Folder parent;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "member_member_id")
    private Member member;




    // ***************** 생성자 ****************************
    @Builder
    private Folder(String name, Folder parent, Member member) {
        this.name = name;

        this.parent = parent;
        if (parent != null)
            parent.getChildren().add(this);

        this.member = member;
        if (member != null) {
            member.getFolders().add(this);
        }
    }
}