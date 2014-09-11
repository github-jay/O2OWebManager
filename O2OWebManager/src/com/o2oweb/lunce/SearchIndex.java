package com.o2oweb.lunce;

import java.util.List;

import org.apache.lucene.document.Document;
import org.apache.lucene.search.ScoreDoc;

public interface SearchIndex {
	public Object[] searchScoreDoc(String keyword, ScoreDoc lasthit) throws Exception;
	public List<Document> searchDoc(Object[] ScoreDocs) throws Exception;
}
