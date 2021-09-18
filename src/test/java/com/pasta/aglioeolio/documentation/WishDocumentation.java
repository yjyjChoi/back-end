package com.pasta.aglioeolio.documentation;

import static com.pasta.aglioeolio.documentation.utils.DocumentationUtils.getDocumentRequest;
import static com.pasta.aglioeolio.documentation.utils.DocumentationUtils.getDocumentResponse;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
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
//                headerWithName(HttpHeaders.CONTENT_TYPE).description("Content-type")
//            ),
//            pathParameters(
//                parameterWithName("postId").description("포스트 id")
//            ),
//              requestFields(
//                fieldWithPath("name").description("프로필로 사용할 이름"),
//                fieldWithPath("socialId").description("소셜 로그인 ID")
//              ),
            responseFields(
                fieldWithPath("[].title").type(STRING).description("제목"),
                fieldWithPath("[].content").type(STRING).description("내용")
            )
        );
    }

    public static RestDocumentationResultHandler findWishById() {
        return document("wish/findWishById",
            getDocumentRequest(),
            getDocumentResponse(),
            pathParameters(
                parameterWithName("wishId").description("소원 id")
            ),
            responseFields(
                fieldWithPath("title").type(STRING).description("제목"),
                fieldWithPath("content").type(STRING).description("내용")
            )
        );
    }

    public static RestDocumentationResultHandler createWish() {
        return document("wish/createWish",
            getDocumentRequest(),
            getDocumentResponse(),
            requestFields(
                fieldWithPath("title").type(STRING).description("제목"),
                fieldWithPath("content").type(STRING).description("내용")
            ),
            responseFields(
                fieldWithPath("title").type(STRING).description("제목"),
                fieldWithPath("content").type(STRING).description("내용")
            )
        );
    }

}