package com.hotsummer.luvme.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Result")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "result_id")
    private Integer resultId;
    @Column(name = "content", columnDefinition = "nvarchar(255)")
    private String content;
    @Column(name = "image")
    private String image;

    @OneToMany(mappedBy = "result", cascade = CascadeType.ALL)
    private List<Answer> answers;
}
