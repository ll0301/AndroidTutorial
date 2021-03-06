package com.jroomstudio.blogupload.retrofit;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;

import com.google.android.gms.common.internal.Objects;
import com.google.gson.annotations.SerializedName;

/**
 * 회원가입을 위한 Member 불변 모델클래스
 **/
@Entity(tableName = "member")
public class Member {

    /**
     * 원격 데이터베이스에서 id로 사용될 중복될 수 없는 값
     **/
    @NonNull
    @ColumnInfo(name = "member_email")
    @SerializedName("member_email")
    private final String mEmail;

    /**
     * 사용자의 이름
     **/
    @NonNull
    @ColumnInfo(name = "member_name")
    @SerializedName("member_name")
    private final String mName;

    /**
     * 사용자의 이미지 url
     **/
    @NonNull
    @ColumnInfo(name = "photo_url")
    @SerializedName("photo_url")
    private final String mPhotoUrl;

    /**
     * 자동으로 생성 될 사용자의 암호화될 패스워드
     * 구글, 페이스북 으로부터 전달받은 id 가 저장된다.
     **/
    @NonNull
    @ColumnInfo(name = "auto_password")
    @SerializedName("auto_password")
    private final String mAutoPassword;

    /**
     * 다크테마 상태
     **/
    @ColumnInfo(name = "dark_theme")
    @SerializedName("dark_theme")
    private final boolean mDarkTheme;

    /**
     * 푸쉬 알림 상태
     **/
    @ColumnInfo(name = "push_notice")
    @SerializedName("push_notice")
    private final boolean mPushNotice;

    /**
     * 로그인 타입 (1 페이스북 / 0 구글 )
     **/
    @ColumnInfo(name = "login_type")
    @SerializedName("login_type")
    private final int mLoginType;

    /**
     * 푸쉬 알림 상태
     **/
    @ColumnInfo(name = "login_status")
    @SerializedName("login_status")
    private final boolean mLoginStatus;



    /**
     * 생성자
     **/
    public Member(@NonNull String email,
                  @NonNull String name,
                  @NonNull String photoUrl,
                  @NonNull String autoPassword,
                  boolean darkTheme,
                  boolean pushNotice,
                  int loginType,
                  boolean loginStatus){
        this.mEmail = email;
        this.mName = name;
        this.mPhotoUrl = photoUrl;
        this.mAutoPassword = autoPassword;
        this.mDarkTheme = darkTheme;
        this.mPushNotice = pushNotice;
        this.mLoginType = loginType;
        this.mLoginStatus = loginStatus;
    }

    @NonNull
    public String getEmail() { return mEmail; }

    @NonNull
    public String getName() { return mName; }

    @NonNull
    public String getPhotoUrl() { return mPhotoUrl; }

    @NonNull
    public String getAutoPassword(){ return mAutoPassword; }

    public boolean isDarkTheme(){ return mDarkTheme; }

    public boolean isPushNotice(){ return mPushNotice; }

    public boolean isLoginStatus(){ return mLoginStatus; }

    public int getLoginType(){ return mLoginType; }

    @Override
    public boolean equals(@Nullable Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Member member = (Member) obj;
        return  Objects.equal(mEmail, member.getEmail()) &&
                Objects.equal(mName, member.getName()) &&
                Objects.equal(mPhotoUrl, member.getPhotoUrl()) &&
                Objects.equal(mAutoPassword, member.getAutoPassword()) &&
                Objects.equal(mDarkTheme, member.isDarkTheme()) &&
                Objects.equal(mPushNotice, member.isPushNotice()) &&
                Objects.equal(mLoginStatus, member.isLoginStatus()) &&
                Objects.equal(mLoginType, member.getLoginType());
    }

    @Override
    public int hashCode() { return Objects.hashCode(mEmail,mName); }

    @NonNull
    @Override
    public String toString() {
        return"member_email : "+ mEmail+"\n"+
                "member_name : "+mName+"\n" +
                "photo_url : "+mPhotoUrl+"\n" +
                "auto_password : "+mAutoPassword+"\n" +
                "dark_theme : "+mDarkTheme+"\n" +
                "push_notice : "+mPushNotice+"\n" +
                "login_status : "+mLoginStatus+"\n" +
                "login_type : "+mLoginType+"\n";
    }

}
