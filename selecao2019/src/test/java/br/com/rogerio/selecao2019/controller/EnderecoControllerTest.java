package br.com.rogerio.selecao2019.controller;

import br.com.rogerio.selecao2019.dominio.Endereco;
import br.com.rogerio.selecao2019.repositorio.EnderecoRepositorio;
import br.com.rogerio.selecao2019.servico.EnderecoServico;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class EnderecoControllerTest {

    @InjectMocks
    private EnderecoController enderecoController;

    @Mock
    private EnderecoServico servico;

    @Mock
    private EnderecoRepositorio repositorio;

    private Endereco endereco;

    private HttpStatus httpStatus;

    @Test
    public void salvarEndereco() {
        given(servico.salvarOuEditar(endereco)).willReturn(any());
        Endereco endereco = new Endereco();
        endereco.setCep("1231");
        assertNotNull(enderecoController.salvarEndereco(endereco));
    }

    @Test
    public void deletarEndereco() {
    }

    @Test
    public void buscarTodos() {
    }

    @Test
    public void buscarEndereco() {
    }

    @Test
    public void buscarMoradores() {
    }
}