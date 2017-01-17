package com.example.i308272.ipoll.createPoll.model;

import java.util.ArrayList;

/**
 * Created by I308272 on 12/26/2016.
 */

public class CrtPollForm2Data {
    ArrayList<String> _options;
    boolean _allowComments;
    boolean _multiOptions;

    public CrtPollForm2Data() {
        _options = new ArrayList<String>();
        _allowComments = false;
        _multiOptions = false;
    }

    public CrtPollForm2Data(CrtPollForm2Data formdata){
        _options = new ArrayList<String>();
        _options.addAll(formdata.get_options());
        _allowComments = formdata.is_allowComments();
        _multiOptions = formdata.is_multiOptions();
    }


    public ArrayList<String> get_options() {
        return _options;
    }

    public void set_option(String option) {
        this._options.add(option);
    }

    public boolean is_allowComments() {
        return _allowComments;
    }

    public void set_allowComments(boolean _allowComments) {
        this._allowComments = _allowComments;
    }

    public boolean is_multiOptions() {
        return _multiOptions;
    }

    public void set_multiOptions(boolean _multiOptions) {
        this._multiOptions = _multiOptions;
    }
}
