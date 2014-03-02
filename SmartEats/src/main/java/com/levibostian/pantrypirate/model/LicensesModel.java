package com.levibostian.pantrypirate.model;

import com.levibostian.pantrypirate.vo.License;

import java.util.ArrayList;

public class LicensesModel {
    private ArrayList<License> mLicenses;

    public LicensesModel() {
        mLicenses = new ArrayList<License>();

        setUpLicenses();
    }

    private void setUpLicenses() {
        mLicenses.add(new License("Android-RobotoTextView", "https://github.com/johnkil/Android-RobotoTextView"));
        mLicenses.add(new License("Tomáš Procházka ImageView", "https://gist.github.com/tprochazka/5486822"));
    }

    public ArrayList<License> getLicenses() {
        return mLicenses;
    }

    public License getLicense(int position) {
        return mLicenses.get(position);
    }
}
