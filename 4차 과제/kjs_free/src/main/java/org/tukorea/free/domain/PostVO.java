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
}
