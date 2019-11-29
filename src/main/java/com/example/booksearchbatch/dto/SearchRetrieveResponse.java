package com.example.booksearchbatch.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
/**
 * CallApiで取得する検索結果を格納
 */
public class SearchRetrieveResponse {
    private String numberOfRecords;
    private String nextRecordPosition;
    private String extraResponseData;
    private ArrayList<Record> records;
}
