package co.udea.ssmu.api.controller;

import co.udea.ssmu.api.model.Coordenadas;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class CoordenadaController {

    @MessageMapping("/taxi")
    @SendTo("/taxi/coordenada")
    public Coordenadas envio(Coordenadas coordenada){
        return coordenada;
    }
}
