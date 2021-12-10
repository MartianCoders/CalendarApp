package com.example.calendarapp.di

import com.example.calendarapp.network.CalendarApi
import com.example.calendarapp.network.NetworkMapper
import com.example.calendarapp.repository.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(serviceApi: CalendarApi, networkMapper: NetworkMapper): MainRepository {
        return MainRepository(serviceApi, networkMapper)
    }
}