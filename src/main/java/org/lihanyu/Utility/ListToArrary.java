package org.lihanyu.Utility;

import org.lihanyu.domain.User;

import java.util.List;

public class ListToArrary {

    public static Object listToArray(List<User> users){
        Object[][] row = new Object[50][4];
        for (int i=0;i<users.size();i++){
            row[i][0]=users.get(i).getName();
            row[i][1]=users.get(i).getId();
            row[i][2]=users.get(i).getEmail();
            row[i][3]=users.get(i).getPhone();
        }
        return row;
    }
}
