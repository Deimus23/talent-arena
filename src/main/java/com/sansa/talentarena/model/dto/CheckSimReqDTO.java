package com.sansa.talentarena.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class CheckSimReqDTO implements Serializable {
    private String phoneNumber;
}
