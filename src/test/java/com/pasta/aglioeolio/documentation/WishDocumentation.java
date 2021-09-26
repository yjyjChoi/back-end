package com.pasta.aglioeolio.documentation;

import static com.pasta.aglioeolio.documentation.utils.DocumentationUtils.getDocumentRequest;
import static com.pasta.aglioeolio.documentation.utils.DocumentationUtils.getDocumentResponse;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.JsonFieldType.ARRAY;
import static org.springframework.restdocs.payload.JsonFieldType.BOOLEAN;
import static org.springframework.restdocs.payload.JsonFieldType.NUMBER;
import static org.springframework.restdocs.payload.JsonFieldType.STRING;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;

import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;

public class WishDocumentation {

    public static RestDocumentationResultHandler findAllWish() {
        return document("wish/findAllWish",
            getDocumentRequest(),
            getDocumentResponse(),
//            requestHeaders(
//                headerWithName(HttpHeaders.AUTHORIZATION).description("JWT 토큰(Bearer {jwt토큰}")
//            ),
            responseFields(
                fieldWithPath("[].id").type(NUMBER).description("소원 인덱스"),
                fieldWithPath("[].title").type(STRING).description("제목"),
                fieldWithPath("[].content").type(STRING).description("내용"),
                fieldWithPath("[].round").type(NUMBER).description("차수"),
                fieldWithPath("[].isAnonymous").type(BOOLEAN).description("익명여부"),
                fieldWithPath("[].categoryName").type(STRING).description("카테고리 이름"),
                //fieldWithPath("[].verificationSoldier").type(BOOLEAN).description("간부 확인여부").optional(),
//                fieldWithPath("[].officers").type(ARRAY).description("지정 간부 인덱스").optional(),
                fieldWithPath("[].user.mtNumber").type(STRING).description("병사 군번").optional(),
                fieldWithPath("[].user.name").type(STRING).description("병사 이름").optional(),
                fieldWithPath("[].user.rank").type(STRING).description("병사 계급").optional(),
                fieldWithPath("[].user.affiliation").type(STRING).description("병사 소속").optional(),
                fieldWithPath("[].user.profileImage").type(STRING).description("병사 사진").optional()
            )
        );
    }

    public static RestDocumentationResultHandler findWishById() {
        return document("wish/findWishById",
            getDocumentRequest(),
            getDocumentResponse(),
//            requestHeaders(
//                headerWithName(HttpHeaders.AUTHORIZATION).description("JWT 토큰(Bearer {jwt토큰}")
//            ),
            pathParameters(
                parameterWithName("wishId").description("소원 id")
            ),
            responseFields(
                fieldWithPath("id").type(NUMBER).description("소원 인덱스"),
                fieldWithPath("title").type(STRING).description("제목"),
                fieldWithPath("content").type(STRING).description("내용"),
                fieldWithPath("round").type(NUMBER).description("차수"),
                fieldWithPath("isAnonymous").type(BOOLEAN).description("익명여부"),
                fieldWithPath("categoryName").type(STRING).description("카테고리 이름"),
//                fieldWithPath("verificationSoldier").type(BOOLEAN).description("간부 확인여부"),
//                fieldWithPath("officers").type(ARRAY).description("지정 간부 인덱스").optional()
                fieldWithPath("user.mtNumber").type(STRING).description("병사 군번").optional(),
                fieldWithPath("user.name").type(STRING).description("병사 이름").optional(),
                fieldWithPath("user.rank").type(STRING).description("병사 계급").optional(),
                fieldWithPath("user.affiliation").type(STRING).description("병사 소속").optional(),
                fieldWithPath("user.profileImage").type(STRING).description("병사 사진").optional()
            )
        );
    }

