package com.brightest.study.springboot.web.dto;

import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void 롬복_테스트(){
        String name = "test";
        int amount = 1000;

        HelloResponseDto helloResponseDto = new HelloResponseDto(name, amount);

        assertThat(helloResponseDto.getName()).isEqualTo(name);
        assertThat(helloResponseDto.getAmount()).isEqualTo(amount);

    }
}
