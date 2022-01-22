package app.controllers;


import app.controller.PostController;
import app.entity.Comment;
import app.entity.Post;
import app.services.PostService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@WebMvcTest(PostController.class)
public class PostControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostService service;

    @Test
    void testget() throws Exception {
        ArrayList<Comment> comments = new ArrayList<>();
        Post post =    Post.builder()
                .id(1L)
                .title("title")
                .comments(comments)
                .content("content")
                .star(false)
                .build();
        when(service.getPosts(null, null)).thenReturn(List.of(post));

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/v1/posts")
                ).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].title").value("title"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].content").value("content"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].star").value(false));
    }

    @Test
    void testPost() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/api/v1/posts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{" +
                                "  \"id\": 1," +
                                "  \"title\": \"title 1\"," +
                                "  \"content\": \"content\"," +
                                "  \"star\":false" +
                                "}")
                ).andExpect(MockMvcResultMatchers.status().isOk());

        verify(service).savePost(any(Post.class));
    }

    @Test
    void testDelete() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.delete("/api/v1/posts/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(service, times(1)).deletePost(1L);
    }

    @Test
    void testPut() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/posts/1")
                        .contentType(MediaType.APPLICATION_JSON).content("{" +
                                "  \"id\": 1," +
                                "  \"title\": \"title 1\"," +
                                "  \"content\": \"content\"," +
                                "  \"star\":false" +
                                "}"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(service, times(1));
    }

}
