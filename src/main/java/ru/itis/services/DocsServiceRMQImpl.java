package ru.itis.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import org.springframework.stereotype.Service;
import ru.itis.dtos.DocsData;

import java.io.IOException;

@Service
public class DocsServiceRMQImpl implements DocsService {
    private final Channel channel;

    public DocsServiceRMQImpl(Channel channel) {
        this.channel = channel;
    }

    @Override
    public void createDocs(DocsData docsData) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String jsonData = objectMapper.writeValueAsString(docsData);
            channel.basicPublish("requests_exchange", String.join(".", docsData.getDocs()), null, jsonData.getBytes());
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
