package com.demo.SpringSecurityTest.genericResponse;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenericResponse<T> {
    private Integer status;
    private String msg;
    private T data;
}
