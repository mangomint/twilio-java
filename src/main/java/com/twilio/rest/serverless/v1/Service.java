/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.serverless.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.base.Resource;
import com.twilio.converter.DateConverter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import lombok.ToString;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Objects;

/**
 * PLEASE NOTE that this class contains beta products that are subject to
 * change. Use them with caution.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class Service extends Resource {
    private static final long serialVersionUID = 248050836199187L;

    /**
     * Create a ServiceReader to execute read.
     *
     * @return ServiceReader capable of executing the read
     */
    public static ServiceReader reader() {
        return new ServiceReader();
    }

    /**
     * Create a ServiceFetcher to execute fetch.
     *
     * @param pathSid The SID of the Service resource to fetch
     * @return ServiceFetcher capable of executing the fetch
     */
    public static ServiceFetcher fetcher(final String pathSid) {
        return new ServiceFetcher(pathSid);
    }

    /**
     * Create a ServiceDeleter to execute delete.
     *
     * @param pathSid The SID of the Service resource to delete
     * @return ServiceDeleter capable of executing the delete
     */
    public static ServiceDeleter deleter(final String pathSid) {
        return new ServiceDeleter(pathSid);
    }

    /**
     * Create a ServiceCreator to execute create.
     *
     * @param uniqueName A user-defined string that uniquely identifies the Service
     *                   resource
     * @param friendlyName A string to describe the Service resource
     * @return ServiceCreator capable of executing the create
     */
    public static ServiceCreator creator(final String uniqueName,
                                         final String friendlyName) {
        return new ServiceCreator(uniqueName, friendlyName);
    }

    /**
     * Create a ServiceUpdater to execute update.
     *
     * @param pathSid The SID of the Service resource to update
     * @return ServiceUpdater capable of executing the update
     */
    public static ServiceUpdater updater(final String pathSid) {
        return new ServiceUpdater(pathSid);
    }

    /**
     * Converts a JSON String into a Service object using the provided ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Service object represented by the provided JSON
     */
    public static Service fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Service.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Service object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Service object represented by the provided JSON
     */
    public static Service fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Service.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String sid;
    private final String accountSid;
    private final String friendlyName;
    private final String uniqueName;
    private final Boolean includeCredentials;
    private final Boolean uiEditable;
    private final String domainBase;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;
    private final URI url;
    private final Map<String, String> links;

    @JsonCreator
    private Service(@JsonProperty("sid")
                    final String sid,
                    @JsonProperty("account_sid")
                    final String accountSid,
                    @JsonProperty("friendly_name")
                    final String friendlyName,
                    @JsonProperty("unique_name")
                    final String uniqueName,
                    @JsonProperty("include_credentials")
                    final Boolean includeCredentials,
                    @JsonProperty("ui_editable")
                    final Boolean uiEditable,
                    @JsonProperty("domain_base")
                    final String domainBase,
                    @JsonProperty("date_created")
                    final String dateCreated,
                    @JsonProperty("date_updated")
                    final String dateUpdated,
                    @JsonProperty("url")
                    final URI url,
                    @JsonProperty("links")
                    final Map<String, String> links) {
        this.sid = sid;
        this.accountSid = accountSid;
        this.friendlyName = friendlyName;
        this.uniqueName = uniqueName;
        this.includeCredentials = includeCredentials;
        this.uiEditable = uiEditable;
        this.domainBase = domainBase;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.url = url;
        this.links = links;
    }

    /**
     * Returns The unique string that identifies the Service resource.
     *
     * @return The unique string that identifies the Service resource
     */
    public final String getSid() {
        return this.sid;
    }

    /**
     * Returns The SID of the Account that created the Service resource.
     *
     * @return The SID of the Account that created the Service resource
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The string that you assigned to describe the Service resource.
     *
     * @return The string that you assigned to describe the Service resource
     */
    public final String getFriendlyName() {
        return this.friendlyName;
    }

    /**
     * Returns A user-defined string that uniquely identifies the Service resource.
     *
     * @return A user-defined string that uniquely identifies the Service resource
     */
    public final String getUniqueName() {
        return this.uniqueName;
    }

    /**
     * Returns Whether to inject Account credentials into a function invocation
     * context.
     *
     * @return Whether to inject Account credentials into a function invocation
     *         context
     */
    public final Boolean getIncludeCredentials() {
        return this.includeCredentials;
    }

    /**
     * Returns Whether the Service resource's properties and subresources can be
     * edited via the UI.
     *
     * @return Whether the Service resource's properties and subresources can be
     *         edited via the UI
     */
    public final Boolean getUiEditable() {
        return this.uiEditable;
    }

    /**
     * Returns The base domain name for this Service, which is a combination of the
     * unique name and a randomly generated string.
     *
     * @return The base domain name for this Service, which is a combination of the
     *         unique name and a randomly generated string
     */
    public final String getDomainBase() {
        return this.domainBase;
    }

    /**
     * Returns The ISO 8601 date and time in GMT when the Service resource was
     * created.
     *
     * @return The ISO 8601 date and time in GMT when the Service resource was
     *         created
     */
    public final ZonedDateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns The ISO 8601 date and time in GMT when the Service resource was last
     * updated.
     *
     * @return The ISO 8601 date and time in GMT when the Service resource was last
     *         updated
     */
    public final ZonedDateTime getDateUpdated() {
        return this.dateUpdated;
    }

    /**
     * Returns The absolute URL of the Service resource.
     *
     * @return The absolute URL of the Service resource
     */
    public final URI getUrl() {
        return this.url;
    }

    /**
     * Returns The URLs of the Service's nested resources.
     *
     * @return The URLs of the Service's nested resources
     */
    public final Map<String, String> getLinks() {
        return this.links;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Service other = (Service) o;

        return Objects.equals(sid, other.sid) &&
               Objects.equals(accountSid, other.accountSid) &&
               Objects.equals(friendlyName, other.friendlyName) &&
               Objects.equals(uniqueName, other.uniqueName) &&
               Objects.equals(includeCredentials, other.includeCredentials) &&
               Objects.equals(uiEditable, other.uiEditable) &&
               Objects.equals(domainBase, other.domainBase) &&
               Objects.equals(dateCreated, other.dateCreated) &&
               Objects.equals(dateUpdated, other.dateUpdated) &&
               Objects.equals(url, other.url) &&
               Objects.equals(links, other.links);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid,
                            accountSid,
                            friendlyName,
                            uniqueName,
                            includeCredentials,
                            uiEditable,
                            domainBase,
                            dateCreated,
                            dateUpdated,
                            url,
                            links);
    }
}