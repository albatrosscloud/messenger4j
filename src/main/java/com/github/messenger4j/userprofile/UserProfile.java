package com.github.messenger4j.userprofile;

import java.util.Optional;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

/**
 * @author Max Grabenhorst
 * @since 1.0.0
 */
@ToString
@EqualsAndHashCode
public final class UserProfile {

    private final String firstName;
    private final String lastName;
    private final String profilePicture;
    private final Optional<String> locale;
    private final Optional<Float> timezoneOffset;
    private final Optional<Gender> gender;

    public UserProfile(@NonNull String firstName, @NonNull String lastName, @NonNull String profilePicture,
            @NonNull Optional<String> locale, Optional<Float> timezoneOffset, @NonNull Optional<Gender> gender) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.profilePicture = profilePicture;
        this.locale = locale;
        this.timezoneOffset = timezoneOffset;
        this.gender = gender;
    }

    public String firstName() {
        return firstName;
    }

    public String lastName() {
        return lastName;
    }

    public String profilePicture() {
        return profilePicture;
    }

    public Optional<String> locale() {
        return locale;
    }

    public Optional<Float> timezoneOffset() {
        return timezoneOffset;
    }

    public Optional<Gender> gender() {
        return gender;
    }

    /**
     * @since 1.0.0
     */
    public enum Gender {
        MALE, FEMALE
    }
}
