package com.kian.yun.webflux_practice.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Alias {
    @Id
    private Long id;
    private String bankCd;
    private String acno;
    private String alsNm;
}
