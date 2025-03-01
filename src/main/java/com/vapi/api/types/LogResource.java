/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.vapi.api.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum LogResource {
    ORG("org"),

    ASSISTANT("assistant"),

    ANALYTICS("analytics"),

    CREDENTIAL("credential"),

    PHONE_NUMBER("phone-number"),

    BLOCK("block"),

    VOICE_LIBRARY("voice-library"),

    PROVIDER("provider"),

    TOOL("tool"),

    TOKEN("token"),

    TEMPLATE("template"),

    SQUAD("squad"),

    CALL("call"),

    FILE("file"),

    METRIC("metric"),

    LOG("log");

    private final String value;

    LogResource(String value) {
        this.value = value;
    }

    @JsonValue
    @java.lang.Override
    public String toString() {
        return this.value;
    }
}
