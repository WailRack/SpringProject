package ru.ivan.notification.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import ru.ivan.notification.config.RabbitMQConfig;

@Service
public class DepositMessageHandler {

    protected MailSender mailSender;

    @Autowired
    public DepositMessageHandler(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE_DEPOSIT)
    public void receive(Message message) throws JsonProcessingException {
        System.out.println(message);
        byte[] bytes = message.getBody();
        String jsonBody = new String(bytes);
        ObjectMapper mapper = new ObjectMapper();
        DepositResponseDTO depositResponseDTO = mapper.readValue(jsonBody, DepositResponseDTO.class);
        System.out.println(depositResponseDTO);

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(depositResponseDTO.getMail());
        mailMessage.setFrom("lori@cat.xyz");

        mailMessage.setSubject("deposit");
        mailMessage.setText("Make deposit, sum:" + depositResponseDTO.getAmount());

        try {
            mailSender.send(mailMessage);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
