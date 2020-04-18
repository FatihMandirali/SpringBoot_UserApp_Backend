package com.example.demo.model;

import com.example.demo.Entities.Users;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Example1 {
    private deneme deneme;

    @Data
    @Getter
    @Setter
    public static class  deneme{
        public String name;
    }
}
