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
        coordenadas.add(new Coordenadas(6.231898953520999, -75.58338106147312));
        coordenadas.add(new Coordenadas(6.231728406090786, -75.59093030796616));
        coordenadas.add(new Coordenadas(6.237526987610479, -75.59144502931794));
        coordenadas.add(new Coordenadas(6.245030939063767, -75.583724209041));
        coordenadas.add(new Coordenadas(6.253216945263573, -75.58218004498559));
        coordenadas.add(new Coordenadas(6.2561161250703545, -75.58063588093022));

        enviarCoordenadasPeriodicamente(coordenadas);
    }

    private void enviarCoordenadasPeriodicamente(List<Coordenadas> coordenadas) {
        for(Coordenadas coordenada : coordenadas){
            enviarCoordenada(coordenada);
            try{
                Thread.sleep(3000);
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
