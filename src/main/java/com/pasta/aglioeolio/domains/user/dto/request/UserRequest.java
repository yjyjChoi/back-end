package com.pasta.aglioeolio.domains.user.dto.request;

import com.pasta.aglioeolio.config.jpa.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    private String mt_number;
    private String password;
    private String enlist_date;
    private String discharge_date;
    private String name;
    private String phone_number;
    private String rank;
    private String affiliation;
    private String profile_image;
    private Boolean blue_falcon;
    private String role;
    private Integer fail_count;
    private Boolean is_delyn;

}
