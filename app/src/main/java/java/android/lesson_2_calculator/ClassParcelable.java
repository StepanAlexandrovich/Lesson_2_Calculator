package java.android.lesson_2_calculator;

import android.os.Parcel;
import android.os.Parcelable;

public class ClassParcelable implements Parcelable {
    public ClassParcelable() {
    }

    protected ClassParcelable(Parcel in) {
    }

    public static final Creator<ClassParcelable> CREATOR = new Creator<ClassParcelable>() {
        @Override
        public ClassParcelable createFromParcel(Parcel in) {
            return new ClassParcelable(in);
        }

        @Override
        public ClassParcelable[] newArray(int size) {
            return new ClassParcelable[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
    }
}
