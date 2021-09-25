package com.pasta.aglioeolio.domains.user.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponse {

    private String mtNumber;
    private String password;
    private String enlistDate;
    private String dischargeDate;
    private String name;
    private String phoneNumber;
    private String rank;
    private String affiliation;
    private String profileImage;
    private Boolean blueFalcon;
    private String role;
    private Integer failCount;
    private Boolean isDelyn;
    
}
