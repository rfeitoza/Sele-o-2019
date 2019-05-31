package br.com.rogerio.selecao2019.controller;

import br.com.rogerio.selecao2019.dominio.Pessoa;
import br.com.rogerio.selecao2019.servico.PessoaServico;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertNotNull;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class PessoaControllerTest {

    @InjectMocks
    private PessoaController pessoaController;

    @Mock
    private PessoaServico servico;

    private Pessoa pessoa;

    private ResponseEntity responseEntity;

    @Before
    public void setUp(){
        responseEntity = new ResponseEntity<>(pessoa,HttpStatus.OK);
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("1231");
    }

    @Test
    public void salvarEndereco() {
        given(servico.salvarOuEditar(pessoa)).willReturn(responseEntity);
        assertNotNull(pessoaController.salvarEndereco(pessoa));
    }

    @Test
    public void deletarPessoa() {
        given(servico.deletar(1L)).willReturn(responseEntity);
        assertNotNull(pessoaController.deletarPessoa(1L));
    }

    @Test
    public void buscarTodos() {
        given(servico.buscarTodos()).willReturn(responseEntity);
        assertNotNull(pessoaController.buscarTodos());
    }

    @Test
    public void buscarPessoa() {
        given(servico.buscarPessoa(1L)).willReturn(responseEntity);
        assertNotNull(pessoaController.buscarPessoa(1L));
    }
}