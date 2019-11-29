package com.example.booksearchbatch;


import com.example.booksearchbatch.dto.SearchRetrieveResponse;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestOperations;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * 国立国会図書館サーチAPIから書籍情報を検索する
 * (そのうちバッチに取り込みたい)
 *
 * 参考: https://iss.ndl.go.jp/information/api/
 */
public class CallApi {
    private final RestOperations restOperations;

    public CallApi(RestTemplateBuilder restTemplateBuilder) {
        restOperations = restTemplateBuilder.build();
    }

    public SearchRetrieveResponse callBookSearchApi(String keyword) throws URISyntaxException {
        URI url = new URI("http://iss.ndl.go.jp/api/sru?operation=searchRetrieve&query=title all ¥“" + keyword + "¥” AND from 2019");
        SearchRetrieveResponse response = restOperations.getForObject(url, SearchRetrieveResponse.class);

        return response;
    }
}
