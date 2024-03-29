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

package org.formbuilder.inject;

import org.formbuilder.inject.module.ActivityModule;
import org.formbuilder.inject.scope.ActivityScope;
import org.formbuilder.ui.activity.AdminUnlockDialogActivity;
import org.formbuilder.ui.activity.ConfigurationActivity;
import org.formbuilder.ui.activity.LoginActivity;
import org.formbuilder.ui.activity.MainActivity;
import org.formbuilder.ui.activity.ScriptPlayerActivity;
import org.formbuilder.ui.activity.SessionHistoryActivity;
import org.formbuilder.ui.fragment.ChecklistScreenFragment;
import org.formbuilder.ui.fragment.DataExportFragment;
import org.formbuilder.ui.fragment.FormScreenFragment;
import org.formbuilder.ui.fragment.ManagementScreenFragment;
import org.formbuilder.ui.fragment.ProgressScreenFragment;
import org.formbuilder.ui.fragment.SelectScreenFragment;
import org.formbuilder.ui.fragment.SessionDiagnosisFragment;
import org.formbuilder.ui.fragment.SessionHistoryListFragment;
import org.formbuilder.ui.fragment.SessionSummaryFragment;
import org.formbuilder.ui.fragment.SimpleListScreenFragment;
import org.formbuilder.ui.fragment.SummaryFragment;
import org.formbuilder.ui.fragment.TimerScreenFragment;
import org.formbuilder.ui.fragment.YesNoScreenFragment;

import dagger.Subcomponent;

/**
 * Created by Balu Giaccone on 06/04/16.
 */
@ActivityScope
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(ConfigurationActivity activity);

    void inject(LoginActivity activity);

    void inject(MainActivity activity);

    void inject(ScriptPlayerActivity activity);

    void inject(SessionHistoryActivity activity);

    void inject(ChecklistScreenFragment fragment);

    void inject(AdminUnlockDialogActivity fragment);

    void inject(DataExportFragment fragment);

    void inject(FormScreenFragment fragment);

    void inject(ManagementScreenFragment fragment);

    void inject(ProgressScreenFragment fragment);

    void inject(SelectScreenFragment fragment);

    void inject(SessionDiagnosisFragment fragment);

    void inject(SessionHistoryListFragment fragment);

    void inject(SessionSummaryFragment fragment);

    void inject(SummaryFragment fragment);

    void inject(SimpleListScreenFragment fragment);

    void inject(TimerScreenFragment fragment);

    void inject(YesNoScreenFragment fragment);

}