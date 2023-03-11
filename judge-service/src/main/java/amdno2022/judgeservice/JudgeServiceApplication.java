package amdno2022.judgeservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: AMDNO2022
 * @description: TODO
 */
@SpringBootApplication
@MapperScan("amdno2022.judgeservice.mapper")
public class JudgeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(JudgeServiceApplication.class, args);
    }

}
