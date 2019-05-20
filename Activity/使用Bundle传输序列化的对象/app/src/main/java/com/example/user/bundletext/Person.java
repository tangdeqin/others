package com.example.user.bundletext;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by user on 19-5-20.
 */

public class Person implements Parcelable {
    private String name;
    private String age;

    Person(String name,String age){
        this.name = name;
        this.age = age;
    }

    String getName(){
        return this.name;
    }
    String getAge(){
        return this.age;
    }

    protected Person(Parcel in) {
        name = in.readString();
        age = in.readString();
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(age);
    }
}
