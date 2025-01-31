/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.pricing.v2;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.twilio.base.Resource;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import com.twilio.type.InboundCallPrice;
import com.twilio.type.OutboundPrefixPriceWithOrigin;
import lombok.ToString;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Currency;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class Country extends Resource {
    private static final long serialVersionUID = 198700750002345L;

    /**
     * Create a CountryReader to execute read.
     *
     * @return CountryReader capable of executing the read
     */
    public static CountryReader reader() {
        return new CountryReader();
    }

    /**
     * Create a CountryFetcher to execute fetch.
     *
     * @param pathIsoCountry The ISO country code of the pricing information to
     *                       fetch
     * @return CountryFetcher capable of executing the fetch
     */
    public static CountryFetcher fetcher(final String pathIsoCountry) {
        return new CountryFetcher(pathIsoCountry);
    }

    /**
     * Converts a JSON String into a Country object using the provided ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Country object represented by the provided JSON
     */
    public static Country fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Country.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Country object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Country object represented by the provided JSON
     */
    public static Country fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Country.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String country;
    private final String isoCountry;
    private final List<OutboundPrefixPriceWithOrigin> terminatingPrefixPrices;
    private final List<InboundCallPrice> originatingCallPrices;
    private final Currency priceUnit;
    private final URI url;

    @JsonCreator
    private Country(@JsonProperty("country")
                    final String country,
                    @JsonProperty("iso_country")
                    final String isoCountry,
                    @JsonProperty("terminating_prefix_prices")
                    final List<OutboundPrefixPriceWithOrigin> terminatingPrefixPrices,
                    @JsonProperty("originating_call_prices")
                    final List<InboundCallPrice> originatingCallPrices,
                    @JsonProperty("price_unit")
                    @JsonDeserialize(using = com.twilio.converter.CurrencyDeserializer.class)
                    final Currency priceUnit,
                    @JsonProperty("url")
                    final URI url) {
        this.country = country;
        this.isoCountry = isoCountry;
        this.terminatingPrefixPrices = terminatingPrefixPrices;
        this.originatingCallPrices = originatingCallPrices;
        this.priceUnit = priceUnit;
        this.url = url;
    }

    /**
     * Returns The name of the country.
     *
     * @return The name of the country
     */
    public final String getCountry() {
        return this.country;
    }

    /**
     * Returns The ISO country code.
     *
     * @return The ISO country code
     */
    public final String getIsoCountry() {
        return this.isoCountry;
    }

    /**
     * Returns The list of TerminatingPrefixPrice records.
     *
     * @return The list of TerminatingPrefixPrice records
     */
    public final List<OutboundPrefixPriceWithOrigin> getTerminatingPrefixPrices() {
        return this.terminatingPrefixPrices;
    }

    /**
     * Returns The list of OriginatingCallPrice records.
     *
     * @return The list of OriginatingCallPrice records
     */
    public final List<InboundCallPrice> getOriginatingCallPrices() {
        return this.originatingCallPrices;
    }

    /**
     * Returns The currency in which prices are measured, in ISO 4127 format (e.g.
     * usd, eur, jpy).
     *
     * @return The currency in which prices are measured, in ISO 4127 format (e.g.
     *         usd, eur, jpy)
     */
    public final Currency getPriceUnit() {
        return this.priceUnit;
    }

    /**
     * Returns The absolute URL of the resource.
     *
     * @return The absolute URL of the resource
     */
    public final URI getUrl() {
        return this.url;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Country other = (Country) o;

        return Objects.equals(country, other.country) &&
               Objects.equals(isoCountry, other.isoCountry) &&
               Objects.equals(terminatingPrefixPrices, other.terminatingPrefixPrices) &&
               Objects.equals(originatingCallPrices, other.originatingCallPrices) &&
               Objects.equals(priceUnit, other.priceUnit) &&
               Objects.equals(url, other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country,
                            isoCountry,
                            terminatingPrefixPrices,
                            originatingCallPrices,
                            priceUnit,
                            url);
    }
}