package com.pasta.aglioeolio.common.enums;

public enum RankType {
    SOLDIER("병사"),
    OFFICER("간부");

    private String rank;

    RankType(String rank) {
        this.rank = rank;
    }

}