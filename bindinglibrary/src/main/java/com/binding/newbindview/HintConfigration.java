package com.binding.newbindview;

public class HintConfigration {
    private int emptyResId;
    private String emptyMessage;
    private int errorResId;
    private String errorMessage;


    public HintConfigration(int emptyResId, String emptyMessage, int errorResId, String errorMessage) {
        this.emptyResId = emptyResId;
        this.emptyMessage = emptyMessage;
        this.errorResId = errorResId;
        this.errorMessage = errorMessage;
    }

    public int getEmptyResId() {
        return emptyResId;
    }

    public void setEmptyResId(int emptyResId) {
        this.emptyResId = emptyResId;
    }

    public String getEmptyMessage() {
        return emptyMessage;
    }

    public void setEmptyMessage(String emptyMessage) {
        this.emptyMessage = emptyMessage;
    }

    public int getErrorResId() {
        return errorResId;
    }

    public void setErrorResId(int errorResId) {
        this.errorResId = errorResId;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
