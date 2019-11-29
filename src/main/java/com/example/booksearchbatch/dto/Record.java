package com.example.booksearchbatch.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/**
 * CallApiで取得するbookRecordを格納
 */
public class Record {
    private String recordSchema;
    private String recordPacking;
    private String recordData;
    private String recordPosition;

    public String getTitleFromRecordData() {
        String title = "";
        // TODO: recordDataからtitleを取得
        return title;
    }

    public String getCreatorFromRecordData() {
        String creator = "";
        // TODO: recordDataからcreatorを取得
        return creator;
    }

    public String getLanguageFromRecordData() {
        String language = "";
        // TODO: recordDataからlanguageを取得
        return language;
    }

    public String getPublisherFromRecordData() {
        String publisher = "";
        // TODO: recordDataからpublisherを取得
        return publisher;
    }

}
