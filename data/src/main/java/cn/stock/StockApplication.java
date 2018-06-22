package cn.stock;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@ServletComponentScan
@MapperScan("cn.stock.dao")
@ComponentScan("cn.stock")
@EnableAsync
public class StockApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockApplication.class, args);

	}
}
