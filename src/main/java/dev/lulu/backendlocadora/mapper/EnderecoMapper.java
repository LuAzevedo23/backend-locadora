package dev.lulu.backendlocadora.mapper;

import dev.lulu.backendlocadora.dto.EnderecoDTO;
import dev.lulu.backendlocadora.entity.Endereco;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EnderecoMapper {
    EnderecoMapper INSTANCE = Mappers.getMapper(EnderecoMapper.class);

    EnderecoDTO paraDTO(Endereco endereco);

    Endereco paraEntity(EnderecoDTO enderecoDTO);

    List<EnderecoDTO> paraDTO(List<Endereco> enderecos);

    List<Endereco> paraEntity(List<EnderecoDTO> clienteDTO);

}
