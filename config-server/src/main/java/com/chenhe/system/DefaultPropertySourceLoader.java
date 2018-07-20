package com.chenhe.system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.env.PropertySourceLoader;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * @author chenhe
 * @Date 2018-07-20 16:46
 * @desc 自定义配置文件录取,解决默认读取乱码问题
 **/
public class DefaultPropertySourceLoader implements PropertySourceLoader {

    private Logger logger = LoggerFactory.getLogger(DefaultPropertySourceLoader.class);

    @Override
    public String[] getFileExtensions() {
        return new String[]{"properties", "xml"};
    }

    @Override
    public PropertySource<?> load(String name, Resource resource, String profile) throws IOException {
        if (profile == null) {
            Properties properties = getProperties(resource);
            if (!properties.isEmpty()) {
                PropertiesPropertySource propertiesPropertySource = new PropertiesPropertySource(name, properties);
                return propertiesPropertySource;
            }
        }
        return null;
    }

    private Properties getProperties(Resource resource) {
        Properties properties = new Properties();
        InputStream inputStream = null;
        try {
            inputStream = resource.getInputStream();
            properties.load(new InputStreamReader(inputStream, "utf-8"));
        } catch (IOException ex) {
            logger.error("[配置文件加载出错] ", ex);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return properties;
    }
}
