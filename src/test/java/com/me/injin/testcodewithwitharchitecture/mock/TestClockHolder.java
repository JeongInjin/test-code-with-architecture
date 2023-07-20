package com.me.injin.testcodewithwitharchitecture.mock;

import com.me.injin.testcodewithwitharchitecture.common.service.port.ClockHolder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TestClockHolder implements ClockHolder {

    private final long millis;

    @Override
    public long millis() {
        return millis;
    }
}
