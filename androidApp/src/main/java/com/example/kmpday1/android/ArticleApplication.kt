package com.example.kmpday1.android

import android.app.Application
import com.example.kmpday1.android.di.databaseModule
import com.example.kmpday1.android.di.viewModelModule
import com.example.kmpday1.di.sharedKoinModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class ArticleApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            val allModules = sharedKoinModule + viewModelModule + databaseModule
            androidContext(this@ArticleApplication)
            modules(allModules)
        }
    }
}