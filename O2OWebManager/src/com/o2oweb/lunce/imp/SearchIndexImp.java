package com.o2oweb.lunce.imp;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.BooleanClause.Occur;
import org.apache.lucene.search.Query;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.springframework.stereotype.Component;

import com.o2oweb.lunce.SearchIndex;

@Component("SearchIndex")
public class SearchIndexImp implements SearchIndex {

	private final static String indexPath = "Index";
	private final static String AnalysisPath = "Analysis";
	private static SmartChineseAnalyzer analyzer=null;
	private static Directory directory=null;
	private static IndexReader reader=null;
	private static IndexSearcher searcher=null;
	private List<Document> result=null;
	
	public SearchIndexImp(){
		
		
		
	}
	
	public Object[] searchScoreDoc(String keyword, ScoreDoc lasthit) throws IOException {
		result = new LinkedList<Document>();
		// TODO Auto-generated method stub
		checkIndex();
		Query topQuery = getQuery(keyword);
		
		TopDocs docs = searcher.searchAfter(lasthit, topQuery, 10);
		ScoreDoc[] hits = docs.scoreDocs;
		
		return hits;
	}

	private void checkIndex() {
		if(directory == null){
			try {
				creatSearch();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				throw new RuntimeException("搜索失败");
			}
		}
	}
	private void creatSearch() throws Exception{
		directory = FSDirectory.open(new File(indexPath));
		reader=  DirectoryReader.open(directory);
		searcher = new IndexSearcher(reader);
		analyzer = new SmartChineseAnalyzer(Version.LUCENE_47);
	}
	private BooleanQuery getQuery(String keyword) {
		
		BooleanQuery topQuery = new BooleanQuery();
		QueryParser queryparser = new QueryParser(Version.LUCENE_47, "", analyzer);
		queryparser.setDefaultOperator(QueryParser.Operator.OR);
		queryparser.setAllowLeadingWildcard(true);
		if (keyword.matches("[a-z]+")) {
			System.out.println("pinyin is create");
			Query pinyinQuery = queryparser.createBooleanQuery("pinyinname",
					keyword);
			topQuery.add(pinyinQuery, Occur.SHOULD);
		} else {
			Query nameQueyr = queryparser.createBooleanQuery("name", keyword);
			topQuery.add(nameQueyr, Occur.SHOULD);
		}
		Query attrQuery = queryparser.createBooleanQuery("attribute", keyword);
		topQuery.add(attrQuery, Occur.SHOULD);
		return topQuery;
	}


	public List<Document> searchDoc(Object[] ScoreDocs) throws IOException {
		// TODO Auto-generated method stub
		checkIndex();
		result = new LinkedList<Document>();
		for (Object obj : ScoreDocs) {
			ScoreDoc scoreDoc = (ScoreDoc) obj;
			Document document = searcher.doc(scoreDoc.doc);
			result.add(document);
		}
		return result;
	}

}
