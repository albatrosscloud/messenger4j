package com.github.messenger4j.userprofile;

import static com.github.messenger4j.internal.gson.GsonUtil.Constants.PROP_FIRST_NAME;
import static com.github.messenger4j.internal.gson.GsonUtil.Constants.PROP_GENDER;
import static com.github.messenger4j.internal.gson.GsonUtil.Constants.PROP_LAST_NAME;
import static com.github.messenger4j.internal.gson.GsonUtil.Constants.PROP_LOCALE;
import static com.github.messenger4j.internal.gson.GsonUtil.Constants.PROP_PROFILE_PIC;
import static com.github.messenger4j.internal.gson.GsonUtil.Constants.PROP_TIMEZONE;
import static com.github.messenger4j.internal.gson.GsonUtil.getPropertyAsFloat;
import static com.github.messenger4j.internal.gson.GsonUtil.getPropertyAsString;
import static java.util.Optional.empty;
import com.google.gson.JsonObject;
import java.util.Optional;

/**
 * @author Max Grabenhorst
 * @since 1.0.0
 */
public final class UserProfileFactory {

    private UserProfileFactory() {
    }

    public static UserProfile create(JsonObject jsonObject) {
        final String firstName = getPropertyAsString(jsonObject, PROP_FIRST_NAME)
                .orElseThrow(IllegalArgumentException::new);
        final String lastName = getPropertyAsString(jsonObject, PROP_LAST_NAME)
                .orElseThrow(IllegalArgumentException::new);
        final String profilePic = getPropertyAsString(jsonObject, PROP_PROFILE_PIC)
                .orElseThrow(IllegalArgumentException::new);

        final Optional<String> locale = getPropertyAsString(jsonObject, PROP_LOCALE)
                .orElse(empty());

        final Optional<Float> timezoneOffset = getPropertyAsFloat(jsonObject, PROP_TIMEZONE)
                .orElse(empty());

        final Optional<UserProfile.Gender> gender = getPropertyAsString(jsonObject, PROP_GENDER)
                .map(String::toUpperCase)
                .map(UserProfile.Gender::valueOf)
                .orElse(empty());

        return new UserProfile(firstName, lastName, profilePic, locale, timezoneOffset, gender);
    }
}
