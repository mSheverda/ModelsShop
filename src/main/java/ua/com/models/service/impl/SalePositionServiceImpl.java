package ua.com.models.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.models.dao.SalePositionDAO;
import ua.com.models.model.SalePosition;
import ua.com.models.service.SalePositionService;

/**
 * Created by Max on 12/8/2016.
 */
@Service
public class SalePositionServiceImpl extends MainServiceImpl<SalePosition> implements SalePositionService {

    @Autowired
    public SalePositionServiceImpl(SalePositionDAO dao) {
        super(dao);
    }
}
