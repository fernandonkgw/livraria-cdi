package br.com.alura.livraria.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import br.com.alura.livraria.configuration.annotation.Configuration;

public class ConfigurationFactory {

	@Produces
	@Configuration
	@ApplicationScoped
	public Properties getProperties() throws IOException {
		
		InputStream inputStream = ConfigurationFactory.class.getResourceAsStream("configuracao.properties");

		Properties properties = new Properties();
		properties.load(inputStream);
		
		return properties;
	}
}
