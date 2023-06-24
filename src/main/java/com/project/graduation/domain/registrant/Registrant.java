package com.project.graduation.domain.registrant;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity(name="registrant")
public class Registrant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="registrant_id")
    private Long id;

    private String user_id;

    private String name;

    private String file_name;


    @Builder
    public Registrant(Long hid, String user_id, String name, String file_name){
        this.id = id;
        this.user_id = user_id;
        this.name = name;
        this.file_name = file_name;
    }
}
