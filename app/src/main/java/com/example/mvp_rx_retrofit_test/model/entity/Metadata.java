package com.example.mvp_rx_retrofit_test.model.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Volt
 * on 10.11.2016.
 */

class Metadata {

    @SerializedName("generated")
    @Expose
    private long generated;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("api")
    @Expose
    private String api;
    @SerializedName("limit")
    @Expose
    private double limit;
    @SerializedName("offset")
    @Expose
    private double offset;
    @SerializedName("count")
    @Expose
    private int count;

    /**
     *
     * @return
     * The generated
     */
    public long getGenerated() {
        return generated;
    }

    /**
     *
     * @param generated
     * The generated
     */
    public void setGenerated(long generated) {
        this.generated = generated;
    }

    /**
     *
     * @return
     * The url
     */
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url
     * The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     *
     * @return
     * The title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     * The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     * The status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     *
     * @param status
     * The status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     *
     * @return
     * The api
     */
    public String getApi() {
        return api;
    }

    /**
     *
     * @param api
     * The api
     */
    public void setApi(String api) {
        this.api = api;
    }

    /**
     *
     * @return
     * The limit
     */
    public double getLimit() {
        return limit;
    }

    /**
     *
     * @param limit
     * The limit
     */
    public void setLimit(double limit) {
        this.limit = limit;
    }

    /**
     *
     * @return
     * The offset
     */
    public double getOffset() {
        return offset;
    }

    /**
     *
     * @param offset
     * The offset
     */
    public void setOffset(double offset) {
        this.offset = offset;
    }

    /**
     *
     * @return
     * The count
     */
    public int getCount() {
        return count;
    }

    /**
     *
     * @param count
     * The count
     */
    public void setCount(int count) {
        this.count = count;
    }

}
