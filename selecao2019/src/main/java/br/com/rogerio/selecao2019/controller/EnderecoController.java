package br.com.rogerio.selecao2019.controller;

import br.com.rogerio.selecao2019.dominio.Endereco;
import br.com.rogerio.selecao2019.dominio.Pessoa;
import br.com.rogerio.selecao2019.servico.EnderecoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/endereco", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class EnderecoController {

    @Autowired
    private EnderecoServico servico;

    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public ResponseEntity<Endereco> salvarEndereco(@RequestBody Endereco endereco){
        HttpStatus httpStatus = HttpStatus.OK;
        try{
            endereco = servico.salvarOuEditar(endereco);
        }catch (Exception e){
            httpStatus = httpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<>(endereco, httpStatus);
    }

    @RequestMapping(value = "/deletar/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deletarEndereco(@PathVariable("id") Long id){
        HttpStatus httpStatus = HttpStatus.OK;
        String retorno;
        try{
            retorno = "Deletado com Sucesso";
        }catch (Exception e){
            retorno = e.getMessage();
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<>(retorno, httpStatus);
    }

    @RequestMapping(value = "/buscar-todos-enderecos/", method = RequestMethod.GET)
    public ResponseEntity<List<Endereco>> buscarAll(){
        HttpStatus httpStatus = HttpStatus.OK;
        List<Endereco> enderecos;
        try {
            enderecos = servico.getAll();
        }catch (Exception e){
            httpStatus = HttpStatus.BAD_REQUEST;
            enderecos = null;
        }
        return new ResponseEntity<>(enderecos, httpStatus);
    }

    @RequestMapping(value = "/buscar-endereco/{id}", method = RequestMethod.GET)
    public ResponseEntity<Endereco> buscarEndereco(@PathVariable("id") Long id){
        HttpStatus httpStatus = HttpStatus.OK;
        Endereco endereco;
        try {
            endereco = servico.getEndereco(id);
        }catch (Exception e){
            httpStatus = HttpStatus.BAD_REQUEST;
            endereco = null;
        }
        return new ResponseEntity<>(endereco, httpStatus);
    }

    @RequestMapping(value = "/editar", method = RequestMethod.PUT)
    public ResponseEntity<Endereco> editar(@RequestBody Endereco endereco){
        HttpStatus httpStatus = HttpStatus.OK;
        try{
            endereco = servico.salvarOuEditar(endereco);
        }catch (Exception e){
            httpStatus = httpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<>(endereco, httpStatus);
    }

    @RequestMapping(value = "/buscar-moradores/{id}", method =  RequestMethod.GET)
    public ResponseEntity<List<Pessoa>> buscarMoradores(@PathVariable("id") Long id){
        HttpStatus httpStatus = HttpStatus.OK;
        List<Pessoa> pessoas = new ArrayList<>();
        try{
            pessoas = servico.buscarMoradores(id);
        }catch (Exception e){
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<>(pessoas, httpStatus);
    }
}
