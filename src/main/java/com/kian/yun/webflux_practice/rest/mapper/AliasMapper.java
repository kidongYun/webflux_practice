package com.kian.yun.webflux_practice.rest.mapper;

import com.kian.yun.webflux_practice.domain.Alias;
import com.kian.yun.webflux_practice.rest.dto.AliasDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AliasMapper {
    Alias toDomain(AliasDto.Save.Req from);
}
