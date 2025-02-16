package com.example.newsapp.di

import android.app.Application
import com.example.newsapp.onBoarding.data.LocalUserManagerImpl
import com.example.newsapp.onBoarding.domain.AppEntryUseCases
import com.example.newsapp.onBoarding.domain.LocalUserManager
import com.example.newsapp.onBoarding.domain.ReadAppEntry
import com.example.newsapp.onBoarding.domain.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(application: Application): LocalUserManager = LocalUserManagerImpl(application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(localUserManager: LocalUserManager) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )

}