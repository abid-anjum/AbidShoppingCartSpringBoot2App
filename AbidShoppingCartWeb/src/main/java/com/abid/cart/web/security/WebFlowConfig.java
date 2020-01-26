package com.abid.cart.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.webflow.config.AbstractFlowConfiguration;
import org.springframework.webflow.definition.registry.FlowDefinitionRegistry;
import org.springframework.webflow.engine.builder.support.FlowBuilderServices;
import org.springframework.webflow.executor.FlowExecutor;
import org.springframework.webflow.mvc.portlet.FlowHandlerAdapter;
import org.springframework.webflow.mvc.servlet.FlowHandlerMapping;

//@Configuration
public class WebFlowConfig extends AbstractFlowConfiguration {

	@Bean
	public FlowExecutor flowExecutor() {
		return getFlowExecutorBuilder(flowRegistry()).build();
	}

	@Bean
	public FlowDefinitionRegistry flowRegistry() {
		return getFlowDefinitionRegistryBuilder().addFlowLocation("/WEB-INF/flows/membership/register-flow.xml")
				.build();
	}

	@Bean
	public FlowHandlerAdapter flowHandlerAdapter() {
		FlowHandlerAdapter handlerAdapter = new FlowHandlerAdapter();
		handlerAdapter.setFlowExecutor(this.flowExecutor());

		// handlerAdapter.setSaveOutputToFlashScopeOnRedirect();
		return handlerAdapter;
	}

	@Bean
	public HandlerMapping logoutFlowHandlerMapping() {
		final FlowHandlerMapping handler = new FlowHandlerMapping();
		handler.setOrder(-1);
		handler.setFlowRegistry(flowRegistry());
		return handler;
	}

	@Bean
	public FlowBuilderServices flowBuilderServices() {
		return getFlowBuilderServicesBuilder().build();
	}

}
