package com.example.mytravelapp.utilities;

import com.google.gson.annotations.SerializedName;

public class OAuthData {
    @SerializedName("scope")
    private String scope;

    @SerializedName("token_type")
    private String tokenType;

    @SerializedName("expires_in")
    private int expiresIn;

    @SerializedName("refresh_token")
    private String refreshToken;

    @SerializedName("access_token")
    private String accessToken;

    public OAuthData(String scope, String tokenType, int expiresIn, String refreshToken, String accessToken) {
        this.scope = scope;
        this.tokenType = tokenType;
        this.expiresIn = expiresIn;
        this.refreshToken = refreshToken;
        this.accessToken = accessToken;
    }

    public String getScope() {
        return scope;
    }

    public String getTokenType() {
        return tokenType;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public String getAccessToken() {
        return accessToken;
    }
}
