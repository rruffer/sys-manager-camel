package br.com.sysmanager.treinamento.camel.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class LerArquivoBuilder extends RouteBuilder {

	private static final String ID = "lerArquivosClientes";
	private static final String DIRECTORY_NAME = "C:\\opt\\integracao\\lab";
	private static final String FILE = "clientes.json";
	private static final String URI = String.format("file:%s?filename=%s&noop=true", DIRECTORY_NAME, FILE);

	@Override
	public void configure() throws Exception {

		from(URI)
		.routeId(ID)
		.log("Executando a leitura de arquivos de clientes")
		.log(">> body: \n${body}")
		.log(">> cabeçalho: ${headers}")
		.log(">> última modificação: ${headers.CamelFileLastModified}")
		//.process("testeProcessor")
		.end();
		
		

	}

}
