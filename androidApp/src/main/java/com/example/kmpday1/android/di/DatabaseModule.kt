package com.example.kmpday1.android.di

import app.cash.sqldelight.db.SqlDriver
import com.example.kmpday1.database.DatabaseDriverFactory
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import sqldelight.articles.db.ArticlesDatabase

val databaseModule = module {
    single<SqlDriver> {
        DatabaseDriverFactory(androidContext()).createDriver() }
    single<ArticlesDatabase> { ArticlesDatabase(get()) }
}