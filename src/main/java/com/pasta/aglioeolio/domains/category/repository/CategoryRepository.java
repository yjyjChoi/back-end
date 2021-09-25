package com.pasta.aglioeolio.domains.category.repository;

import com.pasta.aglioeolio.config.jpa.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}