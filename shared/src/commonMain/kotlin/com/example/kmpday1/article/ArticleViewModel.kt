package com.example.kmpday1.article

import com.example.kmpday1.BaseViewModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType.Application.Json
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ArticleViewModel(private var repo : ArticleRepository) : BaseViewModel() {

    private val _articlesState: MutableStateFlow<ArticleState> = MutableStateFlow(ArticleState())
    val articleState = _articlesState.asStateFlow()
    init {
       getArticles()
    }

    private fun getArticles(){
        scope.launch {
            delay(2000)
            _articlesState.emit(ArticleState(error = "Fetching Error"))
            delay(2000)
            val fetchedArticle = repo.getArticles()
            _articlesState.emit(ArticleState(articles = fetchedArticle))

        }
    }

}