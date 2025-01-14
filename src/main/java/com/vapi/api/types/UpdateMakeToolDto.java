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
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = UpdateMakeToolDto.Builder.class)
public final class UpdateMakeToolDto {
    private final Optional<Boolean> async;

    private final Optional<List<UpdateMakeToolDtoMessagesItem>> messages;

    private final Optional<OpenAiFunction> function;

    private final Optional<Server> server;

    private final Optional<MakeToolMetadata> metadata;

    private final Map<String, Object> additionalProperties;

    private UpdateMakeToolDto(
            Optional<Boolean> async,
            Optional<List<UpdateMakeToolDtoMessagesItem>> messages,
            Optional<OpenAiFunction> function,
            Optional<Server> server,
            Optional<MakeToolMetadata> metadata,
            Map<String, Object> additionalProperties) {
        this.async = async;
        this.messages = messages;
        this.function = function;
        this.server = server;
        this.metadata = metadata;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return This determines if the tool is async.
     * <p>If async, the assistant will move forward without waiting for your server to respond. This is useful if you just want to trigger something on your server.</p>
     * <p>If sync, the assistant will wait for your server to respond. This is useful if want assistant to respond with the result from your server.</p>
     * <p>Defaults to synchronous (<code>false</code>).</p>
     */
    @JsonProperty("async")
    public Optional<Boolean> getAsync() {
        return async;
    }

    /**
     * @return These are the messages that will be spoken to the user as the tool is running.
     * <p>For some tools, this is auto-filled based on special fields like <code>tool.destinations</code>. For others like the function tool, these can be custom configured.</p>
     */
    @JsonProperty("messages")
    public Optional<List<UpdateMakeToolDtoMessagesItem>> getMessages() {
        return messages;
    }

    /**
     * @return This is the function definition of the tool.
     * <p>For <code>endCall</code>, <code>transferCall</code>, and <code>dtmf</code> tools, this is auto-filled based on tool-specific fields like <code>tool.destinations</code>. But, even in those cases, you can provide a custom function definition for advanced use cases.</p>
     * <p>An example of an advanced use case is if you want to customize the message that's spoken for <code>endCall</code> tool. You can specify a function where it returns an argument &quot;reason&quot;. Then, in <code>messages</code> array, you can have many &quot;request-complete&quot; messages. One of these messages will be triggered if the <code>messages[].conditions</code> matches the &quot;reason&quot; argument.</p>
     */
    @JsonProperty("function")
    public Optional<OpenAiFunction> getFunction() {
        return function;
    }

    /**
     * @return This is the server that will be hit when this tool is requested by the model.
     * <p>All requests will be sent with the call object among other things. You can find more details in the Server URL documentation.</p>
     * <p>This overrides the serverUrl set on the org and the phoneNumber. Order of precedence: highest tool.server.url, then assistant.serverUrl, then phoneNumber.serverUrl, then org.serverUrl.</p>
     */
    @JsonProperty("server")
    public Optional<Server> getServer() {
        return server;
    }

    @JsonProperty("metadata")
    public Optional<MakeToolMetadata> getMetadata() {
        return metadata;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof UpdateMakeToolDto && equalTo((UpdateMakeToolDto) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(UpdateMakeToolDto other) {
        return async.equals(other.async)
                && messages.equals(other.messages)
                && function.equals(other.function)
                && server.equals(other.server)
                && metadata.equals(other.metadata);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.async, this.messages, this.function, this.server, this.metadata);
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
        private Optional<Boolean> async = Optional.empty();

        private Optional<List<UpdateMakeToolDtoMessagesItem>> messages = Optional.empty();

        private Optional<OpenAiFunction> function = Optional.empty();

        private Optional<Server> server = Optional.empty();

        private Optional<MakeToolMetadata> metadata = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(UpdateMakeToolDto other) {
            async(other.getAsync());
            messages(other.getMessages());
            function(other.getFunction());
            server(other.getServer());
            metadata(other.getMetadata());
            return this;
        }

        @JsonSetter(value = "async", nulls = Nulls.SKIP)
        public Builder async(Optional<Boolean> async) {
            this.async = async;
            return this;
        }

        public Builder async(Boolean async) {
            this.async = Optional.ofNullable(async);
            return this;
        }

        @JsonSetter(value = "messages", nulls = Nulls.SKIP)
        public Builder messages(Optional<List<UpdateMakeToolDtoMessagesItem>> messages) {
            this.messages = messages;
            return this;
        }

        public Builder messages(List<UpdateMakeToolDtoMessagesItem> messages) {
            this.messages = Optional.ofNullable(messages);
            return this;
        }

        @JsonSetter(value = "function", nulls = Nulls.SKIP)
        public Builder function(Optional<OpenAiFunction> function) {
            this.function = function;
            return this;
        }

        public Builder function(OpenAiFunction function) {
            this.function = Optional.ofNullable(function);
            return this;
        }

        @JsonSetter(value = "server", nulls = Nulls.SKIP)
        public Builder server(Optional<Server> server) {
            this.server = server;
            return this;
        }

        public Builder server(Server server) {
            this.server = Optional.ofNullable(server);
            return this;
        }

        @JsonSetter(value = "metadata", nulls = Nulls.SKIP)
        public Builder metadata(Optional<MakeToolMetadata> metadata) {
            this.metadata = metadata;
            return this;
        }

        public Builder metadata(MakeToolMetadata metadata) {
            this.metadata = Optional.ofNullable(metadata);
            return this;
        }

        public UpdateMakeToolDto build() {
            return new UpdateMakeToolDto(async, messages, function, server, metadata, additionalProperties);
        }
    }
}
