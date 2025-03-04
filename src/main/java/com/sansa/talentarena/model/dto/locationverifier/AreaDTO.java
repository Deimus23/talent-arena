package com.sansa.talentarena.model.dto.locationverifier;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AreaDTO {
    private final String areaType = "CIRCLE";
    private final int radius = 20000;
    private final CenterDTO center;
}
