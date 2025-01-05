package com.fiap.springblog.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Artigo {
    @Id
    @EqualsAndHashCode.Include
    public String codigo;
    public String titulo;
    public LocalDateTime data;
    public String texto;
    public String url;
    public Integer status;

    @DBRef
    public Autor autor;
}
