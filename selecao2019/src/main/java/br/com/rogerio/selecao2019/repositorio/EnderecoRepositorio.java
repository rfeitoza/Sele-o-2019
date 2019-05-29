package br.com.rogerio.selecao2019.repositorio;

import br.com.rogerio.selecao2019.dominio.Endereco;
import br.com.rogerio.selecao2019.dominio.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepositorio extends JpaRepository<Endereco, Long> {

    @Query(value = "SELECT distinct p " +
            "FROM Endereco e " +
            "join e.pessoas p")
    List<Pessoa> buscarMoradores(@Param("id") Long id);
}
