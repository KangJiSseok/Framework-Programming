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
}
