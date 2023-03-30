package com.block5profiles.block5profiles;

import lombok.Data;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class AppConfig
{
    @Value("${app.name}")
    private String name;

    @Value("${app.environment}")
    private String environment;
}