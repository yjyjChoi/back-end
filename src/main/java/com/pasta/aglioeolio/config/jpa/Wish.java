package com.pasta.aglioeolio.config.jpa;

import com.pasta.aglioeolio.common.BaseTimeEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@DynamicInsert
@DynamicUpdate
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity(name = "wish")
public class Wish extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length=1000)
    private String content;

    private Integer round;

    @Column(name = "is_anonymous")
    private Boolean isAnonymous;

    @Column(name = "is_delyn")
    private Boolean isDelyn;

    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "solider_id")
    private Long soldierId;

}