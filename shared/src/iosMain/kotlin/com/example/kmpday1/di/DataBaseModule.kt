package com.example.kmpday1.di

import app.cash.sqldelight.db.SqlDriver
import com.example.kmpday1.database.DatabaseDriverFactory
import org.koin.dsl.module
import sqldelight.articles.db.ArticlesDatabase

val databaseModule = module {
    single<SqlDriver> { DatabaseDriverFactory().createDriver() }
    single<ArticlesDatabase> { ArticlesDatabase(get()) }
}