package com.fiap.springblog.service.impl;

import com.fiap.springblog.model.Artigo;
import com.fiap.springblog.model.Autor;
import com.fiap.springblog.repository.ArtigoRepository;
import com.fiap.springblog.repository.AutorRepository;
import com.fiap.springblog.service.ArtigoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtigoServiceImpl implements ArtigoService {

    @Autowired
    private ArtigoRepository artigoRepository;
    private AutorRepository autorRepository;

    @Override
    public List<Artigo> obterTodos() {
        return this.artigoRepository.findAll();
    }

    @Override
    public Artigo obterPorCodigo(String codigo) {
        return this.artigoRepository
                .findById(codigo)
                .orElseThrow(()-> new IllegalArgumentException(("Artigo nao encontrado!")));
    }

    @Override
    public Artigo criar(Artigo artigo) {

        //se o autor existe
        if (artigo.getAutor().getCodigo() != null) {
            //recuperar o autor
            Autor autor = this.autorRepository.findById(artigo.getAutor().getCodigo())
                    .orElseThrow(()-> new IllegalArgumentException("Autor inexistente!!"));

            artigo.setAutor(autor);
        } else {
            // Se nao, nao atribuir o autor ao artigo
            artigo.setAutor(null);
        }

        //Salvo o artigo com o autor ja cadastrado
        return this.artigoRepository.save(artigo);
    }
}
