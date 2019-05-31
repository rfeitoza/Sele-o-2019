package br.com.rogerio.selecao2019.controller;

import br.com.rogerio.selecao2019.dominio.Endereco;
import br.com.rogerio.selecao2019.repositorio.EnderecoRepositorio;
import br.com.rogerio.selecao2019.servico.EnderecoServico;
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
public class EnderecoControllerTest {

    @InjectMocks
    private EnderecoController enderecoController;

    @Mock
    private EnderecoServico servico;

    private Endereco endereco;

    private ResponseEntity responseEntity;

    @Before
    public void setUp(){
        responseEntity = new ResponseEntity<>(endereco,HttpStatus.OK);
        Endereco endereco = new Endereco();
        endereco.setCep("1231");
    }
    @Test
    public void salvarEndereco() {
        given(servico.salvarOuEditar(endereco)).willReturn(responseEntity);
        assertNotNull(enderecoController.salvarEndereco(endereco));
    }

    @Test
    public void deletarEndereco() {
        given(servico.deletar(1L)).willReturn(responseEntity);
        assertNotNull(enderecoController.deletarEndereco(1L));
    }

    @Test
    public void buscarTodos() {
        given(servico.buscarTodos()).willReturn(responseEntity);
        assertNotNull(enderecoController.buscarTodos());
    }

    @Test
    public void buscarEndereco() {
        given(servico.getEndereco(1L)).willReturn(responseEntity);
        assertNotNull(enderecoController.buscarEndereco(1L));
    }

    @Test
    public void buscarMoradores() {
        given(servico.buscarMoradores(1L)).willReturn(responseEntity);
        assertNotNull(enderecoController.buscarMoradores(1L));
    }
}