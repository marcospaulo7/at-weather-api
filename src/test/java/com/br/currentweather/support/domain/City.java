package com.br.currentweather.support.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class City {

    private String id;
    private String cityName;
    private String countryCode;
    private String latitude;
    private String longitude;
    private String zipCode;
    private String units;
}
