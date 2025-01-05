package com.fiap.springblog.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Autor {
    @Id
    public String codigo;
    public String nome;
    public String biografia;
    public String imagem;

    public String getCodigo() {
        return codigo;
    }
}
