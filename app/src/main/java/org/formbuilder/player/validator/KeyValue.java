/*
 * The MIT License (MIT)
 * Copyright (c) 2016 Ubiqueworks Ltd and contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify,
 * merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
 * TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT
 * SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN
 * ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE
 * OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */

package org.formbuilder.player.validator;

/**
 * Created by Balu on 23/08/2016.
 */
public class KeyValue {

    private String mKey;
    private Object mValue;

    public KeyValue(String key, Object value) {
        mKey = key;
        mValue = value;
    }

    public String getKey() {
        return mKey;
    }

    public <T> T getValue() {
        //noinspection unchecked
        return (T) mValue;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("KeyValue [");
        sb.append("mKey='").append(mKey).append('\'');
        sb.append(", mValue=").append(mValue);
        sb.append(']');
        return sb.toString();
    }
}
