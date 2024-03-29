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

package org.formbuilder.export;

import android.content.Context;
import android.print.PrintManager;

import org.formbuilder.model.firebase.Diagnosis;
import org.formbuilder.model.realm.Session;
import org.formbuilder.model.realm.SessionEntry;
import org.formbuilder.support.datastore.RealmStore;

import java.util.List;

import io.realm.Realm;

/**
 * Created by Balu on 22/09/2016.
 */

public class SummaryExportManager {

    public static void print(Context context, Realm realm, String sessionId, List<SessionEntry> entries, List<Diagnosis> diagnoses) {
        Session session = RealmStore.loadSession(realm, sessionId);
        PrintManager printManager = (PrintManager) context.getSystemService(Context.PRINT_SERVICE);
        printManager.print(sessionId, new SummaryPrintDocumentAdapter(context, session, entries, diagnoses), null);
    }

}
