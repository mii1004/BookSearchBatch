package com.example.booksearchbatch;

import com.example.booksearchbatch.dto.Record;
import org.springframework.batch.item.ItemProcessor;

public class BookItemProcessor implements ItemProcessor<Record, Book> {
    @Override
    public Book process(Record record) throws Exception {
        String title = record.getTitleFromRecordData();
        String creator = record.getCreatorFromRecordData();
        String publisher = record.getPublisherFromRecordData();
        String subject = record.getSubjectFromRecordData();

        return new Book(title, creator, publisher, subject);
    }
}
