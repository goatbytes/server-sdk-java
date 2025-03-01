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
@JsonDeserialize(builder = UserMessage.Builder.class)
public final class UserMessage {
    private final String role;

    private final String message;

    private final double time;

    private final double endTime;

    private final double secondsFromStart;

    private final Optional<Double> duration;

    private final Map<String, Object> additionalProperties;

    private UserMessage(
            String role,
            String message,
            double time,
            double endTime,
            double secondsFromStart,
            Optional<Double> duration,
            Map<String, Object> additionalProperties) {
        this.role = role;
        this.message = message;
        this.time = time;
        this.endTime = endTime;
        this.secondsFromStart = secondsFromStart;
        this.duration = duration;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The role of the user in the conversation.
     */
    @JsonProperty("role")
    public String getRole() {
        return role;
    }

    /**
     * @return The message content from the user.
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     * @return The timestamp when the message was sent.
     */
    @JsonProperty("time")
    public double getTime() {
        return time;
    }

    /**
     * @return The timestamp when the message ended.
     */
    @JsonProperty("endTime")
    public double getEndTime() {
        return endTime;
    }

    /**
     * @return The number of seconds from the start of the conversation.
     */
    @JsonProperty("secondsFromStart")
    public double getSecondsFromStart() {
        return secondsFromStart;
    }

    /**
     * @return The duration of the message in seconds.
     */
    @JsonProperty("duration")
    public Optional<Double> getDuration() {
        return duration;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof UserMessage && equalTo((UserMessage) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(UserMessage other) {
        return role.equals(other.role)
                && message.equals(other.message)
                && time == other.time
                && endTime == other.endTime
                && secondsFromStart == other.secondsFromStart
                && duration.equals(other.duration);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.role, this.message, this.time, this.endTime, this.secondsFromStart, this.duration);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static RoleStage builder() {
        return new Builder();
    }

    public interface RoleStage {
        MessageStage role(@NotNull String role);

        Builder from(UserMessage other);
    }

    public interface MessageStage {
        TimeStage message(@NotNull String message);
    }

    public interface TimeStage {
        EndTimeStage time(double time);
    }

    public interface EndTimeStage {
        SecondsFromStartStage endTime(double endTime);
    }

    public interface SecondsFromStartStage {
        _FinalStage secondsFromStart(double secondsFromStart);
    }

    public interface _FinalStage {
        UserMessage build();

        _FinalStage duration(Optional<Double> duration);

        _FinalStage duration(Double duration);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder
            implements RoleStage, MessageStage, TimeStage, EndTimeStage, SecondsFromStartStage, _FinalStage {
        private String role;

        private String message;

        private double time;

        private double endTime;

        private double secondsFromStart;

        private Optional<Double> duration = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(UserMessage other) {
            role(other.getRole());
            message(other.getMessage());
            time(other.getTime());
            endTime(other.getEndTime());
            secondsFromStart(other.getSecondsFromStart());
            duration(other.getDuration());
            return this;
        }

        /**
         * <p>The role of the user in the conversation.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("role")
        public MessageStage role(@NotNull String role) {
            this.role = Objects.requireNonNull(role, "role must not be null");
            return this;
        }

        /**
         * <p>The message content from the user.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("message")
        public TimeStage message(@NotNull String message) {
            this.message = Objects.requireNonNull(message, "message must not be null");
            return this;
        }

        /**
         * <p>The timestamp when the message was sent.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("time")
        public EndTimeStage time(double time) {
            this.time = time;
            return this;
        }

        /**
         * <p>The timestamp when the message ended.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("endTime")
        public SecondsFromStartStage endTime(double endTime) {
            this.endTime = endTime;
            return this;
        }

        /**
         * <p>The number of seconds from the start of the conversation.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("secondsFromStart")
        public _FinalStage secondsFromStart(double secondsFromStart) {
            this.secondsFromStart = secondsFromStart;
            return this;
        }

        /**
         * <p>The duration of the message in seconds.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage duration(Double duration) {
            this.duration = Optional.ofNullable(duration);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "duration", nulls = Nulls.SKIP)
        public _FinalStage duration(Optional<Double> duration) {
            this.duration = duration;
            return this;
        }

        @java.lang.Override
        public UserMessage build() {
            return new UserMessage(role, message, time, endTime, secondsFromStart, duration, additionalProperties);
        }
    }
}
