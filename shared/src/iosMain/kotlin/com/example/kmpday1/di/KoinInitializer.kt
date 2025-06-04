package com.example.kmpday1.di

import com.example.kmpday1.article.ArticleViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin

fun initKoin() {
    val allModules = sharedKoinModule
    startKoin {
        modules(allModules)
    }
}
class ArticleInjector : KoinComponent {
    val articleViewModel : ArticleViewModel by inject()
}