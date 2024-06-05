package com.example.deplom.mappers;

import com.example.deplom.DTOS.TripodDTO;
import com.example.deplom.models.Tripod;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.stream.Collectors;
//componentModel = "spring",
@Mapper( imports = Collectors.class)
public interface TripodMapper {
    TripodMapper INSTANCE = Mappers.getMapper(TripodMapper.class);
    Tripod toModel(TripodDTO tripodDTO);
    TripodDTO toDTO(Tripod tripod);
}
