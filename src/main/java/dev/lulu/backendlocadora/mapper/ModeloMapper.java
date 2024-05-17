package dev.lulu.backendlocadora.mapper;

import dev.lulu.backendlocadora.dto.ModeloDTO;
import dev.lulu.backendlocadora.entity.Modelo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ModeloMapper {
    ModeloMapper INSTANCE = Mappers.getMapper(ModeloMapper.class);

    ModeloDTO paraDTO(Modelo modelo);

    Modelo paraEntity(ModeloDTO modeloDTO);

    List<ModeloDTO> paraDTO(List<Modelo> modelos);

    List<Modelo> paraEntity(List<ModeloDTO> modeloDTO);

}
