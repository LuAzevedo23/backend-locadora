package dev.lulu.backendlocadora.mapper;

import dev.lulu.backendlocadora.dto.ClienteDTO;
import dev.lulu.backendlocadora.entity.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    ClienteDTO paraDTO(Cliente cliente);

    Cliente paraEntity(ClienteDTO clienteDTO);

    List<ClienteDTO> paraDTO(List<Cliente> clientes);

    List<Cliente> paraEntity(List<ClienteDTO> clienteDTO);

}
