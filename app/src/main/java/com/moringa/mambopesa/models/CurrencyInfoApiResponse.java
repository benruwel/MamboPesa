
package com.moringa.mambopesa.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class CurrencyInfoApiResponse {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("response")
    @Expose
    private List<CurrencyInfo> response = null;
    @SerializedName("info")
    @Expose
    private Info info;

    /**
     * No args constructor for use in serialization
     * 
     */
    public CurrencyInfoApiResponse() {
    }

    /**
     * 
     * @param msg
     * @param code
     * @param response
     * @param status
     * @param info
     */
    public CurrencyInfoApiResponse(Boolean status, Integer code, String msg, List<CurrencyInfo> response, Info info) {
        super();
        this.status = status;
        this.code = code;
        this.msg = msg;
        this.response = response;
        this.info = info;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<CurrencyInfo> getCurrencyInfo() {
        return response;
    }

    public void setCurrencyInfo(List<CurrencyInfo> response) {
        this.response = response;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

}
