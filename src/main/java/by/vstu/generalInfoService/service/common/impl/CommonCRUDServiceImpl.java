package by.vstu.generalInfoService.service.common.impl;

import by.vstu.generalInfoService.dto.common.AbstractDTO;
import by.vstu.generalInfoService.entity.common.AbstractEntity;
import by.vstu.generalInfoService.mapper.Mapper;
import by.vstu.generalInfoService.service.common.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.lang.reflect.Field;
import java.util.List;

@Transactional
public class CommonCRUDServiceImpl
        <E extends AbstractEntity,
                D extends AbstractDTO,
                R extends JpaRepository<E, Long>
                >
        implements CRUDService<D> {

    @Autowired
    EntityManager entityManager;

    @Autowired
    private Mapper<E, D> mapper;

    @Autowired
    private R repository;

    private Class<E> clazzEntity;
    private Class<D> clazzDTO;

    public CommonCRUDServiceImpl(Class<E> clazzEntity, Class<D> clazzDTO) {
        this.clazzEntity = clazzEntity;
        this.clazzDTO = clazzDTO;
    }

    @Override
    public D findOne(long id) {
        return mapper.toDTO(repository.getOne(id), clazzDTO);
    }

    @Override
    public List<D> findAll() {
        List<E> all = repository.findAll();
        return mapper.toDTOs(all, clazzDTO);
    }

    @Override
    public D create(D dto) {
        E entity = mapper.toEntity(dto, clazzEntity);
        return mapper.toDTO(repository.saveAndFlush(entity), clazzDTO);
    }

    @Override
    public D update(Long id, D dto) {
        E saveEntity = repository.getOne(id);
        E sourceEntity = mapper.toEntity(dto, clazzEntity);

        for (Field field : sourceEntity.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Field saveField;
            try {
                saveField = saveEntity.getClass().getDeclaredField(field.getName());
                saveField.setAccessible(true);
                saveField.set(saveEntity, field.get(sourceEntity));
                saveField.setAccessible(false);
            } catch (Exception e) {
                e.printStackTrace();
                throw new IllegalArgumentException("Field exception: " + field.toString());
            }
            field.setAccessible(false);
        }
        return mapper.toDTO(repository.saveAndFlush(saveEntity), clazzDTO);
    }

    @Override
    public void delete(D dto) {
        repository.delete(mapper.toEntity(dto, clazzEntity));
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }
}
