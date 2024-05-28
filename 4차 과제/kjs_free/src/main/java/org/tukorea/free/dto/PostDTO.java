package org.tukorea.free.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDTO {

    private String mem_id;
    private String post_title;
    private String post_content;

    public PostDTO(String mem_id, String post_title, String post_content) {
        this.mem_id = mem_id;
        this.post_title = post_title;
        this.post_content = post_content;
    }

    @Override
    public String toString() {
        return "PostDTO{" +
                "mem_id='" + mem_id + '\'' +
                ", post_title='" + post_title + '\'' +
                ", post_content='" + post_content + '\'' +
                '}';
    }

    public String getMem_id() {
        return mem_id;
    }

    public void setMem_id(String mem_id) {
        this.mem_id = mem_id;
    }

    public String getPost_title() {
        return post_title;
    }

    public void setPost_title(String post_title) {
        this.post_title = post_title;
    }

    public String getPost_content() {
        return post_content;
    }

    public void setPost_content(String post_content) {
        this.post_content = post_content;
    }
}
