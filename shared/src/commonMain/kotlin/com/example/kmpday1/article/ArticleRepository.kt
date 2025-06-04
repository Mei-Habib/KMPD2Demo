package com.example.kmpday1.article

import com.example.kmpday1.ArticleLocalDataSource

class ArticleRepository(private val service: ArticlesService, private val database: ArticleLocalDataSource) {
    suspend fun getArticles(): List<Article> {
        val articlesDB = database.getAllArticles()
        println("xyxyGot ${articlesDB.size} from DB")
        if(articlesDB.isEmpty()){
            val fetchedArticle = service.fetchArticles()
            database.insertAllArticles(fetchedArticle)
            return  fetchedArticle
        }
        return articlesDB
    }
}