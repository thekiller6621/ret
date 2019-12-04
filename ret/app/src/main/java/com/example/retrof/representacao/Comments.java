package com.example.retrof.representacao;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder



public class Comments {
    private Integer txtpostID;
    private Integer id;
    private String email;
    private String body;





}
