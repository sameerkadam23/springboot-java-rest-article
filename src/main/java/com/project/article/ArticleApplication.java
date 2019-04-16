package com.project.article;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ArticleApplication {
	
	@Autowired
	private ArticleRepository articleRepostory;
	
	@RequestMapping("/")
	String home() {
		return "Hello World!";
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping("/getAllArticles")
	List<Article> getAllArticle() {
		List<Article> articles = articleRepostory.findAll();
		return articles;
	}
	
	public void setArticleRepostory(ArticleRepository articleRepostory) {
		this.articleRepostory = articleRepostory;
	}

	public static void main(String[] args) {
		SpringApplication.run(ArticleApplication.class, args);
	}

}
