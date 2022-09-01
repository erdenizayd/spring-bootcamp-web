package yte.intern.springweb;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    private Long postId;
    private Long id;
    private String name;
    private String email;
    private String body;
}
