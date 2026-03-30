package com.alq.test.mapper;

import com.alq.test.client.CacheClient;
import com.alq.test.entity.ClientBusiness;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ClientBusinessMapperTest {

    @Autowired
    private ClientBusinessMapper mapper;

    @Autowired
    private CacheClient cacheClient;


    /*
     * 客户信息：采用hash结构
     * key：client_business:apikey
     * value：用户信息的json
     *
     */
    @Test
    public void findById() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<ClientBusiness> list = mapper.findAll();
        for (ClientBusiness clientBusiness : list) {
            Map map = objectMapper.readValue(objectMapper.writeValueAsString(clientBusiness), Map.class);
            cacheClient.hmset("client_business:" + clientBusiness.getApikey(), map);
        }
    }
}