package com.example.jpa_entity_test.repository;

import com.example.jpa_entity_test.entity.Card;
import com.example.jpa_entity_test.entity.CardTag;
import com.example.jpa_entity_test.entity.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.transaction.Transactional;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CardTagTest {

    @Autowired
    CardTagRepository cardTagRepository;

    @Test
    void cardTagCardRelationTest() {

        Card card = Card.builder()
                .title("hello")
                .content("world")
                .build();
        CardTag cardTag = CardTag.builder()
                .card(card)
                .build();

        cardTagRepository.save(cardTag);

        List<CardTag> cardTagList = cardTagRepository.findAllIncludesCard();
        assertThat(cardTagList.size()).isEqualTo(1);
        assertThat(cardTagList.get(0).getCard().getCardTags().get(0).getId()).isEqualTo(1);
    }

    @Test
    void cardTagTagRelationTest() {
        Tag tag = Tag.builder()
                .name("spring")
                .views(1000)
                .build();

        CardTag cardTag = CardTag.builder()
                .tag(tag)
                .build();

        cardTagRepository.save(cardTag);
        List<CardTag> cardTagList = cardTagRepository.findAllIncludesTag();
        assertThat(cardTagList.size()).isEqualTo(1);
        assertThat(cardTagList.get(0).getTag().getName()).isEqualTo("spring");
    }
}
