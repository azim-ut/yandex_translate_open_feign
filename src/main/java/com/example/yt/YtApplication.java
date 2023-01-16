package com.example.yt;

import com.example.yt.translation.YandexConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;

@EnableFeignClients
@SpringBootApplication
@EnableConfigurationProperties(YandexConfig.class)
public class YtApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(YtApplication.class, args);
		TranslationService translationService = applicationContext.getBean(TranslationService.class);

		translationService.translate("en", "ru", "Test")
				.forEach(System.out::println);
	}

}
