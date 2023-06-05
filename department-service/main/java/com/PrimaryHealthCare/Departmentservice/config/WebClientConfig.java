package com.PrimaryHealthCare.Departmentservice.config;

import com.PrimaryHealthCare.Departmentservice.Client.EmployeeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class WebClientConfig 
{
    @Autowired
    private LoadBalancedExchangeFilterFunction filterFunction;
            
    @Bean
    public WebClient employeeWebClient()
    {
        return WebClient.builder().baseUrl("http://localhost//Employee-service").filter(filterFunction).build();
    }
    
    @Bean
    public EmployeeClient employeeClient()
    {
        HttpServiceProxyFactory httpServicProxyFactory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(employeeWebClient())).build();
        return httpServicProxyFactory.createClient(EmployeeClient.class);
    }
}
