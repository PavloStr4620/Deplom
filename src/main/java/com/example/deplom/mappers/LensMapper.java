package com.example.deplom.mappers;

import com.example.deplom.DTOS.LensDTO;
import com.example.deplom.models.Lens;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.stream.Collectors;

@Mapper(imports = Collectors.class)
public interface LensMapper {
    LensMapper INSTANCE = Mappers.getMapper(LensMapper.class);
    Lens toModel(LensDTO lensDTO);
    LensDTO toDTO(Lens lens);
}
