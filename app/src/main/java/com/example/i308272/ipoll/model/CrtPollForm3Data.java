package com.example.i308272.ipoll.model;

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
    boolean is_isLocationOptional;

    public CrtPollForm3Data() {
        _isNameOptional = false;
        _isAgeOptional = false;
        _isGenderOptional = false;
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

    public boolean is_isLocationOptional() {
        return is_isLocationOptional;
    }

    public void setIs_isLocationOptional(boolean is_isLocationOptional) {
        this.is_isLocationOptional = is_isLocationOptional;
    }
}
