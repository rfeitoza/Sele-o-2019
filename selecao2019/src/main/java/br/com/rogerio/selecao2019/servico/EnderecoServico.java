package br.com.rogerio.selecao2019.servico;

import br.com.rogerio.selecao2019.dominio.Endereco;
import br.com.rogerio.selecao2019.dominio.Pessoa;
import br.com.rogerio.selecao2019.repositorio.EnderecoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EnderecoServico {

    @Autowired
    EnderecoRepositorio enderecoRepositorio;

    public ResponseEntity<List<Endereco>> buscarTodos() {
        HttpStatus httpStatus = HttpStatus.OK;
        List<Endereco> enderecos;
        try {
            enderecos = enderecoRepositorio.findAll();;
        }catch (Exception e){
            httpStatus = HttpStatus.BAD_REQUEST;
            enderecos = null;
        }
        return new ResponseEntity<>(enderecos, httpStatus);
    }

    public ResponseEntity<Endereco> getEndereco(Long id) {
        HttpStatus httpStatus = HttpStatus.OK;
        Endereco endereco = new Endereco();
        try {
            Optional<Endereco> optionalEndereco = enderecoRepositorio.findById(id);
            endereco = optionalEndereco.orElse(null);
        }catch (Exception e){
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<>(endereco, httpStatus);
    }


    public ResponseEntity<Endereco> salvarOuEditar(Endereco endereco) {
        endereco = enderecoRepositorio.save(endereco);
        return ResponseEntity.ok(endereco);
    }

    public ResponseEntity<List<Pessoa>> buscarMoradores(Long id) {
        HttpStatus httpStatus = HttpStatus.OK;
        List<Pessoa> pessoas = new ArrayList<>();
        try{
            pessoas = enderecoRepositorio.buscarMoradores(id);
        }catch (Exception e){
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<>(pessoas, httpStatus);
    }

    public ResponseEntity<String> deletar(Long id) {
        HttpStatus httpStatus = HttpStatus.OK;
        String retorno;
        try{
            retorno = "Deletado com Sucesso";
            enderecoRepositorio.deleteById(id);
        }catch (Exception e){
            retorno = e.getMessage();
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<>(retorno, httpStatus);
    }
}
