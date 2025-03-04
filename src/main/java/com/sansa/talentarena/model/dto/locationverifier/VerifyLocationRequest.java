package com.sansa.talentarena.model.dto.locationverifier;


import lombok.Data;

@Data
public class VerifyLocationRequest {
    private DeviceDTO device;
    private AreaDTO area;
    private final int maxAge = 60;

    public VerifyLocationRequest(String phoneNumber, float latitude, float longitude) {
        this.device = new DeviceDTO(phoneNumber);
        CenterDTO center = new CenterDTO(latitude, longitude);
        this.area = new AreaDTO(center);
    }

}
