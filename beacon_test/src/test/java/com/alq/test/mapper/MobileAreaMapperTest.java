package com.alq.test.mapper;

import com.alq.test.client.CacheClient;
import com.alq.test.entity.MobileArea;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MobileAreaMapperTest {

    private static final int BATCH_SIZE = 5000;

    @Autowired
    private MobileAreaMapper mapper;

    @Autowired
    private CacheClient cacheClient;


    @Test
    public void findAll() {
        List<MobileArea> list = mapper.findAll();
        Map<String, String> batch = new HashMap<>(BATCH_SIZE);
        for (MobileArea mobileArea : list) {
            batch.put("phase:" + mobileArea.getMobileNumber(), mobileArea.getMobileArea() + "," + mobileArea.getMobileType());
            if (batch.size() >= BATCH_SIZE) {
                cacheClient.pipelineString(batch);
                batch = new HashMap<>(BATCH_SIZE);
            }
        }
        if (!batch.isEmpty()) {
            cacheClient.pipelineString(batch);
        }
    }
}