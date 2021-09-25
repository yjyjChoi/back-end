package com.pasta.aglioeolio.documentation.utils;

import static org.springframework.restdocs.snippet.Attributes.key;

import org.springframework.restdocs.snippet.Attributes;

public class DocumentFormatGenerator {

    public static Attributes.Attribute getDateFormat() {
        return key("format").value("yyyy-MM-dd");
    }

    /**
     * // 사용
     * fieldWithPath("race_duration.start_date").type(STRING)
     *                     .attributes(getDateFormat())
     *                     .description("Race 시작 날짜"),
     */

}