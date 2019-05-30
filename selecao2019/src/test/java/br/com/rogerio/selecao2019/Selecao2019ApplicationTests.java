package br.com.rogerio.selecao2019;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Selecao2019ApplicationTests {

	@InjectMocks
	private Selecao2019Application selecao2019Application;

	@Test
	public void contextLoads() {
		selecao2019Application.main(new String[]{"Teste"});
	}

}
