package dev.lulu.backendlocadora.mapper;

import dev.lulu.backendlocadora.dto.SeguradoraDTO;
import dev.lulu.backendlocadora.entity.Seguradora;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SeguradoraMapper {
    SeguradoraMapper INSTANCE = Mappers.getMapper(SeguradoraMapper.class);

    SeguradoraDTO paraDTO(Seguradora seguradora);

    Seguradora paraEntity(SeguradoraDTO seguradoraDTO);

    List<SeguradoraDTO> paraDTO(List<Seguradora> seguradoras);

    List<Seguradora> paraEntity(List<SeguradoraDTO> seguradoraDTO);

}
