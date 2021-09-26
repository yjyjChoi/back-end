package com.pasta.aglioeolio.domains.wish.repository;

import com.pasta.aglioeolio.config.jpa.Wish;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface WishRepository extends JpaRepository<Wish, Long> {

    @Query("select w from wish w where w.id = :wishId and w.soldier_id = :soldier_id")
    Optional<Wish> findByIdAndSoldierId(@Param("wishId") Long wishId, @Param("soldier_id") Long soldier_id);

    @Modifying
    @Query("update wish w set w.is_delyn = true where w.soldier_id = :soldierId and w.id in :wishIds")
    int deleteWish(@Param("wishIds") List<Long> wishIds, @Param("soldierId") Long soldierId);

}