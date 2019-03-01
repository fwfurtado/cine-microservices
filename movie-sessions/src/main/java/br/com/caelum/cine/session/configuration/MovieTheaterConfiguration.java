package br.com.caelum.cine.session.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class MovieTheaterConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "cine.theater")
    public MovieTheaterConfigurationProperties movieTheaterConfigurationProperties() {
        return new DefaultMovieTheaterConfigurationProperties();
    }

    private class DefaultMovieTheaterConfigurationProperties implements MovieTheaterConfigurationProperties {

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
