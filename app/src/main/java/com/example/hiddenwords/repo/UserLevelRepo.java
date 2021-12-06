package com.example.hiddenwords.repo;

import androidx.annotation.NonNull;

import com.example.hiddenwords.model.UserLevel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UserLevelRepo {
    private final DatabaseReference databaseReference;
    private static String KEY;

    public UserLevelRepo() {
        databaseReference = FirebaseDatabase.getInstance().getReference("levels");
        KEY = databaseReference.push().getKey();
    }

    public void save(UserLevel userLevel) {
        databaseReference.child(KEY).setValue(userLevel);
    }

    public UserLevel get(String uid) {
        databaseReference.child(KEY).setValue(new UserLevel(uid, 5));
        return (UserLevel) databaseReference.child("UserLevel").child(uid).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (task.isSuccessful()) {
                    System.out.println(1);
                } else {
                    System.out.println(2);
                }
            }
        }).getResult().getValue();
        //return new UserLevel(FirebaseAuth.getInstance().getUid(), 1);
    }

    public void update(UserLevel userLevel) {
        databaseReference.child(userLevel.getUid()).setValue(userLevel);
    }
}
