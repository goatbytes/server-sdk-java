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
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = CreateCustomLlmCredentialDto.Builder.class)
public final class CreateCustomLlmCredentialDto {
    private final String apiKey;

    private final Optional<OAuth2AuthenticationPlan> authenticationPlan;

    private final Optional<String> name;

    private final Map<String, Object> additionalProperties;

    private CreateCustomLlmCredentialDto(
            String apiKey,
            Optional<OAuth2AuthenticationPlan> authenticationPlan,
            Optional<String> name,
            Map<String, Object> additionalProperties) {
        this.apiKey = apiKey;
        this.authenticationPlan = authenticationPlan;
        this.name = name;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return This is not returned in the API.
     */
    @JsonProperty("apiKey")
    public String getApiKey() {
        return apiKey;
    }

    /**
     * @return This is the authentication plan. Currently supports OAuth2 RFC 6749. To use Bearer authentication, use apiKey
     */
    @JsonProperty("authenticationPlan")
    public Optional<OAuth2AuthenticationPlan> getAuthenticationPlan() {
        return authenticationPlan;
    }

    /**
     * @return This is the name of credential. This is just for your reference.
     */
    @JsonProperty("name")
    public Optional<String> getName() {
        return name;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CreateCustomLlmCredentialDto && equalTo((CreateCustomLlmCredentialDto) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(CreateCustomLlmCredentialDto other) {
        return apiKey.equals(other.apiKey)
                && authenticationPlan.equals(other.authenticationPlan)
                && name.equals(other.name);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.apiKey, this.authenticationPlan, this.name);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static ApiKeyStage builder() {
        return new Builder();
    }

    public interface ApiKeyStage {
        _FinalStage apiKey(@NotNull String apiKey);

        Builder from(CreateCustomLlmCredentialDto other);
    }

    public interface _FinalStage {
        CreateCustomLlmCredentialDto build();

        _FinalStage authenticationPlan(Optional<OAuth2AuthenticationPlan> authenticationPlan);

        _FinalStage authenticationPlan(OAuth2AuthenticationPlan authenticationPlan);

        _FinalStage name(Optional<String> name);

        _FinalStage name(String name);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements ApiKeyStage, _FinalStage {
        private String apiKey;

        private Optional<String> name = Optional.empty();

        private Optional<OAuth2AuthenticationPlan> authenticationPlan = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(CreateCustomLlmCredentialDto other) {
            apiKey(other.getApiKey());
            authenticationPlan(other.getAuthenticationPlan());
            name(other.getName());
            return this;
        }

        /**
         * <p>This is not returned in the API.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("apiKey")
        public _FinalStage apiKey(@NotNull String apiKey) {
            this.apiKey = Objects.requireNonNull(apiKey, "apiKey must not be null");
            return this;
        }

        /**
         * <p>This is the name of credential. This is just for your reference.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage name(String name) {
            this.name = Optional.ofNullable(name);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "name", nulls = Nulls.SKIP)
        public _FinalStage name(Optional<String> name) {
            this.name = name;
            return this;
        }

        /**
         * <p>This is the authentication plan. Currently supports OAuth2 RFC 6749. To use Bearer authentication, use apiKey</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage authenticationPlan(OAuth2AuthenticationPlan authenticationPlan) {
            this.authenticationPlan = Optional.ofNullable(authenticationPlan);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "authenticationPlan", nulls = Nulls.SKIP)
        public _FinalStage authenticationPlan(Optional<OAuth2AuthenticationPlan> authenticationPlan) {
            this.authenticationPlan = authenticationPlan;
            return this;
        }

        @java.lang.Override
        public CreateCustomLlmCredentialDto build() {
            return new CreateCustomLlmCredentialDto(apiKey, authenticationPlan, name, additionalProperties);
        }
    }
}
