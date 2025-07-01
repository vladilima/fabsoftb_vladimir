package br.univille.projfabsoft_despesas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.projfabsoft_despesas.entity.GrupoFamiliar;

@Repository
public interface GrupoFamiliarRepository extends JpaRepository<GrupoFamiliar, Long> {
}