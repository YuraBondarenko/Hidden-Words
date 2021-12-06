package com.example.hiddenwords.service;

import com.example.hiddenwords.model.UserLevel;
import com.example.hiddenwords.repo.UserLevelRepo;
import com.google.firebase.auth.FirebaseAuth;

public class UserLevelService {
    private final UserLevelRepo userLevelRepo;

    public UserLevelService(UserLevelRepo userLevelRepo) {
        this.userLevelRepo = userLevelRepo;
    }

    public int getLevel(String uid) {
        return get(uid).getLevel();
    }

    public UserLevel get(String uid) {
        UserLevel userLevel = userLevelRepo.get(uid);
        if (userLevel == null) {
            save(new UserLevel(uid, 1));
            return userLevelRepo.get(uid);
        }
        return userLevel;


    }

    public void save(UserLevel userLevel) {
        userLevelRepo.save(userLevel);
    }

    public void update(UserLevel userLevel) {
        userLevelRepo.update(userLevel);
    }

}
