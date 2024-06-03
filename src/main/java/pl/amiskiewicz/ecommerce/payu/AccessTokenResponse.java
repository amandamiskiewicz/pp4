package pl.amiskiewicz.ecommerce.payu;

public class AccessTokenResponse {
    String access_token;

    public String getAccess_token(){
        return access_token;
    }

    public AccessTokenResponse setAccess_token(String accessToken){
        this.access_token = accessToken;
        return this;
    }
}
