package cl.duoc.ms_pacientes_bs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsPacientesBsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsPacientesBsApplication.class, args);
    }
}