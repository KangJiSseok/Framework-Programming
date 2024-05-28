package org.tukorea.free.domain;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;


@Setter
@Getter
public class PostVO {
    private int post_num;
    private String mem_id;
    private String post_title;
    private String post_content;
    private Timestamp post_uploadtime;

    @Override
    public String toString() {
        return "PostVO{" +
                "post_num=" + post_num +
                ", mem_id='" + mem_id + '\'' +
                ", post_title='" + post_title + '\'' +
                ", post_content='" + post_content + '\'' +
                ", post_uploadtime=" + post_uploadtime +
                '}';
    }

    public int getPost_num() {
        return post_num;
    }

    public void setPost_num(int post_num) {
        this.post_num = post_num;
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

    public Timestamp getPost_uploadtime() {
        return post_uploadtime;
    }

    public void setPost_uploadtime(Timestamp post_uploadtime) {
        this.post_uploadtime = post_uploadtime;
    }
}
