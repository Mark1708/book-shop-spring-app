package bookstore.com.app.config;

import bookstore.com.app.services.IdProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "bookstore.com.app")
public class AppContextConfig {

    @Bean
    public IdProvider idProvider(){
        return new IdProvider();
    }
}
