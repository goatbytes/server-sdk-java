/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.vapi.api.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.vapi.api.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = UpdateVonageCredentialDto.Builder.class)
public final class UpdateVonageCredentialDto {
    private final Optional<String> apiSecret;

    private final Optional<String> name;

    private final Optional<String> apiKey;

    private final Map<String, Object> additionalProperties;

    private UpdateVonageCredentialDto(
            Optional<String> apiSecret,
            Optional<String> name,
            Optional<String> apiKey,
            Map<String, Object> additionalProperties) {
        this.apiSecret = apiSecret;
        this.name = name;
        this.apiKey = apiKey;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return This is not returned in the API.
     */
    @JsonProperty("apiSecret")
    public Optional<String> getApiSecret() {
        return apiSecret;
    }

    /**
     * @return This is the name of credential. This is just for your reference.
     */
    @JsonProperty("name")
    public Optional<String> getName() {
        return name;
    }

    @JsonProperty("apiKey")
    public Optional<String> getApiKey() {
        return apiKey;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof UpdateVonageCredentialDto && equalTo((UpdateVonageCredentialDto) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(UpdateVonageCredentialDto other) {
        return apiSecret.equals(other.apiSecret) && name.equals(other.name) && apiKey.equals(other.apiKey);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.apiSecret, this.name, this.apiKey);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> apiSecret = Optional.empty();

        private Optional<String> name = Optional.empty();

        private Optional<String> apiKey = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(UpdateVonageCredentialDto other) {
            apiSecret(other.getApiSecret());
            name(other.getName());
            apiKey(other.getApiKey());
            return this;
        }

        @JsonSetter(value = "apiSecret", nulls = Nulls.SKIP)
        public Builder apiSecret(Optional<String> apiSecret) {
            this.apiSecret = apiSecret;
            return this;
        }

        public Builder apiSecret(String apiSecret) {
            this.apiSecret = Optional.ofNullable(apiSecret);
            return this;
        }

        @JsonSetter(value = "name", nulls = Nulls.SKIP)
        public Builder name(Optional<String> name) {
            this.name = name;
            return this;
        }

        public Builder name(String name) {
            this.name = Optional.ofNullable(name);
            return this;
        }

        @JsonSetter(value = "apiKey", nulls = Nulls.SKIP)
        public Builder apiKey(Optional<String> apiKey) {
            this.apiKey = apiKey;
            return this;
        }

        public Builder apiKey(String apiKey) {
            this.apiKey = Optional.ofNullable(apiKey);
            return this;
        }

        public UpdateVonageCredentialDto build() {
            return new UpdateVonageCredentialDto(apiSecret, name, apiKey, additionalProperties);
        }
    }
}
