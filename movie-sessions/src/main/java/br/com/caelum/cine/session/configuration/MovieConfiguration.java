package br.com.caelum.cine.session.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class MovieConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "cine.movie")
    MovieConfigurationProperties movieConfigurationProperties() {
        return new DefaultMovieConfigurationProperties();
    }

    private class DefaultMovieConfigurationProperties implements MovieConfigurationProperties {

        private String showUrl;

        @Override
        public String getShowUrl() {
            return showUrl;
        }

        public void setShowUrl(String showUrl) {
            this.showUrl = showUrl;
        }
    }
}
