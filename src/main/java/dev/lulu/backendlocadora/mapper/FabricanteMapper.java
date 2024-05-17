package dev.lulu.backendlocadora.mapper;

import dev.lulu.backendlocadora.dto.FabricanteDTO;
import dev.lulu.backendlocadora.entity.Fabricante;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FabricanteMapper {
    FabricanteMapper INSTANCE = Mappers.getMapper(FabricanteMapper.class);

    FabricanteDTO paraDTO(Fabricante fabricante);

    Fabricante paraEntity(FabricanteDTO fabricanteDTO);

    List<FabricanteDTO> paraDTO(List<Fabricante> fabricantes);

    List<Fabricante> paraEntity(List<FabricanteDTO> fabricanteDTO);

}
