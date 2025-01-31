/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.api.v2010.account;

import com.twilio.base.Updater;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import com.twilio.type.Twiml;

import java.net.URI;

public class CallUpdater extends Updater<Call> {
    private String pathAccountSid;
    private final String pathSid;
    private URI url;
    private HttpMethod method;
    private Call.UpdateStatus status;
    private URI fallbackUrl;
    private HttpMethod fallbackMethod;
    private URI statusCallback;
    private HttpMethod statusCallbackMethod;
    private com.twilio.type.Twiml twiml;
    private Integer timeLimit;

    /**
     * Construct a new CallUpdater.
     *
     * @param pathSid The unique string that identifies this resource
     */
    public CallUpdater(final String pathSid) {
        this.pathSid = pathSid;
    }

    /**
     * Construct a new CallUpdater.
     *
     * @param pathAccountSid The SID of the Account that created the resource(s) to
     *                       update
     * @param pathSid The unique string that identifies this resource
     */
    public CallUpdater(final String pathAccountSid,
                       final String pathSid) {
        this.pathAccountSid = pathAccountSid;
        this.pathSid = pathSid;
    }

    /**
     * The absolute URL that returns the TwiML instructions for the call. We will
     * call this URL using the `method` when the call connects. For more
     * information, see the <a
     * href="https://www.twilio.com/docs/voice/make-calls#specify-a-url-parameter">Url
     * Parameter</a> section in <a
     * href="https://www.twilio.com/docs/voice/make-calls">Making Calls</a>..
     *
     * @param url The absolute URL that returns TwiML for this call
     * @return this
     */
    public CallUpdater setUrl(final URI url) {
        this.url = url;
        return this;
    }

    /**
     * The absolute URL that returns the TwiML instructions for the call. We will
     * call this URL using the `method` when the call connects. For more
     * information, see the <a
     * href="https://www.twilio.com/docs/voice/make-calls#specify-a-url-parameter">Url
     * Parameter</a> section in <a
     * href="https://www.twilio.com/docs/voice/make-calls">Making Calls</a>..
     *
     * @param url The absolute URL that returns TwiML for this call
     * @return this
     */
    public CallUpdater setUrl(final String url) {
        return setUrl(Promoter.uriFromString(url));
    }

    /**
     * The HTTP method we should use when calling the `url`. Can be: `GET` or `POST`
     * and the default is `POST`. If an `application_sid` parameter is present, this
     * parameter is ignored..
     *
     * @param method HTTP method to use to fetch TwiML
     * @return this
     */
    public CallUpdater setMethod(final HttpMethod method) {
        this.method = method;
        return this;
    }

    /**
     * The new status of the resource. Can be: `canceled` or `completed`. Specifying
     * `canceled` will attempt to hang up calls that are queued or ringing; however,
     * it will not affect calls already in progress. Specifying `completed` will
     * attempt to hang up a call even if it's already in progress..
     *
     * @param status The new status to update the call with.
     * @return this
     */
    public CallUpdater setStatus(final Call.UpdateStatus status) {
        this.status = status;
        return this;
    }

    /**
     * The URL that we call using the `fallback_method` if an error occurs when
     * requesting or executing the TwiML at `url`. If an `application_sid` parameter
     * is present, this parameter is ignored..
     *
     * @param fallbackUrl Fallback URL in case of error
     * @return this
     */
    public CallUpdater setFallbackUrl(final URI fallbackUrl) {
        this.fallbackUrl = fallbackUrl;
        return this;
    }

    /**
     * The URL that we call using the `fallback_method` if an error occurs when
     * requesting or executing the TwiML at `url`. If an `application_sid` parameter
     * is present, this parameter is ignored..
     *
     * @param fallbackUrl Fallback URL in case of error
     * @return this
     */
    public CallUpdater setFallbackUrl(final String fallbackUrl) {
        return setFallbackUrl(Promoter.uriFromString(fallbackUrl));
    }

