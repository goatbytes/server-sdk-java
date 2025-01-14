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
@JsonDeserialize(builder = UpdateGcpCredentialDto.Builder.class)
public final class UpdateGcpCredentialDto {
    private final Optional<String> name;

    private final Optional<GcpKey> gcpKey;

    private final Optional<BucketPlan> bucketPlan;

    private final Map<String, Object> additionalProperties;

    private UpdateGcpCredentialDto(
            Optional<String> name,
            Optional<GcpKey> gcpKey,
            Optional<BucketPlan> bucketPlan,
            Map<String, Object> additionalProperties) {
        this.name = name;
        this.gcpKey = gcpKey;
        this.bucketPlan = bucketPlan;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return This is the name of credential. This is just for your reference.
     */
    @JsonProperty("name")
    public Optional<String> getName() {
        return name;
    }

    /**
     * @return This is the GCP key. This is the JSON that can be generated in the Google Cloud Console at https://console.cloud.google.com/iam-admin/serviceaccounts/details/&lt;service-account-id&gt;/keys.
     * <p>The schema is identical to the JSON that GCP outputs.</p>
     */
    @JsonProperty("gcpKey")
    public Optional<GcpKey> getGcpKey() {
        return gcpKey;
    }

    /**
     * @return This is the bucket plan that can be provided to store call artifacts in GCP.
     */
    @JsonProperty("bucketPlan")
    public Optional<BucketPlan> getBucketPlan() {
        return bucketPlan;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof UpdateGcpCredentialDto && equalTo((UpdateGcpCredentialDto) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(UpdateGcpCredentialDto other) {
        return name.equals(other.name) && gcpKey.equals(other.gcpKey) && bucketPlan.equals(other.bucketPlan);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.name, this.gcpKey, this.bucketPlan);
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
        private Optional<String> name = Optional.empty();

        private Optional<GcpKey> gcpKey = Optional.empty();

        private Optional<BucketPlan> bucketPlan = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(UpdateGcpCredentialDto other) {
            name(other.getName());
            gcpKey(other.getGcpKey());
            bucketPlan(other.getBucketPlan());
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

        @JsonSetter(value = "gcpKey", nulls = Nulls.SKIP)
        public Builder gcpKey(Optional<GcpKey> gcpKey) {
            this.gcpKey = gcpKey;
            return this;
        }

        public Builder gcpKey(GcpKey gcpKey) {
            this.gcpKey = Optional.ofNullable(gcpKey);
            return this;
        }

        @JsonSetter(value = "bucketPlan", nulls = Nulls.SKIP)
        public Builder bucketPlan(Optional<BucketPlan> bucketPlan) {
            this.bucketPlan = bucketPlan;
            return this;
        }

        public Builder bucketPlan(BucketPlan bucketPlan) {
            this.bucketPlan = Optional.ofNullable(bucketPlan);
            return this;
        }

        public UpdateGcpCredentialDto build() {
            return new UpdateGcpCredentialDto(name, gcpKey, bucketPlan, additionalProperties);
        }
    }
}
