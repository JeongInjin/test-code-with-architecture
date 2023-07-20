package com.me.injin.testcodewithwitharchitecture.common.infrastructure;

import com.me.injin.testcodewithwitharchitecture.common.service.port.UuidHolder;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SystemUuidHolder implements UuidHolder {
    @Override
    public String random() {
        return UUID.randomUUID().toString();
    }
}
