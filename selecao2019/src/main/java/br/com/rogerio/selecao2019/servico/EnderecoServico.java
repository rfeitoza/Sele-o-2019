package br.com.rogerio.selecao2019.servico;

import br.com.rogerio.selecao2019.dominio.Endereco;
import br.com.rogerio.selecao2019.dominio.Pessoa;
import br.com.rogerio.selecao2019.repositorio.EnderecoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoServico {

    @Autowired
    EnderecoRepositorio enderecoRepositorio;

    public List<Endereco> getAll() {
        return enderecoRepositorio.findAll();
    }

    public Endereco getEndereco(Long id) {
        Optional<Endereco> endereco = enderecoRepositorio.findById(id);
        return endereco.orElse(null);
    }


    public Endereco salvarOuEditar(Endereco endereco) {
        return enderecoRepositorio.save(endereco);
    }

    public List<Pessoa> buscarMoradores(Long id) {
        return enderecoRepositorio.buscarMoradores(id);
    }
}
