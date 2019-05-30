package br.com.rogerio.selecao2019.servico;

import br.com.rogerio.selecao2019.dominio.Pessoa;
import br.com.rogerio.selecao2019.repositorio.PessoaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PessoaServico {

    @Autowired
    PessoaRepositorio pessoaRepositorio;

    public ResponseEntity<Pessoa> salvarOuEditar(Pessoa pessoa) {
        HttpStatus httpStatus = HttpStatus.OK;
        try{
            pessoa = pessoaRepositorio.save(pessoa);
        }catch (Exception e){
            httpStatus = httpStatus.BAD_REQUEST;
        }

        return new ResponseEntity<>(pessoa, httpStatus);
    }

    public ResponseEntity<String> deletar(Long id) {
        HttpStatus httpStatus = HttpStatus.OK;
        String retorno;
        try{
            pessoaRepositorio.deleteById(id);
            retorno = "Deletado com Sucesso";
        }catch (Exception e){
            retorno = e.getMessage();
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<>(retorno, httpStatus);
    }

    public ResponseEntity<List<Pessoa>> buscarTodos() {
        HttpStatus httpStatus = HttpStatus.OK;
        List<Pessoa> pessoas = new ArrayList<>();
        try {
            pessoas = pessoaRepositorio.findAll();
        }catch (Exception e){
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<>(pessoas, httpStatus);
    }

    public ResponseEntity<Pessoa> buscarPessoa(Long id) {
        HttpStatus httpStatus = HttpStatus.OK;
         Pessoa pessoa = new Pessoa();
        try {
            Optional<Pessoa> optionalPessoa = pessoaRepositorio.findById(id);
            pessoa = optionalPessoa.orElse(null);
        }catch (Exception e){
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<>(pessoa, httpStatus);
    }
}
