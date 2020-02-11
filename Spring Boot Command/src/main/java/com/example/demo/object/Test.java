package com.example.demo.object;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "test")
public class Test {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "value1")
    private String value1;

    @Column(name = "value2")
    private Integer value2;
}
