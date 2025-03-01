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
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.vapi.api.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = PaginationMeta.Builder.class)
public final class PaginationMeta {
    private final double itemsPerPage;

    private final double totalItems;

    private final double currentPage;

    private final Map<String, Object> additionalProperties;

    private PaginationMeta(
            double itemsPerPage, double totalItems, double currentPage, Map<String, Object> additionalProperties) {
        this.itemsPerPage = itemsPerPage;
        this.totalItems = totalItems;
        this.currentPage = currentPage;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("itemsPerPage")
    public double getItemsPerPage() {
        return itemsPerPage;
    }

    @JsonProperty("totalItems")
    public double getTotalItems() {
        return totalItems;
    }

    @JsonProperty("currentPage")
    public double getCurrentPage() {
        return currentPage;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof PaginationMeta && equalTo((PaginationMeta) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(PaginationMeta other) {
        return itemsPerPage == other.itemsPerPage && totalItems == other.totalItems && currentPage == other.currentPage;
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.itemsPerPage, this.totalItems, this.currentPage);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static ItemsPerPageStage builder() {
        return new Builder();
    }

    public interface ItemsPerPageStage {
        TotalItemsStage itemsPerPage(double itemsPerPage);

        Builder from(PaginationMeta other);
    }

    public interface TotalItemsStage {
        CurrentPageStage totalItems(double totalItems);
    }

    public interface CurrentPageStage {
        _FinalStage currentPage(double currentPage);
    }

    public interface _FinalStage {
        PaginationMeta build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements ItemsPerPageStage, TotalItemsStage, CurrentPageStage, _FinalStage {
        private double itemsPerPage;

        private double totalItems;

        private double currentPage;

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(PaginationMeta other) {
            itemsPerPage(other.getItemsPerPage());
            totalItems(other.getTotalItems());
            currentPage(other.getCurrentPage());
            return this;
        }

        @java.lang.Override
        @JsonSetter("itemsPerPage")
        public TotalItemsStage itemsPerPage(double itemsPerPage) {
            this.itemsPerPage = itemsPerPage;
            return this;
        }

        @java.lang.Override
        @JsonSetter("totalItems")
        public CurrentPageStage totalItems(double totalItems) {
            this.totalItems = totalItems;
            return this;
        }

        @java.lang.Override
        @JsonSetter("currentPage")
        public _FinalStage currentPage(double currentPage) {
            this.currentPage = currentPage;
            return this;
        }

        @java.lang.Override
        public PaginationMeta build() {
            return new PaginationMeta(itemsPerPage, totalItems, currentPage, additionalProperties);
        }
    }
}
