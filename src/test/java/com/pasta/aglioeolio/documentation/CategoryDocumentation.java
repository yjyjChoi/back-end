package com.pasta.aglioeolio.documentation;

import static com.pasta.aglioeolio.documentation.utils.DocumentationUtils.getDocumentRequest;
import static com.pasta.aglioeolio.documentation.utils.DocumentationUtils.getDocumentResponse;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.JsonFieldType.NUMBER;
import static org.springframework.restdocs.payload.JsonFieldType.STRING;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;

import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;

public class CategoryDocumentation {

    public static RestDocumentationResultHandler findCategories() {
        return document("category/findCategories",
            getDocumentRequest(),
            getDocumentResponse(),
//            requestHeaders(
//                headerWithName(HttpHeaders.AUTHORIZATION).description("JWT 토큰(Bearer {jwt토큰}")
//            ),
            responseFields(
                fieldWithPath("[].id").type(NUMBER).description("카테고리 인덱스"),
                fieldWithPath("[].name").type(STRING).description("카테고리 이름")
            )
        );
    }

}