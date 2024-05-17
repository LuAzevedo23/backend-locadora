package dev.lulu.backendlocadora.mapper;

import dev.lulu.backendlocadora.dto.CarroDTO;
import dev.lulu.backendlocadora.entity.Carro;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarroMapper {
    CarroMapper INSTANCE = Mappers.getMapper(CarroMapper.class);

    CarroDTO paraDTO(Carro carros);

    Carro paraEntity(CarroDTO carroDTO);

    List<CarroDTO> paraDTO(List<Carro> carros);

    List<Carro> paraEntity(List<CarroDTO> carroDTO);

}
