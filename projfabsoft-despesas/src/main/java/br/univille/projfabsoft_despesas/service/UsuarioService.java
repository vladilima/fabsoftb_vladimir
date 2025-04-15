package br.univille.projfabsoft_despesas.service;

import java.util.List;

import br.univille.projfabsoft_despesas.entity.Usuario;

public interface UsuarioService {
    Usuario save(Usuario usuario);
    List<Usuario> getAll();
    Usuario getById(Long id);
    Usuario delete(Long id);

}
