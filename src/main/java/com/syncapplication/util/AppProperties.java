package com.syncapplication.util;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class AppProperties {

    @Value("${spring.kafka.topic.partner}")
    private String partnerTopic;

    @Value("${kafka.bootstrap-servers}")
    private String kafkaServers;

    @Value("${scheduled.job.time.in.milliseconds}")
    private Long scheduledJobFixedTime;

}
