package com.example.test.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name="table1")
public class TestBean {

    @Id
    @Column(name="idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="c_aes256")
    private String cAes256;

    @Column(name="c_base64")
    @JsonProperty("base64")
    private String cBase64;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getcAes256() {
        return cAes256;
    }

    public void setcAes256(String cAes256) {
        this.cAes256 = cAes256;
    }

    public String getcBase64() {
        return cBase64;
    }

    public void setcBase64(String cBase64) {
        this.cBase64 = cBase64;
    }
}
