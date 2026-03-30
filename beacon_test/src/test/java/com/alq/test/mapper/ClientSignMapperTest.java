package com.alq.test.mapper;

import com.alq.test.client.CacheClient;
import com.alq.test.entity.ClientSign;
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
public class ClientSignMapperTest {

    @Autowired
    private ClientSignMapper mapper;

    @Autowired
    private CacheClient cacheClient;

    @Test
    public void findByClientId() {
        List<ClientSign> list = mapper.findAll();
        ObjectMapper objectMapper = new ObjectMapper();
        Map<Long, List<Map>> grouped = list.stream().collect(Collectors.groupingBy(
                ClientSign::getClientId,
                LinkedHashMap::new,
                Collectors.mapping(cs -> {
                    try {
                        return objectMapper.readValue(objectMapper.writeValueAsString(cs), Map.class);
                    } catch (JsonProcessingException e) {
                        throw new IllegalStateException(e);
                    }
                }, Collectors.toList())
        ));
        for (Map.Entry<Long, List<Map>> entry : grouped.entrySet()) {
            cacheClient.sadd("client_sign:" + entry.getKey(), entry.getValue().toArray(new Map[]{}));
        }
    }
}