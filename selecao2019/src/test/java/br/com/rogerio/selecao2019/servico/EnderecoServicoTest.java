package br.com.rogerio.selecao2019.servico;

import br.com.rogerio.selecao2019.dominio.Endereco;
import br.com.rogerio.selecao2019.dominio.Pessoa;
import br.com.rogerio.selecao2019.repositorio.EnderecoRepositorio;
import br.com.rogerio.selecao2019.repositorio.PessoaRepositorio;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;

@RunWith(MockitoJUnitRunner.class)
public class EnderecoServicoTest {


    @InjectMocks
    private EnderecoServico servico;

    @Mock
    private EnderecoRepositorio repositorio;

    private Endereco endereco;

    @Test
    public void salvarOuEditar() {
        given(repositorio.save(endereco)).willReturn(new Endereco());
        assertNotNull(servico.salvarOuEditar(endereco));
    }

    @Test
    public void deletar() {
        doNothing().when(repositorio).deleteById(1L);
        assertNotNull(servico.deletar(1L));
    }

    @Test
    public void buscarTodos() {
        given(repositorio.findAll()).willReturn(new ArrayList<>());
        assertNotNull(servico.buscarTodos());
    }

    @Test
    public void buscarPessoa() {
        given(repositorio.findById(1L)).willReturn(Optional.empty());
        assertNotNull(servico.getEndereco(1L));
    }

    @Test
    public void buscarMoradores(){
        given(repositorio.buscarMoradores(1L)).willReturn(new ArrayList<>());
        assertNotNull(servico.buscarMoradores(1L));
    }
}