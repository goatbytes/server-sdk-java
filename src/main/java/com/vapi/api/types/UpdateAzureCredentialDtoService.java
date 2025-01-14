/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.vapi.api.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum UpdateAzureCredentialDtoService {
    SPEECH("speech"),

    BLOB_STORAGE("blob_storage");

    private final String value;

    UpdateAzureCredentialDtoService(String value) {
        this.value = value;
    }

    @JsonValue
    @java.lang.Override
    public String toString() {
        return this.value;
    }
}
