
package com.leysoft.service.imple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.leysoft.domain.Properties;
import com.leysoft.service.inter.PropertiesService;

@Service
public class PropertiesServiceImp implements PropertiesService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PropertiesServiceImp.class);

    private static final String PREFIX_NAME = "COD_";

    private static final String PREFIX_DESCRIPTION = "DESCRIPTION_";

    @Override
    @Cacheable(
            value = "properties",
            key = "'prop_' + #codigo",
            cacheManager = "redisCacheManager")
    public Properties load(String codigo) {
        LOGGER.info("load properties...");
        return new Properties(codigo, PREFIX_NAME + codigo, PREFIX_DESCRIPTION + codigo);
    }
}
