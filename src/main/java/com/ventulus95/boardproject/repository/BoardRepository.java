package com.ventulus95.boardproject.repository;

import com.ventulus95.boardproject.domain.Board;
import com.ventulus95.boardproject.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
    Board findByUser(User user);
}
