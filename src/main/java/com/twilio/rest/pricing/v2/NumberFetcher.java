/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.pricing.v2;

import com.twilio.base.Fetcher;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class NumberFetcher extends Fetcher<Number> {
    private final com.twilio.type.PhoneNumber pathDestinationNumber;
    private com.twilio.type.PhoneNumber originationNumber;

    /**
     * Construct a new NumberFetcher.
     *
     * @param pathDestinationNumber The destination number for which to fetch
     *                              pricing information
     */
    public NumberFetcher(final com.twilio.type.PhoneNumber pathDestinationNumber) {
        this.pathDestinationNumber = pathDestinationNumber;
    }

    /**
     * The origination phone number, in <a
     * href="https://www.twilio.com/docs/glossary/what-e164">E.164</a> format, for
     * which to fetch the origin-based voice pricing information. E.164 format
     * consists of a + followed by the country code and subscriber number..
     *
     * @param originationNumber The origination number for which to fetch pricing
     *                          information
     * @return this
     */
    public NumberFetcher setOriginationNumber(final com.twilio.type.PhoneNumber originationNumber) {
        this.originationNumber = originationNumber;
        return this;
    }

    /**
     * The origination phone number, in <a
     * href="https://www.twilio.com/docs/glossary/what-e164">E.164</a> format, for
     * which to fetch the origin-based voice pricing information. E.164 format
     * consists of a + followed by the country code and subscriber number..
     *
     * @param originationNumber The origination number for which to fetch pricing
     *                          information
     * @return this
     */
    public NumberFetcher setOriginationNumber(final String originationNumber) {
        return setOriginationNumber(Promoter.phoneNumberFromString(originationNumber));
    }

    /**
     * Make the request to the Twilio API to perform the fetch.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Fetched Number
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Number fetch(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            Domains.PRICING.toString(),
            "/v2/Trunking/Numbers/" + this.pathDestinationNumber.encode("utf-8") + ""
        );

        addQueryParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Number fetch failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Number.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested query string arguments to the Request.
     *
     * @param request Request to add query string arguments to
     */
    private void addQueryParams(final Request request) {
        if (originationNumber != null) {
            request.addQueryParam("OriginationNumber", originationNumber.toString());
        }
    }
}