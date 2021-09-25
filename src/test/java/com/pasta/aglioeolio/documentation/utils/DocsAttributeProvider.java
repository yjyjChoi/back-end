package com.pasta.aglioeolio.documentation.utils;

import static org.springframework.restdocs.snippet.Attributes.key;

import org.springframework.restdocs.snippet.Attributes;

/**
 * Rest docs에서 속성을 추가할 경우 속성 정의 후 사용
 * fieldWithPath("serviceType").type(JsonFieldType.STRING).description("서비스 종류").attributes(getExampleAttribute("HAIR")),
 */
public interface DocsAttributeProvider {
    static Attributes.Attribute getExampleAttribute(Object example) {
        return key("example").value(example);
    }
}