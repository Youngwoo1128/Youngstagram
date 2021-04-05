package com.mac_available.youngstagram.valueobject;

public class UserVO {
    public String userId;
    public String userName;
    public String userFollower;
    public String userFollowing;
    public String userProfileImgUrl;

    public UserVO() {
    }

    public UserVO(String userId, String userName, String userFollower, String userFollowing, String userProfileImgUrl) {
        this.userId = userId;
        this.userName = userName;
        this.userFollower = userFollower;
        this.userFollowing = userFollowing;
        this.userProfileImgUrl = userProfileImgUrl;
    }
}
