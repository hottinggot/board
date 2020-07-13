package com.example.board.board.repository;

import com.example.board.board.entity.BoardEntity;
import com.example.board.board.entity.BoardFileEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JpaBoardRepository extends CrudRepository<BoardEntity,Integer> {
    List<BoardEntity> findAllByOrderByBoardIdxDesc();

    @Query("select file from BoardFileEntity file where board_idx = :boardIdx and idx = :idx")
    BoardFileEntity findBoardFile(@Param("boardIdx") int boardIdx, @Param("idx") int idx);
}
