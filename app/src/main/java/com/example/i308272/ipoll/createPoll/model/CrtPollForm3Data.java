package com.example.i308272.ipoll.createPoll.model;

/**
 * Created by I308272 on 12/26/2016.
 */

public class CrtPollForm3Data {
    boolean _isName;
    boolean _isNameOptional;
    boolean _isAge;
    boolean _isAgeOptional;
    boolean _isGender;
    boolean _isGenderOptional;
    boolean _isLocation;
    boolean _isLocationOptional;

    public CrtPollForm3Data() {
        _isNameOptional = false;
        _isAgeOptional = false;
        _isGenderOptional = false;
    }

    public CrtPollForm3Data(CrtPollForm3Data formData) {
        this._isName = formData._isName;
        this._isNameOptional = formData._isNameOptional;
        this._isAge = formData._isAge;
        this._isAgeOptional = formData._isAgeOptional;
        this._isGender = formData._isGender;
        this._isGenderOptional = formData._isGenderOptional;
        this._isLocation = formData._isLocation;
        this._isLocationOptional = formData._isLocationOptional;
    }

    public boolean is_isName() {
        return _isName;
    }

    public void set_isName(boolean _isName) {
        this._isName = _isName;
    }

    public boolean is_isNameOptional() {
        return _isNameOptional;
    }

    public void set_isNameOptional(boolean _isNameOptional) {
        this._isNameOptional = _isNameOptional;
    }

    public boolean is_isAge() {
        return _isAge;
    }

    public void set_isAge(boolean _isAge) {
        this._isAge = _isAge;
    }

    public boolean is_isAgeOptional() {
        return _isAgeOptional;
    }

    public void set_isAgeOptional(boolean _isAgeOptional) {
        this._isAgeOptional = _isAgeOptional;
    }

    public boolean is_isGender() {
        return _isGender;
    }

    public void set_isGender(boolean _isGender) {
        this._isGender = _isGender;
    }

    public boolean is_isGenderOptional() {
        return _isGenderOptional;
    }

    public void set_isGenderOptional(boolean _isGenderOptional) {
        this._isGenderOptional = _isGenderOptional;
    }

    public boolean is_isLocation() {
        return _isLocation;
    }

    public void set_isLocation(boolean _isLocation) {
        this._isLocation = _isLocation;
    }

    public boolean isLocationOptional() {
        return _isLocationOptional;
    }

    public void set_isLocationOptional(boolean _isLocationOptional) {
        this._isLocationOptional = _isLocationOptional;
    }
}
