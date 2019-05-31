package br.com.rogerio.selecao2019.servico;

import br.com.rogerio.selecao2019.dominio.Pessoa;
import br.com.rogerio.selecao2019.repositorio.PessoaRepositorio;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PessoaServicoTest {
    @InjectMocks
    private PessoaServico servico;

    @Mock
    private PessoaRepositorio repositorio;

    private Pessoa pessoa;

    @Test
    public void salvarOuEditar() {
        given(repositorio.save(pessoa)).willReturn(new Pessoa());
        assertNotNull(servico.salvarOuEditar(pessoa));
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
        assertNotNull(servico.buscarPessoa(1L));
    }
}