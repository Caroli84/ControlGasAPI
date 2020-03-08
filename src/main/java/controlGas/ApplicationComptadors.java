package controlGas;

import controlGas.controllers.FacturaController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
public class ApplicationComptadors {
    public static void main(String[] args) {
        //en el main lo unic que fas es engegar, Spring  busca totes les clases RestController i Beans i els posa en marxa/executa
        //por eso la forma de ponerlo en marxa es con un Bean solo
        //el Main es para poner el Spring en marcha
        SpringApplication.run(ApplicationComptadors.class, args);
    }

//bean es una clase que es pot instanciar

    @Bean
    public CommandLineRunner demo(){
        return(args)->{
            //ahora dentro se quiere calcular facturas
            //esta fuera y he d ehacer algo desde dentro para poderlo ejecutar
            FacturaController facturaController=new FacturaController();
            facturaController.calcularFactures();

        };
    }




}
