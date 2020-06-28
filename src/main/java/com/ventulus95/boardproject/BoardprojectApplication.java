package com.ventulus95.boardproject;

import com.ventulus95.boardproject.domain.Board;
import com.ventulus95.boardproject.domain.User;
import com.ventulus95.boardproject.domain.enums.BoardType;
import com.ventulus95.boardproject.repository.BoardRepository;
import com.ventulus95.boardproject.repository.UserRepository;
import com.ventulus95.boardproject.resolver.UserArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.IntStream;

@SpringBootApplication
public class BoardprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoardprojectApplication.class, args);
    }

    @Autowired
    private UserArgumentResolver userArgumentResolver;

   public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolverList){
       argumentResolverList.add(userArgumentResolver);
   }

    @Bean
    public CommandLineRunner runner(UserRepository userRepository, BoardRepository boardRepository)throws Exception{
        return  (args) -> {
            User user = userRepository.save(User.builder()
                    .name("chang")
                    .password("test")
                    .email("chang@gamil.com")
                    .createdTime(LocalDateTime.now())
                    .build());
            IntStream.rangeClosed(1, 200).forEach(index ->
                    boardRepository.save(Board.builder()
                    .title("게시글 "+index)
                    .subtitle("순서"+index)
                    .content("콘텐츠")
                    .boardType(BoardType.free)
                    .createdDate(LocalDateTime.now())
                    .updatedDate(LocalDateTime.now())
                    .user(user).build()));
        };
    }

}
