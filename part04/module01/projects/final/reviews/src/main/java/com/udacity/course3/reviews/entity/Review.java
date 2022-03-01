package com.udacity.course3.reviews.entity;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Review {

    @Id
    private String id;
    private String title;
    private String text;
    @Indexed
    private Product product;
    private List<Comment> commentList = new ArrayList<>();;
}
