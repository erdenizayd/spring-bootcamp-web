package yte.intern.springweb;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;

public class RestTemplateTest {
    @Test
    @DisplayName("Get all posts")
    void get_all_posts() {
        RestTemplate restTemplate = new RestTemplate();
        URI uri =UriComponentsBuilder.fromHttpUrl("https://jsonplaceholder.typicode.com/")
                .pathSegment("posts")
                .build()
                .toUri();

        RequestEntity<Void> request = RequestEntity.get(uri).build();

        ResponseEntity<Post[]> response = restTemplate.exchange(request, Post[].class);

        System.out.println(Arrays.asList(response.getBody()));

    }

    @Test
    @DisplayName("Get post with id 2")
    void get_post_with_id() {
        RestTemplate restTemplate = new RestTemplate();
        URI uri = UriComponentsBuilder.fromHttpUrl("https://jsonplaceholder.typicode.com/")
                .pathSegment("posts","2")
                .build()
                .toUri();

        RequestEntity<Void> request = RequestEntity.get(uri).build();

        ResponseEntity<Post> response = restTemplate.exchange(request, Post.class);

        System.out.println(response.getBody());
    }

    @Test
    @DisplayName("Add new post")
    void add_new_post() {
        RestTemplate restTemplate = new RestTemplate();
        Post randomPost = new Post();

        randomPost.setId(null);
        randomPost.setUserId(13L);
        randomPost.setBody("sadadasd");
        randomPost.setTitle("asdsdsa");

        URI uri = UriComponentsBuilder.fromHttpUrl("https://jsonplaceholder.typicode.com/")
                .pathSegment("posts")
                .build()
                .toUri();

        RequestEntity<Post> request = RequestEntity.post(uri).body(randomPost);

        ResponseEntity<Post> response = restTemplate.exchange(request, Post.class);

        System.out.println(response.getBody());
    }

    @Test
    @DisplayName("Get post with userid 2")
    void get_post_with_userid() {
        RestTemplate restTemplate = new RestTemplate();
        URI uri = UriComponentsBuilder.fromHttpUrl("https://jsonplaceholder.typicode.com/")
                .pathSegment("posts")
                .query("userId=2")
                .build()
                .toUri();

        RequestEntity<Void> request = RequestEntity.get(uri).build();

        ResponseEntity<Post[]> response = restTemplate.exchange(request, Post[].class);

        System.out.println(Arrays.asList(response.getBody()));
    }

    @Test
    @DisplayName("Update comment with id 5")
    void update_comment_with_id() {
        RestTemplate restTemplate = new RestTemplate();
        Comment comment = new Comment();
        comment.setBody("asd");
        comment.setId(5L);
        comment.setEmail("adasd");
        comment.setPostId(43L);
        comment.setName("asasd");

        URI uri = UriComponentsBuilder.fromHttpUrl("https://jsonplaceholder.typicode.com/")
                .pathSegment("comments","5")
                .build()
                .toUri();


        RequestEntity<Comment> request = RequestEntity.put(uri).body(comment);

        ResponseEntity<Comment> response = restTemplate.exchange(request, Comment.class);

        System.out.println((response.getBody()));
    }

    @Test
    @DisplayName("Delete post with id 1")
    void delete_post_with_id() {
        RestTemplate restTemplate = new RestTemplate();
        URI uri = UriComponentsBuilder.fromHttpUrl("https://jsonplaceholder.typicode.com/")
                .pathSegment("posts","1")
                .build()
                .toUri();

        RequestEntity<Void> request = RequestEntity.delete(uri).build();

        ResponseEntity<Void> response = restTemplate.exchange(request, Void.class);
    }
}
