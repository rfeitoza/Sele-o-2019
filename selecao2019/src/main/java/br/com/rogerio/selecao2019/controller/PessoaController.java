package br.com.rogerio.selecao2019.controller;

import br.com.rogerio.selecao2019.dominio.Pessoa;
import br.com.rogerio.selecao2019.servico.PessoaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PessoaController {
    @Autowired
    private PessoaServico servico;

    @RequestMapping(value = "/salvar", method = {RequestMethod.POST, RequestMethod.PUT})
    public ResponseEntity<Pessoa> salvarEndereco(@RequestBody Pessoa pessoa){
        return servico.salvarOuEditar(pessoa);
    }

    @RequestMapping(value = "/deletar/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deletarPessoa(@PathVariable("id") Long id){
        return servico.deletar(id);
    }

    @RequestMapping(value = "/buscar-todas-pessoas/", method = RequestMethod.GET)
    public ResponseEntity<List<Pessoa>> buscarTodos(){
       return servico.buscarTodos();
    }

    @RequestMapping(value = "/buscar-pessoa/{id}", method = RequestMethod.GET)
    public ResponseEntity<Pessoa> buscarPessoa(@PathVariable("id") Long id){
        return servico.buscarPessoa(id);
    }


}
