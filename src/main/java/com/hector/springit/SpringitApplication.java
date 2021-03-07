package com.hector.springit;

import com.hector.springit.model.Comment;
import com.hector.springit.model.Link;
import com.hector.springit.repository.CommentRepository;
import com.hector.springit.repository.LinkRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
public class SpringitApplication {

    private static final Logger log = LoggerFactory.getLogger(SpringitApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringitApplication.class, args);
    }

    //@Bean
    CommandLineRunner runner(LinkRepository linkRepository, CommentRepository commentRepository) {
        return args -> {
           Link link = new Link("Getting Started with Spring Boot 2", "https://google.com");
           linkRepository.save(link);

           Comment comment = new Comment("This Spring Boot 2 is awesome", link);
           commentRepository.save(comment);
           link.addComment(comment);

            System.out.println("We just inserted a link and a comment");
            System.out.println("=======================================");

        };
    }


}
