package org.formbuilder.diagnosis;

import org.formbuilder.model.firebase.FileInfo;

/**
 * Created by Balu on 21/01/2017.
 */

public class DiagnosisManagement {

    public String text;
    public FileInfo fileInfo;

    public DiagnosisManagement(String text, FileInfo fileInfo) {
        this.text = text;
        this.fileInfo = fileInfo;
    }

}
