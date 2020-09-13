package com.thoughtworks.capability.gtb.restfulapidesign.domain;

import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Team {
    @NotNull
    private Integer teamId;
    @NotNull
    private String teamName;
    private String teamNote;
    private List<Student> students;
}
