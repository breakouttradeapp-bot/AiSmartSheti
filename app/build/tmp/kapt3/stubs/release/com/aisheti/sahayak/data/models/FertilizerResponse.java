package com.aisheti.sahayak.data.models;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0005H\u00c6\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0005H\u00c6\u0003JU\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010 \u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\"\u001a\u00020#H\u00d6\u0001J\t\u0010$\u001a\u00020\u0005H\u00d6\u0001R\u0016\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0016\u0010\f\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000f\u00a8\u0006%"}, d2 = {"Lcom/aisheti/sahayak/data/models/FertilizerResponse;", "", "success", "", "crop", "", "stage", "recommendations", "", "Lcom/aisheti/sahayak/data/models/FertilizerItem;", "applicationMethod", "timing", "warnings", "(ZLjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getApplicationMethod", "()Ljava/lang/String;", "getCrop", "getRecommendations", "()Ljava/util/List;", "getStage", "getSuccess", "()Z", "getTiming", "getWarnings", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "app_release"})
public final class FertilizerResponse {
    @com.google.gson.annotations.SerializedName(value = "success")
    private final boolean success = false;
    @com.google.gson.annotations.SerializedName(value = "crop")
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String crop = null;
    @com.google.gson.annotations.SerializedName(value = "stage")
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String stage = null;
    @com.google.gson.annotations.SerializedName(value = "recommendations")
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.aisheti.sahayak.data.models.FertilizerItem> recommendations = null;
    @com.google.gson.annotations.SerializedName(value = "application_method")
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String applicationMethod = null;
    @com.google.gson.annotations.SerializedName(value = "timing")
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String timing = null;
    @com.google.gson.annotations.SerializedName(value = "warnings")
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String warnings = null;
    
    public FertilizerResponse(boolean success, @org.jetbrains.annotations.NotNull()
    java.lang.String crop, @org.jetbrains.annotations.NotNull()
    java.lang.String stage, @org.jetbrains.annotations.NotNull()
    java.util.List<com.aisheti.sahayak.data.models.FertilizerItem> recommendations, @org.jetbrains.annotations.NotNull()
    java.lang.String applicationMethod, @org.jetbrains.annotations.NotNull()
    java.lang.String timing, @org.jetbrains.annotations.NotNull()
    java.lang.String warnings) {
        super();
    }
    
    public final boolean getSuccess() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCrop() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getStage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.aisheti.sahayak.data.models.FertilizerItem> getRecommendations() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getApplicationMethod() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTiming() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getWarnings() {
        return null;
    }
    
    public final boolean component1() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.aisheti.sahayak.data.models.FertilizerItem> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.aisheti.sahayak.data.models.FertilizerResponse copy(boolean success, @org.jetbrains.annotations.NotNull()
    java.lang.String crop, @org.jetbrains.annotations.NotNull()
    java.lang.String stage, @org.jetbrains.annotations.NotNull()
    java.util.List<com.aisheti.sahayak.data.models.FertilizerItem> recommendations, @org.jetbrains.annotations.NotNull()
    java.lang.String applicationMethod, @org.jetbrains.annotations.NotNull()
    java.lang.String timing, @org.jetbrains.annotations.NotNull()
    java.lang.String warnings) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}