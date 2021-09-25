package com.pasta.aglioeolio.domains.user.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {

    private String mtNumber;
    private String password;
    private String enlistDate;
    private String dischargeDate;
    private String name;
    private String phoneNumber;
    private String rank;
    private String affiliation;
    private String profileImage;
//    private Boolean blue_falcon;
//    private String role;
//    private Integer fail_count;
//    private Boolean is_delyn;

}
