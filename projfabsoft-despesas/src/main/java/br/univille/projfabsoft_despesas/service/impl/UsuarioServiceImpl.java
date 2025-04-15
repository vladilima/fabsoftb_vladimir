package br.univille.projfabsoft_despesas.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projfabsoft_despesas.entity.Usuario;
import br.univille.projfabsoft_despesas.repository.UsuarioRepository;
import br.univille.projfabsoft_despesas.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {


    @Autowired
    private UsuarioRepository repository;

    @Override
    public Usuario save(Usuario usuario) {
        repository.save(usuario);
        return usuario;
    }

    @Override
    public List<Usuario> getAll() {
        return repository.findAll();
    }

    @Override
    public Usuario getById(long id) {
        var retorno = repository.findById(id);
        if(retorno.isPresent())
            return retorno.get();
        return null;
    }

    @Override
    public Usuario delete(long id) {
        var usuario = getById(id);
        if(usuario != null)
            repository.deleteById(id);
        return usuario;
    }

}
