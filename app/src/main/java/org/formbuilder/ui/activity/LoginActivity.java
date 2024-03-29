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

package org.formbuilder.ui.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.jakewharton.rxbinding.widget.RxTextView;

import org.neotree.R;
import org.formbuilder.inject.ActivityComponent;
import org.formbuilder.inject.module.ActivityModule;
import org.formbuilder.support.ValidationHelper;
import org.formbuilder.support.rx.RxFirebase;
import org.formbuilder.support.rx.RxHelper;
import org.formbuilder.ui.core.EnhancedActivity;

import butterknife.BindView;
import butterknife.OnClick;
import rx.Observable;

/**
 * Created by Balu on 02/08/2016.
 */
public class LoginActivity extends EnhancedActivity<ActivityComponent> {

    @BindView(R.id.login_error_text)
    TextView mErrorText;
    @BindView(R.id.login_email)
    EditText mEmailInput;
    @BindView(R.id.login_password)
    EditText mPasswordInput;
    @BindView(R.id.login_action_button)
    Button mLoginAction;

    private FirebaseAuth mFirebaseAuth;

    @Override
    protected int getActivityViewId() {
        return R.layout.activity_login;
    }

    @Override
    public void onCreateAfterSetContentView(Bundle savedInstanceState) {
        super.onCreateAfterSetContentView(savedInstanceState);

        mFirebaseAuth = FirebaseAuth.getInstance();

        // Validate fields
        Observable<Boolean> validEmailObservable = RxTextView.textChanges(mEmailInput)
                .map(inputText -> (inputText.length() > 0 && ValidationHelper.isValidEmail(inputText)))
                .distinctUntilChanged();

        Observable<Boolean> validPasswordObservable = RxTextView.textChanges(mPasswordInput)
                .map(inputText -> (inputText.length() > 0))
                .distinctUntilChanged();

        // Enable login button
        addSubscription(Observable.combineLatest(
                validEmailObservable, validPasswordObservable,
                (emailValid, passwordValid) -> emailValid && passwordValid)
                .distinctUntilChanged()
                .subscribe(valid -> mLoginAction.setEnabled(valid)));

        if (getResources().getBoolean(R.bool.enable_dummy_data)) {
            mEmailInput.setText("balakrishnan3088@gmail.com");
            mPasswordInput.setText("Test123!@#");
        }
    }

    @Override
    protected ActivityComponent setupActivityComponent() {
        return getApplicationComponent().plus(new ActivityModule(this));
    }

    @Override
    public void onBackPressed() {
        setResult(RESULT_CANCELED);
        super.onBackPressed();
    }

    @OnClick(R.id.login_action_button)
    public void onLoginActionClick() {
        final String username = mEmailInput.getText().toString();
        final String password = mPasswordInput.getText().toString();

        Log.d(logTag(), "Signing in with email and password");
        addSubscription(
                RxFirebase.authenticateWithEmailAndPassword(mFirebaseAuth, username, password)
                        .compose(RxHelper.applySchedulers())
                        .subscribe(authResult -> {
                            Log.d(logTag(), "signInWithEmailAndPassword:success");
                            setResult(RESULT_OK);
                            finish();
                        }, throwable -> {
                            mErrorText.setText(throwable.getMessage());
                        })
        );
    }

}
