package com.pasta.aglioeolio.domains.wish.repository;

import com.pasta.aglioeolio.config.jpa.OfficerWish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishOfficerRepository extends JpaRepository<OfficerWish, Long> {

}