package com.ventulus95.boardproject;

import com.ventulus95.boardproject.domain.Board;
import com.ventulus95.boardproject.domain.User;
import com.ventulus95.boardproject.domain.enums.BoardType;
import com.ventulus95.boardproject.repository.BoardRepository;
import com.ventulus95.boardproject.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JpaMappingTest {
    private final String boardTestTitle = "테스트";
    private final String email = "test@gmail.com";

    @Autowired
    UserRepository userRepository;

    @Autowired
    BoardRepository boardRepository;

    @Before
    public void init(){
        User user = userRepository.save(User.builder()
                .name("chang")
                .password("test")
                .email(email)
                .createdTime(LocalDateTime.now())
                .build());
        Board board = boardRepository.save(Board.builder()
                .title(boardTestTitle)
                .subtitle("서브 타이틀")
                .content("콘텐츠")
                .boardType(BoardType.free)
                .createdTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .user(user)
                .build());
    }

    @Test
    public void 테스트가_잘되는지(){
        System.out.println(userRepository.findById(0L));
        User user = userRepository.findByEmail(email);
        assertThat(user.getName(), is("chang"));
        assertThat(user.getPassword(), is("test"));
        assertThat(user.getEmail(), is(email));

        Board board = boardRepository.findByUser(user);
        assertThat(board.getTitle(), is(boardTestTitle));
        assertThat(board.getSubtitle(), is("서브 타이틀"));
        assertThat(board.getContent(), is("콘텐츠"));
        assertThat(board.getBoardType(), is(BoardType.free));

    }
}
