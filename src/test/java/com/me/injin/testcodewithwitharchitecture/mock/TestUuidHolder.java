package com.me.injin.testcodewithwitharchitecture.mock;

import com.me.injin.testcodewithwitharchitecture.common.service.port.UuidHolder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TestUuidHolder implements UuidHolder {

    private final String uuid;

    @Override
    public String random() {
        return uuid;
    }
}
