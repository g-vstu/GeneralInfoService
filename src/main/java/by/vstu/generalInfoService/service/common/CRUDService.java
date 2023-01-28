package by.vstu.generalInfoService.service.common;


import by.vstu.generalInfoService.dto.common.AbstractDTO;

import java.util.List;

public interface CRUDService<D extends AbstractDTO> {

    public D findOne(long id);

    public List<D> findAll();

    public D create(D dto);

    public D update(Long id, D dto);

    public void delete(D dto);

    public void deleteById(long id);
}
