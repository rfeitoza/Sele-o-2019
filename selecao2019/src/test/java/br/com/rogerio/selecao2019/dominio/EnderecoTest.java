package br.com.rogerio.selecao2019.dominio;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class EnderecoTest {

    private Endereco endereco;
    private List<Pessoa> pessoas;

    @Before
    public void setUp(){
        endereco = new Endereco();
        Pessoa pessoa = new Pessoa();
        pessoas = new ArrayList<>();
        pessoas.add(pessoa);
    }
    @Test
    public void setAndGetId() {
        endereco.setId(1L);
        assertNotNull(endereco.getId());
    }

    @Test
    public void setAndGetCep() {
        endereco.setCep("1111111");
        assertNotNull(endereco.getCep());
    }

    @Test
    public void setAndGetUf() {
        endereco.setUf("df");
        assertNotNull(endereco.getUf());
    }

    @Test
    public void setAndGetNumero() {
        endereco.setNumero("10");
        assertNotNull(endereco.getNumero());
    }

    @Test
    public void setAndGetLogradouro() {
        endereco.setLogradouro("Logradouro");
        assertNotNull(endereco.getLogradouro());
    }

    @Test
    public void setAndGetMunicipio() {
        endereco.setMunicipio("Municipio");
        assertNotNull(endereco.getMunicipio());
    }

    @Test
    public void setAndGetBairro() {
        endereco.setBairro("Bairro");
        assertNotNull(endereco.getBairro());
    }

    @Test
    public void setAndGetPais() {
        endereco.setPais("Pais");
        assertNotNull(endereco.getPais());
    }

    @Test
    public void setAndGetPessoas() {
        endereco.setPessoas(pessoas);
        assertNotNull(endereco.getPessoas());
    }
}