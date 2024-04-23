package com.jlg.submatch.service.authentication.configuration;

import com.jlg.submatch.service.authentication.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import reactor.core.publisher.Mono;

@Configuration
@PropertySources({
        @PropertySource("classpath:outbound-api-client.properties"),
})
@EnableConfigurationProperties(UserServiceConfigurationProperties.class)
public class UserServiceConfiguration {

    @Bean
    public UserService userService(UserServiceConfigurationProperties configurationProperties) {
        WebClient client = WebClient.builder()
                .baseUrl(configurationProperties.baseUrl())
                .defaultStatusHandler(HttpStatusCode::isError,
                        clientResponse -> Mono.error(new Exception(clientResponse.toString())))
//                .filter(ExchangeFilterFunction.ofRequestProcessor(clientRequest -> {
//                    if (clientRequest.logPrefix() != null) {
//                        System.out.println("Request: " + clientRequest.logPrefix());
//                    }
//                    return Mono.just(clientRequest);
//                }))
//                .filter(ExchangeFilterFunction.ofResponseProcessor(clientResponse -> {
//                    if (clientResponse.statusCode().isError()) {
//                        System.out.println("Response error: " + clientResponse.statusCode());
//                        clientResponse.bodyToMono(String.class).subscribe(System.out::println);
//                    }
//                    return Mono.just(clientResponse);
//                }))
                .build();

        WebClientAdapter adapter = WebClientAdapter.create(client);
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();
        return factory.createClient(UserService.class);
    }

//    @Bean
//    CommandLineRunner commandLineRunner(UserService userService) {
//        return args -> {
//            System.out.println(userService.findUserByEmail("example@email.com"));
//        };
//    }
}
