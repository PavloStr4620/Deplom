package com.example.deplom.mappers;
import com.example.deplom.DTOS.CameraDTO;
import com.example.deplom.models.Camera;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.stream.Collectors;

@Mapper(
//        componentModel = "spring",
        imports = Collectors.class)
public interface CameraMapper {
    CameraMapper INSTANCE = Mappers.getMapper(CameraMapper.class);
    Camera toModel(CameraDTO cameraDTO);
    CameraDTO toDTO(Camera camera);
}
