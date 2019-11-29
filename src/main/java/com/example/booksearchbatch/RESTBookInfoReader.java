package com.example.booksearchbatch;


import com.example.booksearchbatch.dto.Record;
import com.example.booksearchbatch.dto.SearchRetrieveResponse;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestOperations;
import org.springframework.batch.item.ItemReader;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * 国立国会図書館サーチAPIから書籍情報を検索/取得する
 * 参考: https://iss.ndl.go.jp/information/api/
 */
public class RESTBookInfoReader implements ItemReader<Record> {
    private final RestOperations restOperations;

    private int nextBookIndex;
    private List<Record> bookRecordList;

    public RESTBookInfoReader(RestTemplateBuilder restTemplateBuilder) {
        restOperations = restTemplateBuilder.build();
    }

    @Override
    public Record read() throws Exception {
        Record nextRecord = null;

        if (bookRecordList == null) {
            bookRecordList = callBookSearchApi();
        }

        if (nextBookIndex < bookRecordList.size()) {
            nextRecord = bookRecordList.get(nextBookIndex);
            nextBookIndex++;
        }
        return nextRecord;
    }

    public List<Record> callBookSearchApi() throws URISyntaxException {
        // 本のタイトルにJavaを含む && 2019年以降に出版された書籍を検索
        URI url = new URI("http://iss.ndl.go.jp/api/sru?operation=searchRetrieve&query=title all ¥“Java¥” AND from 2019");
        SearchRetrieveResponse response = restOperations.getForObject(url, SearchRetrieveResponse.class);

        // TODO: APIの最大取得件数が200件なので、201件目〜は再度APIを叩いて取得が必要

        return response.getRecords();
    }
}
