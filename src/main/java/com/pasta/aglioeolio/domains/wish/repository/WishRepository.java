package com.pasta.aglioeolio.domains.wish.repository;

import com.pasta.aglioeolio.config.jpa.Wish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishRepository extends JpaRepository<Wish, Long> {

}