package com.pasta.aglioeolio.documentation;

import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;

import static com.pasta.aglioeolio.documentation.utils.DocumentationUtils.getDocumentRequest;
import static com.pasta.aglioeolio.documentation.utils.DocumentationUtils.getDocumentResponse;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.JsonFieldType.*;
import static org.springframework.restdocs.payload.JsonFieldType.ARRAY;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;

public class UserDocumentation {

    public static RestDocumentationResultHandler findAllUser() {
        return document("user/findAllUser",
                getDocumentRequest(),
                getDocumentResponse(),
//            requestHeaders(
//                headerWithName(HttpHeaders.AUTHORIZATION).description("JWT 토큰(Bearer {jwt토큰}")
//            ),
                responseFields(
                        fieldWithPath("[].mtNumber").type(STRING).description("군번"),
                        fieldWithPath("[].password").type(STRING).description("비번")
                )
        );
    }

}