    /**
     * The HTTP method that we should use to request the `fallback_url`. Can be:
     * `GET` or `POST` and the default is `POST`. If an `application_sid` parameter
     * is present, this parameter is ignored..
     *
     * @param fallbackMethod HTTP Method to use with fallback_url
     * @return this
     */
    public CallUpdater setFallbackMethod(final HttpMethod fallbackMethod) {
        this.fallbackMethod = fallbackMethod;
        return this;
    }

    /**
     * The URL we should call using the `status_callback_method` to send status
     * information to your application. If no `status_callback_event` is specified,
     * we will send the `completed` status. If an `application_sid` parameter is
     * present, this parameter is ignored. URLs must contain a valid hostname
     * (underscores are not permitted)..
     *
     * @param statusCallback The URL we should call to send status information to
     *                       your application
     * @return this
     */
    public CallUpdater setStatusCallback(final URI statusCallback) {
        this.statusCallback = statusCallback;
        return this;
    }

    /**
     * The URL we should call using the `status_callback_method` to send status
     * information to your application. If no `status_callback_event` is specified,
     * we will send the `completed` status. If an `application_sid` parameter is
     * present, this parameter is ignored. URLs must contain a valid hostname
     * (underscores are not permitted)..
     *
     * @param statusCallback The URL we should call to send status information to
     *                       your application
     * @return this
     */
    public CallUpdater setStatusCallback(final String statusCallback) {
        return setStatusCallback(Promoter.uriFromString(statusCallback));
    }

    /**
     * The HTTP method we should use when requesting the `status_callback` URL. Can
     * be: `GET` or `POST` and the default is `POST`. If an `application_sid`
     * parameter is present, this parameter is ignored..
     *
     * @param statusCallbackMethod HTTP Method to use to call status_callback
     * @return this
     */
    public CallUpdater setStatusCallbackMethod(final HttpMethod statusCallbackMethod) {
        this.statusCallbackMethod = statusCallbackMethod;
        return this;
    }

    /**
     * TwiML instructions for the call Twilio will use without fetching Twiml from
     * url. Twiml and url parameters are mutually exclusive.
     *
     * @param twiml TwiML instructions for the call
     * @return this
     */
    public CallUpdater setTwiml(final com.twilio.type.Twiml twiml) {
        this.twiml = twiml;
        return this;
    }

    /**
     * TwiML instructions for the call Twilio will use without fetching Twiml from
     * url. Twiml and url parameters are mutually exclusive.
     *
     * @param twiml TwiML instructions for the call
     * @return this
     */
    public CallUpdater setTwiml(final String twiml) {
        return setTwiml(Promoter.twimlFromString(twiml));
    }

    /**
     * The maximum duration of the call in seconds. Constraints depend on account
     * and configuration..
     *
     * @param timeLimit The maximum duration of the call in seconds.
     * @return this
     */
    public CallUpdater setTimeLimit(final Integer timeLimit) {
        this.timeLimit = timeLimit;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the update.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Updated Call
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Call update(final TwilioRestClient client) {
        this.pathAccountSid = this.pathAccountSid == null ? client.getAccountSid() : this.pathAccountSid;
        Request request = new Request(
            HttpMethod.POST,
            Domains.API.toString(),
            "/2010-04-01/Accounts/" + this.pathAccountSid + "/Calls/" + this.pathSid + ".json"
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Call update failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Call.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     *
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (url != null) {
            request.addPostParam("Url", url.toString());
        }

        if (method != null) {
            request.addPostParam("Method", method.toString());
        }

        if (status != null) {
            request.addPostParam("Status", status.toString());
        }

        if (fallbackUrl != null) {
            request.addPostParam("FallbackUrl", fallbackUrl.toString());
        }

        if (fallbackMethod != null) {
            request.addPostParam("FallbackMethod", fallbackMethod.toString());
        }

        if (statusCallback != null) {
            request.addPostParam("StatusCallback", statusCallback.toString());
        }

        if (statusCallbackMethod != null) {
            request.addPostParam("StatusCallbackMethod", statusCallbackMethod.toString());
        }

        if (twiml != null) {
            request.addPostParam("Twiml", twiml.toString());
        }

        if (timeLimit != null) {
            request.addPostParam("TimeLimit", timeLimit.toString());
        }
    }
}