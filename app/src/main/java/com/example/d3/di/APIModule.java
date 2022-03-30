package com.example.d3.di;

import com.example.d3.network.D3ApiInterface;
import com.example.d3.repo.D3Repository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class APIModule {
    String baseURL="https://mocki.io/v1/";
   // String baseURL="http://demo7735753.mockable.io/";
    @Singleton
    @Provides
    public D3ApiInterface getRestApiInterface(Retrofit retrofit) {
        return retrofit.create(D3ApiInterface.class);
    }
    @Singleton
    @Provides
    public Retrofit getRetroInstance() {
        return new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    @Singleton
    @Provides
    D3Repository provideRepository(D3ApiInterface apiInterface){
        return new D3Repository(apiInterface);
    }
}
