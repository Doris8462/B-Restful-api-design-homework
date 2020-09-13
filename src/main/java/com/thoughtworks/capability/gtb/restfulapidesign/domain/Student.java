package com.thoughtworks.capability.gtb.restfulapidesign.domain;

import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Integer id;
    @NotNull
    private String name;
    @NotNull
    private String gender;
    private String note;
}
