package com.github.messenger4j.v3.receive.factories;

import static com.github.messenger4j.internal.JsonHelper.Constants.PROP_ID;
import static com.github.messenger4j.internal.JsonHelper.Constants.PROP_OPTIN;
import static com.github.messenger4j.internal.JsonHelper.Constants.PROP_RECIPIENT;
import static com.github.messenger4j.internal.JsonHelper.Constants.PROP_REF;
import static com.github.messenger4j.internal.JsonHelper.Constants.PROP_SENDER;
import static com.github.messenger4j.internal.JsonHelper.Constants.PROP_TIMESTAMP;
import static com.github.messenger4j.internal.JsonHelper.getPropertyAsInstant;
import static com.github.messenger4j.internal.JsonHelper.getPropertyAsString;
import static com.github.messenger4j.internal.JsonHelper.hasProperty;

import com.github.messenger4j.v3.receive.OptInEvent;
import com.google.gson.JsonObject;
import java.time.Instant;
import java.util.Optional;

/**
 * @author Max Grabenhorst
 * @since 1.0.0
 */
public final class OptInEventFactory implements BaseEventFactory<OptInEvent> {

    @Override
    public boolean isResponsible(JsonObject messagingEvent) {
        return hasProperty(messagingEvent, PROP_OPTIN);
    }

    @Override
    public OptInEvent createEventFromJson(JsonObject messagingEvent) {
        final String senderId = getPropertyAsString(messagingEvent, PROP_SENDER, PROP_ID)
                .orElseThrow(IllegalArgumentException::new);
        final String recipientId = getPropertyAsString(messagingEvent, PROP_RECIPIENT, PROP_ID)
                .orElseThrow(IllegalArgumentException::new);
        final Instant timestamp = getPropertyAsInstant(messagingEvent, PROP_TIMESTAMP)
                .orElseThrow(IllegalArgumentException::new);
        final Optional<String> refPayload = getPropertyAsString(messagingEvent, PROP_OPTIN, PROP_REF);

        return new OptInEvent(senderId, recipientId, timestamp, refPayload);
    }
}
