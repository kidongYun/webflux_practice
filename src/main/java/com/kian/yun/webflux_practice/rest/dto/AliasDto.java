package com.kian.yun.webflux_practice.rest.dto;

import lombok.Getter;
import lombok.Setter;

public class AliasDto {
    public static class Save {
        @Getter
        @Setter
        public static class Req {
            private String name;
            private String color;
        }
    }
}
