package com.seriendar.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Configura alguns parâmetros relacionados ao WebMVC Spring.
 *
 * É responsável por definir o prefixo e o sufixo do resolvedor
 * da view e também por habilitar o adaptador de configuração.
 *
 */
@Configuration
@EnableWebMvc
public class AppConfig extends WebMvcConfigurerAdapter{

    /**
     * Resolve a view passando alguns parâmetros essenciais para o funcionamento do Spring MVC
     * @return Retorna o resolvedor da view
     */
    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/");
        internalResourceViewResolver.setSuffix(".jsp");
        return internalResourceViewResolver;
    }

    /**
     * Configura o mantenedor da servlet padrão. Ativando o configurador
     *
     * @param configurer Configurador que coordena a servlet
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){
        configurer.enable();
    }
}
