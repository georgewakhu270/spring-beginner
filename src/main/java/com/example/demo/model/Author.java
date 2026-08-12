package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table( name = "authors")
public class Author {

    @Id
    @Column( name = "u_name")
    private String u_name;

    private String f_name;
    private String l_name;
    private String p_word;

    public Author() {
    }

    public Author(String u_name, String f_name, String l_name, String p_word) {
        this.u_name = u_name;
        this.f_name = f_name;
        this.l_name = l_name;
        this.p_word = p_word;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public String getP_word() {
        return p_word;
    }

    public void setP_word(String p_word) {
        this.p_word = p_word;
    }
}
