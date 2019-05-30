package br.com.rogerio.selecao2019.dominio;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PessoaTest {
    private Pessoa pessoa;
    private Endereco endereco;


    @Before
    public void setUp(){
        endereco = new Endereco();
        pessoa = new Pessoa();
    }

    @Test
    public void setAndGetId() {
        pessoa.setId(1L);
        assertNotNull(pessoa.getId());
    }

    @Test
    public void setAndGetNome() {
        pessoa.setNome("Nome");
        assertNotNull(pessoa.getNome());
    }

    @Test
    public void setAndGetRg() {
        pessoa.setRg("Rg");
        assertNotNull(pessoa.getRg());
    }

    @Test
    public void setAndGetCpf() {
        pessoa.setCpf("Cpf");
        assertNotNull(pessoa.getCpf());
    }

    @Test
    public void setAndGetTelefone() {
        pessoa.setTelefone("telefone");
        assertNotNull(pessoa.getTelefone());
    }

    @Test
    public void setAndGetEndereco() {
        pessoa.setEndereco(endereco);
        assertNotNull(pessoa.getEndereco());
    }
}