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
@JsonDeserialize(builder = UpdateCloudflareCredentialDto.Builder.class)
public final class UpdateCloudflareCredentialDto {
    private final Optional<String> accountId;

    private final Optional<String> apiKey;

    private final Optional<String> accountEmail;

    private final Optional<String> name;

    private final Optional<CloudflareR2BucketPlan> bucketPlan;

    private final Map<String, Object> additionalProperties;

    private UpdateCloudflareCredentialDto(
            Optional<String> accountId,
            Optional<String> apiKey,
            Optional<String> accountEmail,
            Optional<String> name,
            Optional<CloudflareR2BucketPlan> bucketPlan,
            Map<String, Object> additionalProperties) {
        this.accountId = accountId;
        this.apiKey = apiKey;
        this.accountEmail = accountEmail;
        this.name = name;
        this.bucketPlan = bucketPlan;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return Cloudflare Account Id.
     */
    @JsonProperty("accountId")
    public Optional<String> getAccountId() {
        return accountId;
    }

    /**
     * @return Cloudflare API Key / Token.
     */
    @JsonProperty("apiKey")
    public Optional<String> getApiKey() {
        return apiKey;
    }

    /**
     * @return Cloudflare Account Email.
     */
    @JsonProperty("accountEmail")
    public Optional<String> getAccountEmail() {
        return accountEmail;
    }

    /**
     * @return This is the name of credential. This is just for your reference.
     */
    @JsonProperty("name")
    public Optional<String> getName() {
        return name;
    }

    /**
     * @return This is the bucket plan that can be provided to store call artifacts in R2
     */
    @JsonProperty("bucketPlan")
    public Optional<CloudflareR2BucketPlan> getBucketPlan() {
        return bucketPlan;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof UpdateCloudflareCredentialDto && equalTo((UpdateCloudflareCredentialDto) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(UpdateCloudflareCredentialDto other) {
        return accountId.equals(other.accountId)
                && apiKey.equals(other.apiKey)
                && accountEmail.equals(other.accountEmail)
                && name.equals(other.name)
                && bucketPlan.equals(other.bucketPlan);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.accountId, this.apiKey, this.accountEmail, this.name, this.bucketPlan);
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
        private Optional<String> accountId = Optional.empty();

        private Optional<String> apiKey = Optional.empty();

        private Optional<String> accountEmail = Optional.empty();

        private Optional<String> name = Optional.empty();

        private Optional<CloudflareR2BucketPlan> bucketPlan = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(UpdateCloudflareCredentialDto other) {
            accountId(other.getAccountId());
            apiKey(other.getApiKey());
            accountEmail(other.getAccountEmail());
            name(other.getName());
            bucketPlan(other.getBucketPlan());
            return this;
        }

        @JsonSetter(value = "accountId", nulls = Nulls.SKIP)
        public Builder accountId(Optional<String> accountId) {
            this.accountId = accountId;
            return this;
        }

        public Builder accountId(String accountId) {
            this.accountId = Optional.ofNullable(accountId);
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

        @JsonSetter(value = "accountEmail", nulls = Nulls.SKIP)
        public Builder accountEmail(Optional<String> accountEmail) {
            this.accountEmail = accountEmail;
            return this;
        }

        public Builder accountEmail(String accountEmail) {
            this.accountEmail = Optional.ofNullable(accountEmail);
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

        @JsonSetter(value = "bucketPlan", nulls = Nulls.SKIP)
        public Builder bucketPlan(Optional<CloudflareR2BucketPlan> bucketPlan) {
            this.bucketPlan = bucketPlan;
            return this;
        }

        public Builder bucketPlan(CloudflareR2BucketPlan bucketPlan) {
            this.bucketPlan = Optional.ofNullable(bucketPlan);
            return this;
        }

        public UpdateCloudflareCredentialDto build() {
            return new UpdateCloudflareCredentialDto(
                    accountId, apiKey, accountEmail, name, bucketPlan, additionalProperties);
        }
    }
}
