package com.developer.test.config;

import com.developer.test.api.ConsumeApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RetrofitConfig {

    @Value("${application.uriEmployee}")
    private String uriEmployee;

    @Bean
    public Retrofit retrofit() {
        return new Retrofit.Builder()
                .baseUrl(uriEmployee)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Bean
    public ConsumeApi consumeApi(Retrofit retrofit) {
        return retrofit.create(ConsumeApi.class);
    }
}
