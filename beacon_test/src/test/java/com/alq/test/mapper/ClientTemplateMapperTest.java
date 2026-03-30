package com.alq.test.mapper;

import com.alq.test.client.CacheClient;
import com.alq.test.entity.ClientTemplate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ClientTemplateMapperTest {

    @Autowired
    private ClientTemplateMapper mapper;

    @Autowired
    private CacheClient cacheClient;

    @Test
    public void findBySignId() {
        List<ClientTemplate> list = mapper.findAll();
        ObjectMapper objectMapper = new ObjectMapper();
        Map<Long, List<Map>> grouped = list.stream().collect(Collectors.groupingBy(
                ClientTemplate::getSignId,
                LinkedHashMap::new,
                Collectors.mapping(ct -> {
                    try {
                        return objectMapper.readValue(objectMapper.writeValueAsString(ct), Map.class);
                    } catch (JsonProcessingException e) {
                        throw new IllegalStateException(e);
                    }
                }, Collectors.toList())
        ));
        for (Map.Entry<Long, List<Map>> entry : grouped.entrySet()) {
            cacheClient.sadd("client_template:" + entry.getKey(), entry.getValue().toArray(new Map[]{}));
        }
    }
}