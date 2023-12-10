package com.makaia.back4.JpaMySql.consumer;

import com.makaia.back4.JpaMySql.dtos.CrearDTO;
import com.makaia.back4.JpaMySql.services.Service;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @Autowired
    Service mensajeService;


    @RabbitListener(queues = {"message_created"}) // message_created: Nombre de la cola que se quiere escuchar
    public void recibirMensaje(CrearDTO crearDTO) {
        // Procesar el mensaje recibido
        mensajeService.enviarMensaje(crearDTO);

    }


    }
        

