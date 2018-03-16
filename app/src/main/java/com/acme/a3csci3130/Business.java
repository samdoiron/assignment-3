package com.acme.a3csci3130;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Class that defines how the data will be stored in the
 * Firebase database. This is converted to a JSON format.
 */
public class Business implements Serializable {
    public String key;
    public String number;
    public String name;
    public String primaryBusiness;
    public String address;
    public String provinceOrTerritory;

    public Business() {
    }

    public Business(
        String number,
        String name,
        String primaryBusiness,
        String address,
        String provinceOrTerritory
    ) {
        this.number = number;
        this.name = name;
        this.primaryBusiness = primaryBusiness;
        this.address = address;
        this.provinceOrTerritory = provinceOrTerritory;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();

        result.put("number", number);
        result.put("name", name);
        result.put("primaryBusiness", primaryBusiness);
        result.put("address", address);
        result.put("provinceOrTerritory", provinceOrTerritory);

        return result;
    }
}
