package com.example.kmpday1

import com.example.kmpday1.article.Article
import sqldelight.articles.db.ArticlesDatabase

class ArticleLocalDataSource (
    private val database : ArticlesDatabase
) {
    fun getAllArticles(): List<Article> {
        return database.articlesDatabaseQueries.selectAllArticles(::mapToArticle).executeAsList()
    }
    private fun mapToArticle(
        title: String?,
        desc: String?,
        date:String?,
        imageUrl:String?
    ):Article{
        return Article(
            title?:"",
            desc?:"",
            date?:"",
            imageUrl?:""
        )
    }
    fun insertAllArticles(articles: List<Article>){
        database.articlesDatabaseQueries.transaction {
            articles.forEach{ article ->
                insertArticle(article)

            }
        }
    }
    private fun insertArticle(article:Article){
        database.articlesDatabaseQueries.insertArticle(
            article.title ?: "",
            article.description,
            article.publishedAt ?: "",
            article.urlToImage
        )
    }
}