package yte.intern.springweb;


import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    private Long userId;

    private Long id;

    private String title;

    private String body;

}
