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
@JsonDeserialize(builder = CloudflareR2BucketPlan.Builder.class)
public final class CloudflareR2BucketPlan {
    private final Optional<String> accessKeyId;

    private final Optional<String> secretAccessKey;

    private final Optional<String> url;

    private final String name;

    private final Optional<String> path;

    private final Map<String, Object> additionalProperties;

    private CloudflareR2BucketPlan(
            Optional<String> accessKeyId,
            Optional<String> secretAccessKey,
            Optional<String> url,
            String name,
            Optional<String> path,
            Map<String, Object> additionalProperties) {
        this.accessKeyId = accessKeyId;
        this.secretAccessKey = secretAccessKey;
        this.url = url;
        this.name = name;
        this.path = path;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return Cloudflare R2 Access key ID.
     */
    @JsonProperty("accessKeyId")
    public Optional<String> getAccessKeyId() {
        return accessKeyId;
    }

    /**
     * @return Cloudflare R2 access key secret. This is not returned in the API.
     */
    @JsonProperty("secretAccessKey")
    public Optional<String> getSecretAccessKey() {
        return secretAccessKey;
    }

    /**
     * @return Cloudflare R2 base url.
     */
    @JsonProperty("url")
    public Optional<String> getUrl() {
        return url;
    }

    /**
     * @return This is the name of the bucket.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * @return This is the path where call artifacts will be stored.
     * <p>Usage:</p>
     * <ul>
     * <li>To store call artifacts in a specific folder, set this to the full path. Eg. &quot;/folder-name1/folder-name2&quot;.</li>
     * <li>To store call artifacts in the root of the bucket, leave this blank.</li>
     * </ul>
     * <p>@default &quot;/&quot;</p>
     */
    @JsonProperty("path")
    public Optional<String> getPath() {
        return path;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CloudflareR2BucketPlan && equalTo((CloudflareR2BucketPlan) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(CloudflareR2BucketPlan other) {
        return accessKeyId.equals(other.accessKeyId)
                && secretAccessKey.equals(other.secretAccessKey)
                && url.equals(other.url)
                && name.equals(other.name)
                && path.equals(other.path);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.accessKeyId, this.secretAccessKey, this.url, this.name, this.path);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static NameStage builder() {
        return new Builder();
    }

    public interface NameStage {
        _FinalStage name(@NotNull String name);

        Builder from(CloudflareR2BucketPlan other);
    }

    public interface _FinalStage {
        CloudflareR2BucketPlan build();

        _FinalStage accessKeyId(Optional<String> accessKeyId);

        _FinalStage accessKeyId(String accessKeyId);

        _FinalStage secretAccessKey(Optional<String> secretAccessKey);

        _FinalStage secretAccessKey(String secretAccessKey);

        _FinalStage url(Optional<String> url);

        _FinalStage url(String url);

        _FinalStage path(Optional<String> path);

        _FinalStage path(String path);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements NameStage, _FinalStage {
        private String name;

        private Optional<String> path = Optional.empty();

        private Optional<String> url = Optional.empty();

        private Optional<String> secretAccessKey = Optional.empty();

        private Optional<String> accessKeyId = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(CloudflareR2BucketPlan other) {
            accessKeyId(other.getAccessKeyId());
            secretAccessKey(other.getSecretAccessKey());
            url(other.getUrl());
            name(other.getName());
            path(other.getPath());
            return this;
        }

        /**
         * <p>This is the name of the bucket.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("name")
        public _FinalStage name(@NotNull String name) {
            this.name = Objects.requireNonNull(name, "name must not be null");
            return this;
        }

        /**
         * <p>This is the path where call artifacts will be stored.</p>
         * <p>Usage:</p>
         * <ul>
         * <li>To store call artifacts in a specific folder, set this to the full path. Eg. &quot;/folder-name1/folder-name2&quot;.</li>
         * <li>To store call artifacts in the root of the bucket, leave this blank.</li>
         * </ul>
         * <p>@default &quot;/&quot;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage path(String path) {
            this.path = Optional.ofNullable(path);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "path", nulls = Nulls.SKIP)
        public _FinalStage path(Optional<String> path) {
            this.path = path;
            return this;
        }

        /**
         * <p>Cloudflare R2 base url.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage url(String url) {
            this.url = Optional.ofNullable(url);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "url", nulls = Nulls.SKIP)
        public _FinalStage url(Optional<String> url) {
            this.url = url;
            return this;
        }

        /**
         * <p>Cloudflare R2 access key secret. This is not returned in the API.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage secretAccessKey(String secretAccessKey) {
            this.secretAccessKey = Optional.ofNullable(secretAccessKey);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "secretAccessKey", nulls = Nulls.SKIP)
        public _FinalStage secretAccessKey(Optional<String> secretAccessKey) {
            this.secretAccessKey = secretAccessKey;
            return this;
        }

        /**
         * <p>Cloudflare R2 Access key ID.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage accessKeyId(String accessKeyId) {
            this.accessKeyId = Optional.ofNullable(accessKeyId);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "accessKeyId", nulls = Nulls.SKIP)
        public _FinalStage accessKeyId(Optional<String> accessKeyId) {
            this.accessKeyId = accessKeyId;
            return this;
        }

        @java.lang.Override
        public CloudflareR2BucketPlan build() {
            return new CloudflareR2BucketPlan(accessKeyId, secretAccessKey, url, name, path, additionalProperties);
        }
    }
}
