package com.henry.musinsa.adapters.out.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Getter
@Entity
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users")
public class UserJPAEntity extends CommonEntity {

    @Id
    @SequenceGenerator(name = "user_id_seq_ge", sequenceName = "user_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq_ge")
    private Long id;

    @Comment("이름")
    @Column(name = "name")
    private String name;

    @Default
    @Comment("관리자계정 여부")
    @Column(name = "is_admin", nullable = false, columnDefinition = "boolean default false")
    private Boolean isAdmin = false;

    @Default
    @Comment("삭제 여부")
    @Column(name = "is_del", nullable = false, columnDefinition = "boolean default false")
    private Boolean isDel = false;
}
