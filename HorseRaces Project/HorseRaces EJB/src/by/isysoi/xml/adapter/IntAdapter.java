package by.isysoi.xml.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * xml adapter to convert int to String and vice versa
 *
 * @author Ilya Sysoi
 * @version 1.0.0
 */
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