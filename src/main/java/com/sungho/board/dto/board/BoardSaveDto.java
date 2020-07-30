package com.sungho.board.dto.board;


import com.sungho.board.domain.board.Board;
import lombok.*;

@Getter
@NoArgsConstructor //기본생성자를 자동생성해주는 어노테이션
public class BoardSaveDto {

    private String writer;
    private String title;
    private String content;

    public Board toEntity(){
        Board build = Board.builder()
                .writer(writer)
                .title(title)
                .content(content)
                .build();

        return build;
    }

    @Builder
    public BoardSaveDto(String writer,String title,String content){
        this.writer = writer;
        this.title = title;
        this.content = content;

    }
}