    public static RestDocumentationResultHandler createWish() {
        return document("wish/createWish",
            getDocumentRequest(),
            getDocumentResponse(),
//            requestHeaders(
//                headerWithName(HttpHeaders.AUTHORIZATION).description("JWT 토큰(Bearer {jwt토큰}")
//            ),
            requestFields(
                fieldWithPath("title").type(STRING).description("제목").optional(),
                fieldWithPath("content").type(STRING).description("내용"),
                fieldWithPath("round").type(NUMBER).description("차수"),
                fieldWithPath("isAnonymous").type(BOOLEAN).description("익명 여부"),
                fieldWithPath("categoryId").type(NUMBER).description("카테고리 인덱스"),
                fieldWithPath("officers").type(ARRAY).description("지정 간부 인덱스")
            ),
            responseFields(
                fieldWithPath("id").type(NUMBER).description("소원 인덱스"),
                fieldWithPath("title").type(STRING).description("제목"),
                fieldWithPath("content").type(STRING).description("내용"),
                fieldWithPath("round").type(NUMBER).description("차수"),
                fieldWithPath("isAnonymous").type(BOOLEAN).description("익명여부"),
                fieldWithPath("categoryName").type(STRING).description("카테고리 이름"),
//                fieldWithPath("verificationSoldier").type(BOOLEAN).description("간부 확인여부"),
//                fieldWithPath("officers").type(ARRAY).description("지정 간부 인덱스")
                fieldWithPath("user.mtNumber").type(STRING).description("병사 군번").optional(),
                fieldWithPath("user.name").type(STRING).description("병사 이름").optional(),
                fieldWithPath("user.rank").type(STRING).description("병사 계급").optional(),
                fieldWithPath("user.affiliation").type(STRING).description("병사 소속").optional(),
                fieldWithPath("user.profileImage").type(STRING).description("병사 사진").optional()
            )
        );
    }

    public static RestDocumentationResultHandler updateWish() {
        return document("wish/updateWish",
            getDocumentRequest(),
            getDocumentResponse(),
//            requestHeaders(
//                headerWithName(HttpHeaders.AUTHORIZATION).description("JWT 토큰(Bearer {jwt토큰}")
//            ),
            pathParameters(
                parameterWithName("wishId").description("소원 id")
            ),
            requestFields(
                fieldWithPath("title").type(STRING).description("제목").optional(),
                fieldWithPath("content").type(STRING).description("내용").optional(),
                fieldWithPath("round").type(NUMBER).description("차수"),
                fieldWithPath("isAnonymous").type(BOOLEAN).description("익명 여부"),
                fieldWithPath("categoryId").type(NUMBER).description("카테고리 인덱스"),
                fieldWithPath("officers").type(ARRAY).description("지정 간부 인덱스")
            ),
            responseFields(
                fieldWithPath("id").type(NUMBER).description("소원 인덱스"),
                fieldWithPath("title").type(STRING).description("제목"),
                fieldWithPath("content").type(STRING).description("내용"),
                fieldWithPath("round").type(NUMBER).description("차수"),
                fieldWithPath("isAnonymous").type(BOOLEAN).description("익명여부"),
                fieldWithPath("categoryName").type(STRING).description("카테고리 이름"),
//                fieldWithPath("verificationSoldier").type(BOOLEAN).description("간부 확인여부"),
//                fieldWithPath("officers").type(ARRAY).description("지정 간부 인덱스")
                fieldWithPath("user.mtNumber").type(STRING).description("병사 군번").optional(),
                fieldWithPath("user.name").type(STRING).description("병사 이름").optional(),
                fieldWithPath("user.rank").type(STRING).description("병사 계급").optional(),
                fieldWithPath("user.affiliation").type(STRING).description("병사 소속").optional(),
                fieldWithPath("user.profileImage").type(STRING).description("병사 사진").optional()
            )
        );
    }

    public static RestDocumentationResultHandler deleteWish() {
        return document("wish/deleteWish",
            getDocumentRequest(),
            getDocumentResponse(),
//            requestHeaders(
//                headerWithName(HttpHeaders.AUTHORIZATION).description("JWT 토큰(Bearer {jwt토큰}")
//            )
            pathParameters(
                parameterWithName("wishId").description("소원 id")
            )
        );
    }

    public static RestDocumentationResultHandler verificationWishBySoldier() {
        return document("wish/verificationWishBySoldier",
            getDocumentRequest(),
            getDocumentResponse(),
//            requestHeaders(
//                headerWithName(HttpHeaders.AUTHORIZATION).description("JWT 토큰(Bearer {jwt토큰}")
//            )
            requestFields(
                fieldWithPath("wishIds").type(ARRAY).description("간부가 확인한 소원 인덱스")
            )
        );
    }

}
