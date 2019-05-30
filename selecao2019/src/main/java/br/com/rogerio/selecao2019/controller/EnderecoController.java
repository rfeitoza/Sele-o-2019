package br.com.rogerio.selecao2019.controller;

import br.com.rogerio.selecao2019.dominio.Endereco;
import br.com.rogerio.selecao2019.dominio.Pessoa;
import br.com.rogerio.selecao2019.servico.EnderecoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/endereco", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class EnderecoController {

    @Autowired
    private EnderecoServico servico;

    @RequestMapping(value = "/salvar", method = {RequestMethod.POST, RequestMethod.PUT})
    public ResponseEntity<Endereco> salvarEndereco(@RequestBody Endereco endereco){
        return servico.salvarOuEditar(endereco);
    }

    @RequestMapping(value = "/deletar/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deletarEndereco(@PathVariable("id") Long id){
        return servico.deletar(id);
    }

    @RequestMapping(value = "/buscar-todos-enderecos/", method = RequestMethod.GET)
    public ResponseEntity<List<Endereco>> buscarTodos(){
        return servico.buscarTodos();
    }

    @RequestMapping(value = "/buscar-endereco/{id}", method = RequestMethod.GET)
    public ResponseEntity<Endereco> buscarEndereco(@PathVariable("id") Long id){
        return servico.getEndereco(id);
    }

    @RequestMapping(value = "/buscar-moradores/{id}", method =  RequestMethod.GET)
    public ResponseEntity<List<Pessoa>> buscarMoradores(@PathVariable("id") Long id){
        return servico.buscarMoradores(id);
    }
}
