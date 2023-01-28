package by.vstu.generalInfoService.mapper;

import by.vstu.generalInfoService.dto.common.AbstractDTO;
import by.vstu.generalInfoService.entity.common.AbstractEntity;
import org.modelmapper.ModelMapper;

import java.util.List;

public interface Mapper<E extends AbstractEntity, D extends AbstractDTO> {

    ModelMapper mapper = new ModelMapper();

    D toDTO(E entity, Class<D> type);

    E toEntity(D dto, Class<E> type);

    List<D> toDTOs(List<E> entities, Class<D> type);

    List<E> toEntities(List<D> dtos, Class<E> type);

}