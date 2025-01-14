/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.vapi.api.resources.phonenumbers.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.annotation.JsonValue;
import com.vapi.api.types.UpdateByoPhoneNumberDto;
import com.vapi.api.types.UpdateTwilioPhoneNumberDto;
import com.vapi.api.types.UpdateVapiPhoneNumberDto;
import com.vapi.api.types.UpdateVonagePhoneNumberDto;
import java.util.Objects;
import java.util.Optional;

public final class PhoneNumbersUpdateRequest {
    private final Value value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    private PhoneNumbersUpdateRequest(Value value) {
        this.value = value;
    }

    public <T> T visit(Visitor<T> visitor) {
        return value.visit(visitor);
    }

    public static PhoneNumbersUpdateRequest byoPhoneNumber(UpdateByoPhoneNumberDto value) {
        return new PhoneNumbersUpdateRequest(new ByoPhoneNumberValue(value));
    }

    public static PhoneNumbersUpdateRequest twilio(UpdateTwilioPhoneNumberDto value) {
        return new PhoneNumbersUpdateRequest(new TwilioValue(value));
    }

    public static PhoneNumbersUpdateRequest vonage(UpdateVonagePhoneNumberDto value) {
        return new PhoneNumbersUpdateRequest(new VonageValue(value));
    }

    public static PhoneNumbersUpdateRequest vapi(UpdateVapiPhoneNumberDto value) {
        return new PhoneNumbersUpdateRequest(new VapiValue(value));
    }

    public boolean isByoPhoneNumber() {
        return value instanceof ByoPhoneNumberValue;
    }

    public boolean isTwilio() {
        return value instanceof TwilioValue;
    }

    public boolean isVonage() {
        return value instanceof VonageValue;
    }

    public boolean isVapi() {
        return value instanceof VapiValue;
    }

    public boolean _isUnknown() {
        return value instanceof _UnknownValue;
    }

    public Optional<UpdateByoPhoneNumberDto> getByoPhoneNumber() {
        if (isByoPhoneNumber()) {
            return Optional.of(((ByoPhoneNumberValue) value).value);
        }
        return Optional.empty();
    }

    public Optional<UpdateTwilioPhoneNumberDto> getTwilio() {
        if (isTwilio()) {
            return Optional.of(((TwilioValue) value).value);
        }
        return Optional.empty();
    }

    public Optional<UpdateVonagePhoneNumberDto> getVonage() {
        if (isVonage()) {
            return Optional.of(((VonageValue) value).value);
        }
        return Optional.empty();
    }

    public Optional<UpdateVapiPhoneNumberDto> getVapi() {
        if (isVapi()) {
            return Optional.of(((VapiValue) value).value);
        }
        return Optional.empty();
    }

    public Optional<Object> _getUnknown() {
        if (_isUnknown()) {
            return Optional.of(((_UnknownValue) value).value);
        }
        return Optional.empty();
    }

    @JsonValue
    private Value getValue() {
        return this.value;
    }

    public interface Visitor<T> {
        T visitByoPhoneNumber(UpdateByoPhoneNumberDto byoPhoneNumber);

        T visitTwilio(UpdateTwilioPhoneNumberDto twilio);

        T visitVonage(UpdateVonagePhoneNumberDto vonage);

        T visitVapi(UpdateVapiPhoneNumberDto vapi);

        T _visitUnknown(Object unknownType);
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "provider", visible = true, defaultImpl = _UnknownValue.class)
    @JsonSubTypes({
        @JsonSubTypes.Type(ByoPhoneNumberValue.class),
        @JsonSubTypes.Type(TwilioValue.class),
        @JsonSubTypes.Type(VonageValue.class),
        @JsonSubTypes.Type(VapiValue.class)
    })
    @JsonIgnoreProperties(ignoreUnknown = true)
    private interface Value {
        <T> T visit(Visitor<T> visitor);
    }

    @JsonTypeName("byo-phone-number")
    private static final class ByoPhoneNumberValue implements Value {
        @JsonUnwrapped
        private UpdateByoPhoneNumberDto value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private ByoPhoneNumberValue() {}

        private ByoPhoneNumberValue(UpdateByoPhoneNumberDto value) {
            this.value = value;
        }

        @java.lang.Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor.visitByoPhoneNumber(value);
        }

        @java.lang.Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof ByoPhoneNumberValue && equalTo((ByoPhoneNumberValue) other);
        }

        private boolean equalTo(ByoPhoneNumberValue other) {
            return value.equals(other.value);
        }

        @java.lang.Override
        public int hashCode() {
            return Objects.hash(this.value);
        }

        @java.lang.Override
        public String toString() {
            return "PhoneNumbersUpdateRequest{" + "value: " + value + "}";
        }
    }

    @JsonTypeName("twilio")
    private static final class TwilioValue implements Value {
        @JsonUnwrapped
        private UpdateTwilioPhoneNumberDto value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private TwilioValue() {}

        private TwilioValue(UpdateTwilioPhoneNumberDto value) {
            this.value = value;
        }

        @java.lang.Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor.visitTwilio(value);
        }

        @java.lang.Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof TwilioValue && equalTo((TwilioValue) other);
        }

        private boolean equalTo(TwilioValue other) {
            return value.equals(other.value);
        }

        @java.lang.Override
        public int hashCode() {
            return Objects.hash(this.value);
        }

        @java.lang.Override
        public String toString() {
            return "PhoneNumbersUpdateRequest{" + "value: " + value + "}";
        }
    }

    @JsonTypeName("vonage")
    private static final class VonageValue implements Value {
        @JsonUnwrapped
        private UpdateVonagePhoneNumberDto value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private VonageValue() {}

        private VonageValue(UpdateVonagePhoneNumberDto value) {
            this.value = value;
        }

        @java.lang.Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor.visitVonage(value);
        }

        @java.lang.Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof VonageValue && equalTo((VonageValue) other);
        }

        private boolean equalTo(VonageValue other) {
            return value.equals(other.value);
        }

        @java.lang.Override
        public int hashCode() {
            return Objects.hash(this.value);
        }

        @java.lang.Override
        public String toString() {
            return "PhoneNumbersUpdateRequest{" + "value: " + value + "}";
        }
    }

    @JsonTypeName("vapi")
    private static final class VapiValue implements Value {
        @JsonUnwrapped
        private UpdateVapiPhoneNumberDto value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private VapiValue() {}

        private VapiValue(UpdateVapiPhoneNumberDto value) {
            this.value = value;
        }

        @java.lang.Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor.visitVapi(value);
        }

        @java.lang.Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof VapiValue && equalTo((VapiValue) other);
        }

        private boolean equalTo(VapiValue other) {
            return value.equals(other.value);
        }

        @java.lang.Override
        public int hashCode() {
            return Objects.hash(this.value);
        }

        @java.lang.Override
        public String toString() {
            return "PhoneNumbersUpdateRequest{" + "value: " + value + "}";
        }
    }

    private static final class _UnknownValue implements Value {
        private String type;

        @JsonValue
        private Object value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private _UnknownValue(@JsonProperty("value") Object value) {}

        @java.lang.Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor._visitUnknown(value);
        }

        @java.lang.Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof _UnknownValue && equalTo((_UnknownValue) other);
        }

        private boolean equalTo(_UnknownValue other) {
            return type.equals(other.type) && value.equals(other.value);
        }

        @java.lang.Override
        public int hashCode() {
            return Objects.hash(this.type, this.value);
        }

        @java.lang.Override
        public String toString() {
            return "PhoneNumbersUpdateRequest{" + "type: " + type + ", value: " + value + "}";
        }
    }
}
