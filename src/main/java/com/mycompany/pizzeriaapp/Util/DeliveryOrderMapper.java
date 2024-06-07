package com.mycompany.pizzeriaapp.Util;

import com.mycompany.pizzeriaapp.dto.DeliveryOrderDto;
import com.mycompany.pizzeriaapp.entity.DeliveryOrderEntity;

import static com.mycompany.pizzeriaapp.Util.ClientMapper.mapToDto;
import static com.mycompany.pizzeriaapp.Util.ClientMapper.mapToEntity;

public class DeliveryOrderMapper {

    public static DeliveryOrderDto makeDto(DeliveryOrderEntity deliveryOrderEntity) {
        return DeliveryOrderDto.builder()
                .id(deliveryOrderEntity.getId())
                .timeOrderAcceptance(deliveryOrderEntity.getTimeOrderAcceptance())
                .timeOrderCreated(deliveryOrderEntity.getTimeOrderCreated())
                .timeToDelivery(deliveryOrderEntity.getTimeToDelivery())
                .paymentType(deliveryOrderEntity.getPaymentType())
                .orderPositionEntities(deliveryOrderEntity.getOrderPositionEntities())
                .comment(deliveryOrderEntity.getComment())
                .clientDto(mapToDto(deliveryOrderEntity.getClientEntity()))
                .build();

    }


    public static DeliveryOrderEntity makeEntity(DeliveryOrderDto deliveryOrderDto) {
        return DeliveryOrderEntity.builder()
                .id(deliveryOrderDto.getId())
                .timeOrderAcceptance(deliveryOrderDto.getTimeOrderAcceptance())
                .timeOrderCreated(deliveryOrderDto.getTimeOrderCreated())
                .timeToDelivery(deliveryOrderDto.getTimeToDelivery())
                .paymentType(deliveryOrderDto.getPaymentType())
                .orderPositionEntities(deliveryOrderDto.getOrderPositionEntities())
                .comment(deliveryOrderDto.getComment())
                .clientEntity(mapToEntity(deliveryOrderDto.getClientDto()))
                .build();
    }
}
