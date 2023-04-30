package com.project.graduation.domain.registrant;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class Registrant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="registrant_id")
    private Long id;

    private Long user_id;

    private String name;

    private String file_id;


    @Builder
    public Registrant(Long id, Long user_id, String name, String file_id){
        this.id = id;
        this.user_id = user_id;
        this.name = name;
        this.file_id = file_id;
    }
}
