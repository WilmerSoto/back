package co.udea.ssmu.api.Component;

import co.udea.ssmu.api.model.Coordenadas;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommandLineInit implements CommandLineRunner {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String url = "http://localhost:8080/ssmu-api/taxiapp/send-coordenada";

    @Override
    public void run(String... args) throws Exception{
        List<Coordenadas> coordenadas = new ArrayList<>();
        coordenadas.add(new Coordenadas(0,0));
        // coordenadas
        coordenadas.add(new Coordenadas(6.270379436186207, -75.55614384473581));
        coordenadas.add(new Coordenadas(6.2704114301386875, -75.55657299815167));
        coordenadas.add(new Coordenadas(6.270563883844802, -75.55719550505819));
        coordenadas.add(new Coordenadas(6.270590787435376, -75.55744811655649));
        coordenadas.add(new Coordenadas(6.270931566129112, -75.55734887632501));
        coordenadas.add(new Coordenadas(6.271137826809218, -75.5573127889681));
        coordenadas.add(new Coordenadas(6.271559315771358, -75.55725865793276));
        coordenadas.add(new Coordenadas(6.271640026384801, -75.55764659701943));
        coordenadas.add(new Coordenadas(6.2717745440461385, -75.55829616944362));
        coordenadas.add(new Coordenadas(6.271873190309043, -75.55867508669107));
        coordenadas.add(new Coordenadas(6.271962868713667, -75.55941487750749));
        coordenadas.add(new Coordenadas(6.271998740071199, -75.5597396637196));

        enviarCoordenadasPeriodicamente(coordenadas);
    }

    private void enviarCoordenadasPeriodicamente(List<Coordenadas> coordenadas) {
        for(Coordenadas coordenada : coordenadas){
            enviarCoordenada(coordenada);
            try{
                Thread.sleep(2000);
            }catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
    }

    private void enviarCoordenada(Coordenadas coordenada) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Coordenadas> requestEntity = new HttpEntity<>(coordenada,headers);

        ResponseEntity<Coordenadas> responseEntity = restTemplate.postForEntity(url, requestEntity, Coordenadas.class);

        if(responseEntity.getStatusCode().is2xxSuccessful()){
            System.out.println("Coordenada enviada: "+ coordenada);
        }else{
            System.out.println("Coordenada fallida: "+ coordenada);
        }
    }
}
