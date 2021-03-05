package com.hector.springit.repository;

import com.hector.springit.model.Link;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LinkRepository extends JpaRepository<Link, Long> {
//
//    Link findByTitle(String title);
//
//    List<Link> findAllByTitleLikeOrOrderByCreationDate(String title);

}
