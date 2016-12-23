package ua.com.models.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.com.models.dao.SalePositionDAO;
import ua.com.models.model.SalePosition;
import ua.com.models.repository.SalePositionRepository;

/**
 * Created by Max on 12/8/2016.
 */
@Repository
public class SalePositionDAOImpl extends AbstractDaoImpl<SalePosition> implements SalePositionDAO {
    /**
     * Конструктор для инициализации основных переменных.
     * Помечаный аннотацией @Autowired, которая позволит Spring
     * автоматически инициализировать объект.
     */
    @Autowired
    public SalePositionDAOImpl(SalePositionRepository repository) {
        super(repository);
    }
}

