package com.example.kmpday1.di

import com.example.kmpday1.ArticleLocalDataSource
import com.example.kmpday1.article.ArticleRepository
import com.example.kmpday1.article.ArticleViewModel
import com.example.kmpday1.article.ArticlesService
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val networkModule = module {
    single {
        HttpClient {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                })
            }
        }
    }
}

val articleModule = module {
    single { ArticlesService(get()) }
    single { ArticleRepository(get(),get()) }
    single{ ArticleLocalDataSource(get())
    }
    single{ ArticleViewModel(get()) }
}

val sharedKoinModule = listOf(
    networkModule,
    articleModule
)