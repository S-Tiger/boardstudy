package com.sungho.board.dto;


import com.sungho.board.domain.board.Board;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString //toString 메소드를 자동생성해주는 어노테이션 (exclude={"제외할 값"}처럼 원치않는 속성은 제외 할 수 있다.
@NoArgsConstructor //기본생성자를 자동생성해주는 어노테이션
public class BoardDto {

    private Long id;
    private String writer;
    private String title;
    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public Board toEntity(){
        Board build = Board.builder()
                .id(id)
                .writer(writer)
                .title(title)
                .content(content)
                .build();

        return build;
    }

    @Builder
    public BoardDto(Long id,String writer,String title,String content,
                     LocalDateTime createdDate, LocalDateTime modifiedDate){
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;

    }
}
