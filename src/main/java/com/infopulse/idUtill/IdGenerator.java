package com.infopulse.idUtill;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.UUID;

public class IdGenerator implements IdentifierGenerator {
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        UUID randomUUID = UUID.randomUUID();
        String genId = randomUUID.toString().replaceAll("-", "");
        return String.format("%s-%s-%s", genId.substring(0, 4), genId.substring(5, 9), genId.substring(10, 14));
    }
}
