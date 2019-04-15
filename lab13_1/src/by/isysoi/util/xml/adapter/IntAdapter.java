package by.isysoi.util.xml.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class IntAdapter extends XmlAdapter<String, Integer> {

    @Override
    public String marshal(Integer value) throws Exception {
        return String.valueOf(value);
    }

    @Override
    public Integer unmarshal(String storedValue) throws Exception {
        return Integer.valueOf(storedValue);
    }
}