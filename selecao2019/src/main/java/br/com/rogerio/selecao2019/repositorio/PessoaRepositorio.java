package br.com.rogerio.selecao2019.repositorio;

import br.com.rogerio.selecao2019.dominio.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepositorio extends JpaRepository<Pessoa, Long> {
}
