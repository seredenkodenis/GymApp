package com.project.gym.Controllers;

import com.project.gym.Model.Article;
import com.project.gym.Repos.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/news")
public class ArticleConroller {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping
    public String geter(Model model){
        List<Article> articleList = articleRepository.findAll();
        model.addAttribute("articles",articleList);
        System.out.println(articleList.size());
        return "news";
    }
    @GetMapping("{id}")
    public String geterOne(@PathVariable("id") Long id, Model model){
        Article article = articleRepository.findArticleById(id);
        model.addAttribute("date",article.getDate());
        model.addAttribute("title",article.getTitle());
        model.addAttribute("contentor",article.getText());
        return "singleNews";
    }
}
