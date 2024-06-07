package com.mycompany.pizzeriaapp.service.delivery;

import com.mycompany.pizzeriaapp.dto.DeliveryOrderDto;
import com.mycompany.pizzeriaapp.entity.DeliveryOrderEntity;
import com.mycompany.pizzeriaapp.entity.OrderPositionEntity;
import com.mycompany.pizzeriaapp.repository.ClientRepository;
import com.mycompany.pizzeriaapp.repository.OrderPositionRepository;
import com.mycompany.pizzeriaapp.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.mycompany.pizzeriaapp.Util.DeliveryOrderMapper.makeDto;
import static com.mycompany.pizzeriaapp.Util.DeliveryOrderMapper.makeEntity;

@Service
@RequiredArgsConstructor
public class DeliveryOrderService {

    private final OrderRepository orderRepository;

  public DeliveryOrderDto createDeliveryOrder(DeliveryOrderDto deliveryOrderDto) {
      DeliveryOrderEntity deliveryOrderEntity = makeEntity(deliveryOrderDto);


      DeliveryOrderEntity savedDeliveryOrderEntity = orderRepository.save(deliveryOrderEntity);


      return makeDto(savedDeliveryOrderEntity);
  }


}
