package com.example.blogService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class Blog {
    private Integer id;

    private String title;

    private String content;

    private String category;

    private String createTime;

    private Long likes;

    public void timeSwitch() {
        this.setCreateTime(this.getCreateTime().substring(0,10));
    }
}
