package com.example.demo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "exemple")
public class DemoConfiguration {
    @Setter
    @Getter
    private int var1;
    @Setter
    @Getter
    private String var2;


}
