package document.igt.com.androidnewrecycler.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Anup.Lal on 15-06-2015.
 */
public class ApplicationData implements Parcelable,Parcelable.Creator<ApplicationData> {

    private String appName;
    private String appDescription;
    private  int appRating;
    private int appLogoResourceId;

    public ApplicationData(String appName,String appDescription,int appRating,int appLogoResourceId)
    {
        this.appName=appName;
        this.appDescription=appDescription;
        this.appRating=appRating;
        this.appLogoResourceId=appLogoResourceId;
    }

    private ApplicationData(Parcel parcel)
    {
        appLogoResourceId=parcel.readInt();
        appName=parcel.readString();
        appDescription=parcel.readString();
        appRating=parcel.readInt();
    }


    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppDescription() {
        return appDescription;
    }

    public void setAppDescription(String appDescription) {
        this.appDescription = appDescription;
    }

    public int getAppRating() {
        return appRating;
    }

    public void setAppRating(int appRating) {
        this.appRating = appRating;
    }

    public int getAppLogoResourceId() {
        return appLogoResourceId;
    }

    public void setAppLogoResourceId(int appLogoResourceId) {
        this.appLogoResourceId = appLogoResourceId;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeInt(appLogoResourceId);
        parcel.writeString(appName);
        parcel.writeString(appDescription);
        parcel.writeInt(appRating);

    }

    @Override
    public ApplicationData createFromParcel(Parcel parcel) {
        return new ApplicationData(parcel);
    }

    @Override
    public ApplicationData[] newArray(int i) {
        return new ApplicationData[i];
    }
}
