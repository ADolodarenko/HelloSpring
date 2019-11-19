package com.tutorialspoint.part14;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

@Configuration
@Import(TextEditorConfig.class)
public class AdditConfig {
	
	@Bean(initMethod = "init", destroyMethod = "destroy")
	@Scope("prototype")
	public Addit addit() {
		return new Addit();
	}

}
