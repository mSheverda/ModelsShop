package ua.com.models.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.models.dao.StatusDAO;
import ua.com.models.enums.StatusEnum;
import ua.com.models.model.Status;
import ua.com.models.service.StatusService;

/**
 * Created by Max on 12/9/2016.
 */
@Service
public class StatusServiceImpl extends MainServiceImpl<Status> implements StatusService {

    private final StatusDAO dao;

    @Autowired
    public StatusServiceImpl(StatusDAO dao) {
        super(dao);
        this.dao = dao;
    }

    @Override
    @Transactional
    public void add(StatusEnum title, String description)
    {
        this.dao.add(new Status(title, description));
    }

    @Override
    @Transactional(readOnly = true)
    public Status get(StatusEnum title)
    {
        Status status = this.dao.get(title);
        return status;
    }

    @Override
    @Transactional(readOnly = true)
    public Status getDefault()
    {
        Status status = this.dao.getDefault();
        return status;
    }

    @Override
    @Transactional
    public void remove(StatusEnum title)
    {
        this.dao.remove(title);
    }
}
