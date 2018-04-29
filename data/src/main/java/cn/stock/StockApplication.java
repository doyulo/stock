package cn.stock;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.stock.dao")
public class StockApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockApplication.class, args);

	}
}
