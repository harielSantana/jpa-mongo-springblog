package com.fiap.springblog.model;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class Artigo {
    @Id
    public String codigo;
    public String titulo;
    public LocalDateTime data;
    public String texto;
    public String url;
    public Integer status;

    @DBRef
    public Autor autor;

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}
