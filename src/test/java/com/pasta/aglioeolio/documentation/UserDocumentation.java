package com.pasta.aglioeolio.documentation;

import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;

import static com.pasta.aglioeolio.documentation.utils.DocumentationUtils.getDocumentRequest;
import static com.pasta.aglioeolio.documentation.utils.DocumentationUtils.getDocumentResponse;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.JsonFieldType.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static com.pasta.aglioeolio.documentation.utils.DocumentFormatGenerator.*;

public class UserDocumentation {

    public static RestDocumentationResultHandler findAllUser() {
        return document("user/findAllUser",
            getDocumentRequest(),
            getDocumentResponse(),
//            requestHeaders(
//                headerWithName(HttpHeaders.AUTHORIZATION).description("JWT 토큰(Bearer {jwt토큰}")
//            ),
            responseFields(
                fieldWithPath("[].mt_number").type(STRING).description("군번"),
                fieldWithPath("[].password").type(STRING).description("비밀번호"),
                fieldWithPath("[].enlist_date").type(STRING).attributes(getDateFormat()).description("입대일자"),
                fieldWithPath("[].discharge_date").type(STRING).attributes(getDateFormat()).description("전역일자"),
                fieldWithPath("[].name").type(STRING).description("이름"),
                fieldWithPath("[].phone_number").type(STRING).description("핸드폰 번호"),
                fieldWithPath("[].rank").type(STRING).description("계급"),
                fieldWithPath("[].affiliation").type(STRING).description("소속"),
                fieldWithPath("[].profile_image").type(STRING).description("프로필 사진"),
                fieldWithPath("[].blue_falcon").type(BOOLEAN).description("관심병사 여부"),
                fieldWithPath("[].role").type(STRING).description("권한"),
                fieldWithPath("[].fail_count").type(NUMBER).description("로그인 실패 카운트"),
                fieldWithPath("[].is_delyn").type(BOOLEAN).description("삭제 여부")
            )
        );
    }

    public static RestDocumentationResultHandler findUserById() {
        return document("user/findUserById",
            getDocumentRequest(),
            getDocumentResponse(),
            pathParameters(
                parameterWithName("userId").description("유저 id")
            ),
            responseFields(
                fieldWithPath("mt_number").type(STRING).description("군번"),
                fieldWithPath("password").type(STRING).description("비밀번호"),
                fieldWithPath("enlist_date").type(STRING).attributes(getDateFormat()).description("입대일자"),
                fieldWithPath("discharge_date").type(STRING).attributes(getDateFormat()).description("전역일자"),
                fieldWithPath("name").type(STRING).description("이름"),
                fieldWithPath("phone_number").type(STRING).description("핸드폰 번호"),
                fieldWithPath("rank").type(STRING).description("계급"),
                fieldWithPath("affiliation").type(STRING).description("소속"),
                fieldWithPath("profile_image").type(STRING).description("프로필 사진"),
                fieldWithPath("blue_falcon").type(BOOLEAN).description("관심병사 여부"),
                fieldWithPath("role").type(STRING).description("권한"),
                fieldWithPath("fail_count").type(NUMBER).description("로그인 실패 카운트"),
                fieldWithPath("is_delyn").type(BOOLEAN).description("삭제 여부")
            )
        );
    }

    public static RestDocumentationResultHandler createUser() {
        return document("user/createUser",
            getDocumentRequest(),
            getDocumentResponse(),
            requestFields(
                fieldWithPath("mt_number").type(STRING).description("군번"),
                fieldWithPath("password").type(STRING).description("비밀번호"),
                fieldWithPath("enlist_date").type(STRING).attributes(getDateFormat()).description("입대일자"),
                fieldWithPath("discharge_date").type(STRING).attributes(getDateFormat()).description("전역일자"),
                fieldWithPath("name").type(STRING).description("이름"),
                fieldWithPath("phone_number").type(STRING).description("핸드폰 번호"),
                fieldWithPath("rank").type(STRING).description("계급"),
                fieldWithPath("affiliation").type(STRING).description("소속"),
                fieldWithPath("profile_image").type(STRING).description("프로필 사진")
            ),
            responseFields(
                fieldWithPath("mt_number").type(STRING).description("군번"),
                fieldWithPath("password").type(STRING).description("비밀번호"),
                fieldWithPath("enlist_date").type(STRING).attributes(getDateFormat()).description("입대일자"),
                fieldWithPath("discharge_date").type(STRING).attributes(getDateFormat()).description("전역일자"),
                fieldWithPath("name").type(STRING).description("이름"),
                fieldWithPath("phone_number").type(STRING).description("핸드폰 번호"),
                fieldWithPath("rank").type(STRING).description("계급"),
                fieldWithPath("affiliation").type(STRING).description("소속"),
                fieldWithPath("profile_image").type(STRING).description("프로필 사진")
            )
        );
    }

    public static RestDocumentationResultHandler updateUser() {
        return document("user/updateUser",
            getDocumentRequest(),
            getDocumentResponse(),
            pathParameters(
                parameterWithName("userId").description("유저 id")
            ),
            requestFields(
                fieldWithPath("mt_number").type(STRING).description("군번"),
                fieldWithPath("password").type(STRING).description("비밀번호"),
                fieldWithPath("enlist_date").type(STRING).attributes(getDateFormat()).description("입대일자"),
                fieldWithPath("discharge_date").type(STRING).attributes(getDateFormat()).description("전역일자"),
                fieldWithPath("name").type(STRING).description("이름"),
                fieldWithPath("phone_number").type(STRING).description("핸드폰 번호"),
                fieldWithPath("rank").type(STRING).description("계급"),
                fieldWithPath("affiliation").type(STRING).description("소속"),
                fieldWithPath("profile_image").type(STRING).description("프로필 사진"),
                fieldWithPath("blue_falcon").type(BOOLEAN).description("관심병사 여부"),
                fieldWithPath("role").type(STRING).description("권한"),
                fieldWithPath("fail_count").type(NUMBER).description("로그인 실패 카운트"),
                fieldWithPath("is_delyn").type(BOOLEAN).description("삭제 여부")
            ),
            responseFields(
                fieldWithPath("mt_number").type(STRING).description("군번"),
                fieldWithPath("password").type(STRING).description("비밀번호"),
                fieldWithPath("enlist_date").type(STRING).attributes(getDateFormat()).description("입대일자"),
                fieldWithPath("discharge_date").type(STRING).attributes(getDateFormat()).description("전역일자"),
                fieldWithPath("name").type(STRING).description("이름"),
                fieldWithPath("phone_number").type(STRING).description("핸드폰 번호"),
                fieldWithPath("rank").type(STRING).description("계급"),
                fieldWithPath("affiliation").type(STRING).description("소속"),
                fieldWithPath("profile_image").type(STRING).description("프로필 사진"),
                fieldWithPath("blue_falcon").type(BOOLEAN).description("관심병사 여부"),
                fieldWithPath("role").type(STRING).description("권한"),
                fieldWithPath("fail_count").type(NUMBER).description("로그인 실패 카운트"),
                fieldWithPath("is_delyn").type(BOOLEAN).description("삭제 여부")
            )
        );
    }

    public static RestDocumentationResultHandler deleteUser() {
        return document("user/deleteUser",
            getDocumentRequest(),
            getDocumentResponse(),
            pathParameters(
                parameterWithName("userId").description("유저 id")
            )
        );
    }

}
