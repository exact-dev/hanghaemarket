package com.sparta.hanghaemarket.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "item")
// 테이블 이름은 @Table 작성 안해도 자동으로 item으로
// 생성 되겠지만 알아보기 쉽도록 @Table Annotation 명시
public class Item {

    // Item Entity의 PK 값
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 작성자
    @Column
    private String username;

    // 게시글 제목
    @Column
    private String title;

    // 게시글 내용
    // 게시글의 내용이므로 조금 많은 내용이 들어갈 수 있으므로
    // 자동으로 만들어 주는 default 값인 255보다 큰 3,000으로 세팅
    @Column(length = 3000)
    private String content;

    // 가격
    @Column
    private int price;

        public Item update(Item item) {
        this.username = item.getUsername();
        this.title = item.getTitle();
        this.content = item.getContent();
        this.price = item.getPrice();

        return this;
    }
}
