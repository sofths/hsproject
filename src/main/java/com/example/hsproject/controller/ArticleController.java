package com.example.hsproject.controller;


import com.example.hsproject.dto.ArticleForm;
import com.example.hsproject.entity.Article;

import com.example.hsproject.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {
    @Autowired // 스프링부트가 미리 생성해 놓은 객체를 가져다가 자동으로 연결한다!
    private ArticleRepository articleRepository;
    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form){
        System.out.println(form.toString());

        //1. DTO를 변환! Entity 로 !!
        Article article=form.toEntity();
        System.out.println(article);
        //2. Repository 에게 Entity를 DB 안에 저장하게 함!!
        Article saved = articleRepository.save(article);
        System.out.println(saved.toString());

        return "";
    }
}
