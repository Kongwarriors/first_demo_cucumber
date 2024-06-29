package Constants;

public enum EnumURL {
    BASE_URL ("https://fptshop.com.vn/");
    private final String url;
    EnumURL(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
