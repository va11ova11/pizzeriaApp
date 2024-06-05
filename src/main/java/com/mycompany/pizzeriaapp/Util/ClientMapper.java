package com.mycompany.pizzeriaapp.Util;

import com.mycompany.pizzeriaapp.dto.ClientDto;
import com.mycompany.pizzeriaapp.entity.ClientEntity;

public class ClientMapper {
    public static ClientEntity mapToEntity(ClientDto clientDto) {
        return ClientEntity.builder()
                .id(clientDto.getId())
                .name(clientDto.getName())
                .clientPhoneNumber(clientDto.getClientPhoneNumber())
                .numberOfCutlery(clientDto.getNumberOfCutlery())
                .address(clientDto.getAddress())
                .build();
    }

    public static ClientDto mapToDto(ClientEntity clientEntity) {
        return ClientDto.builder()
                .id(clientEntity.getId())
                .name(clientEntity.getName())
                .clientPhoneNumber(clientEntity.getClientPhoneNumber())
                .address(clientEntity.getAddress())
                .numberOfCutlery(clientEntity.getNumberOfCutlery())
                .build();
    }
}
