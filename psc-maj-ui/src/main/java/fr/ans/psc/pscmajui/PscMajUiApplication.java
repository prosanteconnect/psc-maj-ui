package fr.ans.psc.pscmajui;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;


@SpringBootApplication/*(exclude = { SecurityAutoConfiguration.class })*/
public class PscMajUiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PscMajUiApplication.class, args);
	}
	
}
